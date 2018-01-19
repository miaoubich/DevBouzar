using DatabaseCRUD.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace DatabaseCRUD.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult GetEmployees()
        {
            using(MyDatabaseEntities mde = new MyDatabaseEntities())
            {
                var employees = mde.Employees.OrderBy(a => a.FirstName).ToList();
                return Json(new { data = employees }, JsonRequestBehavior.AllowGet);
            }
        }

        [HttpGet]
        public ActionResult Save(int id)
        {
            using(MyDatabaseEntities mde = new MyDatabaseEntities())
            {
                var v = mde.Employees.Where(a => a.EmployeeID == id).FirstOrDefault();
                return View(v);
            }
        }

        [HttpPost]
        public ActionResult Save(Employees emp)
        {
            bool status = false;

            if (ModelState.IsValid)
            {
                using (MyDatabaseEntities mde = new MyDatabaseEntities())
                {
                    if (emp.EmployeeID > 0)
                    {
                        //Edit
                        var v = mde.Employees.Where(a => a.EmployeeID == emp.EmployeeID).FirstOrDefault();
                        if (v != null)
                        {
                            v.FirstName = emp.FirstName;
                            v.LastName = emp.LastName;
                            v.EmailID = emp.EmailID;
                            v.City = emp.City;
                            v.Country = emp.Country;
                        }
                    }
                    else
                    {
                        //Save
                        mde.Employees.Add(emp);
                    }
                    mde.SaveChanges();
                    status = true;
                }
            }
            return new JsonResult { Data = new { status = status } };
        }
        
        [HttpGet]
        public ActionResult Delete(int id)
        {
            using(MyDatabaseEntities mde = new MyDatabaseEntities())
            {
                var v = mde.Employees.Where(a => a.EmployeeID == id).FirstOrDefault();
                if(v != null)
                {
                    return View(v);
                }
                else
                {
                    return HttpNotFound();
                }
            }
        }

        [HttpPost]
        [ActionName("Delete")]
        public ActionResult DeleteEmployee(int id)
        {
            bool status = false;

            using(MyDatabaseEntities mde = new MyDatabaseEntities())
            {
                var v = mde.Employees.Where(a => a.EmployeeID == id).FirstOrDefault();

                if(v != null)
                {
                    mde.Employees.Remove(v);
                    mde.SaveChanges();
                    status = true;
                }
            }


            return new JsonResult { Data = new { status = status } };
        }
    }
}