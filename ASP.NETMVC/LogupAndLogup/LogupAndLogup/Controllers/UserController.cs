using LogupAndLogup.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Mail;
using System.Text;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;

namespace LogupAndLogup.Controllers
{
    public class UserController : Controller
    {
       //Registration Action
       [HttpGet]
       public ActionResult Registration()
        {
            return View();
        }

        //Registration PPOST Action
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Registration([Bind(Exclude= "ActivationCode, IsEmailVerified")] User user)
        {
            bool status = false;
            string message = "";

            //
            //Model Validation
            if (ModelState.IsValid)
            {
                #region//Email already exist
                var isExist = IsEmailExist(user.EmailID);
                if (isExist)
                {
                    ModelState.AddModelError("EmailExist", "Email already exist");
                    return View(user);
                }
                #endregion

                #region //activation Code
                user.ActivationCode = Guid.NewGuid();
                #endregion

                #region //Password Hashing
                user.Password = Crypto.Hash(user.Password);
                user.ConfirmPassword = Crypto.Hash(user.ConfirmPassword);
                //user.Password = Convert.ToBase64String(
                //System.Security.Cryptography.SHA256.Create()
                //.ComputeHash(Encoding.UTF8.GetBytes(user.Password)));
                #endregion

                user.IsEmailVerified = false;
               
                #region//Save Data to Database
                using(MyDatabaseEntities mde = new MyDatabaseEntities())
                {
                    mde.Users.Add(user);
                    mde.SaveChanges();
                }
                #endregion

                #region//Send Email to User
                SendVerificationLinkEmail(user.EmailID, user.ActivationCode.ToString());
                message = "Registration successfully done. Account Activation link" +
                    "has been sent to your email ID: " + user.EmailID;

                status = true;
                #endregion
            }
            else
            {
                message = "Invalid request";
            }

            ViewBag.Message = message;
            ViewBag.Status = status;
            return View(user);
        }
        
        //Verify Account
        [HttpGet]
        public ActionResult VerifyAccount(string id)
        {
            bool Status = false;
            using (MyDatabaseEntities dc = new MyDatabaseEntities())
            {
                dc.Configuration.ValidateOnSaveEnabled = false; // This line I have added here to avoid 
                                                                // Confirm password does not match issue on save changes
                var v = dc.Users.Where(a => a.ActivationCode == new Guid(id)).FirstOrDefault();
                if (v != null)
                {
                    v.IsEmailVerified = true;
                    dc.SaveChanges();
                    Status = true;
                }
                else
                {
                    ViewBag.Message = "Invalid Request";
                }
            }
            ViewBag.Status = Status;
            return View();
        }
        
        //Login
        [HttpGet]
        public ActionResult Login()
        {
            return View();
        }

        //Login POST
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Login(UserLogin login, string ReturnUrl)
        {
            string message = "";
            using(MyDatabaseEntities mde = new MyDatabaseEntities())
            {
                var v = mde.Users.Where(a => a.EmailID == login.EmailID).FirstOrDefault();

                if (v != null)
                {
                    if (!v.IsEmailVerified)
                    {
                        ViewBag.Message = "Please verify your email first";
                        return View();
                    }

                    if (string.Compare(Crypto.Hash(login.Password),v.Password) == 0)
                    {
                        int timeout = login.ReememverMe ? 525600 : 20; // 1 year = 525600 min
                        var ticket = new FormsAuthenticationTicket(login.EmailID, login.ReememverMe, timeout);
                        string encrypted = FormsAuthentication.Encrypt(ticket);
                        var cookie = new HttpCookie(FormsAuthentication.FormsCookieName, encrypted);
                        cookie.Expires = DateTime.Now.AddMinutes(timeout);
                        cookie.HttpOnly = true; //to prevent using javascript for this cookie
                        Response.Cookies.Add(cookie);

                        if (Url.IsLocalUrl(ReturnUrl))
                        {
                            return Redirect(ReturnUrl);
                        }
                        else
                        {
                            return RedirectToAction("index", "Home");
                        }
                    }
                    else
                    {
                        message = "Invalide credential provided!";
                    }
                }
                else
                {
                    message = "Invalide credential provided!";
                }
            }

            ViewBag.Message = message;
            return View();
        }

        //Logout
        [Authorize]
        [HttpPost]
        public ActionResult Logout()
        {
            FormsAuthentication.SignOut();
            return RedirectToAction("Login", "User");
        }

        [NonAction]
        public bool IsEmailExist(string emailID)
        {
            using(MyDatabaseEntities mde = new MyDatabaseEntities())
            {
                var v = mde.Users.Where(a => a.EmailID == emailID).FirstOrDefault();
                return v != null;
            }
        }

        [NonAction]
        public void SendVerificationLinkEmail(string emailID, string activationCode, string emailFor = "VerifyAccount")
        {
            var verifyUrl = "/User/" + emailFor + "/" + activationCode;
            var link = Request.Url.AbsoluteUri.Replace(Request.Url.PathAndQuery, verifyUrl);

            var fromEmail = new MailAddress("ali.bouzar@gmail.com", "Awesome Day");
            var toEmail = new MailAddress(emailID);
            var fromEmailPassword = "A1l2i319810423";//real password

            string subject = "";
            string body = "";

            if(emailFor== "VerifyAccount")
            {
                subject = "Your account is successfully created.";

                body = "<br/><br/>We are excited to inform you that your awesome " +
                   "email account is successfully created, pleaseclick the link below to verify your email address" +
                   "<br/><br/><a href='" + link + "'>" + link + "</a>";
            }
            else if(emailFor=="ResetPassword")
            {
                subject = "Reset Password";
                body = "Hi, We've got a request for reseting your account password, Please click on the link below to " +
                    "change your password <br/><br/><a href="+link+">Reset Password link</a>";
            }

            var smtp = new SmtpClient
            {
                Host = "smtp.gmail.com",
                Port = 587,
                EnableSsl = true,
                DeliveryMethod = SmtpDeliveryMethod.Network,
                UseDefaultCredentials = false,
                Credentials = new NetworkCredential(fromEmail.Address, fromEmailPassword)
            };

            using (var message = new MailMessage(fromEmail, toEmail)
            {
                Subject = subject,
                Body = body,
                IsBodyHtml = true
            })
                smtp.Send(message);

        }

        // Forgot Password
        public ActionResult ForgotPassword()
        {
            return View();
        }

        [HttpPost]
        public ActionResult ForgotPassword(string emailID)
        {
            //Verify Email ID
            //Generate Reset Password Link
            //Send Email
            string message = "";
            bool status = false;

            using(MyDatabaseEntities mde = new MyDatabaseEntities())
            {
                var account = mde.Users.Where(a => a.EmailID == emailID).FirstOrDefault();
                if(account != null)
                {
                    //Send email for reset password
                    string resetCode = Guid.NewGuid().ToString();
                    SendVerificationLinkEmail(account.EmailID, resetCode, "ResetPassword");
                    account.ResetPasswordCode = resetCode;
                    //
                    mde.Configuration.ValidateOnSaveEnabled = false; //to prevent compare the new password with a confirm password
                    mde.SaveChanges();

                    message = "Reset Password Link has been sent to " + account.EmailID;
                }
                else
                {
                    message = "Account not found";
                }
            }
            ViewBag.Message = message;
            return View();
        }

        public ActionResult ResetPassword(string id)
        {
            //Verify the reset password
            //Find account associated with this link
            //redirect to reset password page

            using(MyDatabaseEntities mde = new MyDatabaseEntities())
            {
                var user = mde.Users.Where(a => a.ResetPasswordCode == id).FirstOrDefault();

                if (user != null)
                {
                    ResetPasswordModel model = new ResetPasswordModel();
                    model.ResetCode = id;

                    return View(model);
                }
                else
                {
                    return HttpNotFound();
                }
            }
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult ResetPassword(ResetPasswordModel model)
        {

            var message = "";

            if (ModelState.IsValid)
            {
                using(MyDatabaseEntities mde = new MyDatabaseEntities())
                {
                    var user = mde.Users.Where(a => a.ResetPasswordCode == model.ResetCode).FirstOrDefault();

                    if(user != null)
                    {
                        user.Password = Crypto.Hash(model.NewPassword);
                        user.ResetPasswordCode = "";
                        mde.Configuration.ValidateOnSaveEnabled = false;
                        mde.SaveChanges();

                        message = "New Password has updated successfully.";
                    }
                }
            }
            else
            {
                message = "Something wrong!";
            }

            ViewBag.Message = message;
            return View(model);
        }
    }
}