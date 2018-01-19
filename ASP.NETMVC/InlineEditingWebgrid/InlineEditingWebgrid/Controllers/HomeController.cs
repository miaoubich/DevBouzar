using InlineEditingWebgrid.Models;
using InlineEditingWebgrid.ViewModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace InlineEditingWebgrid.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        public ActionResult Index()
        {
            List<SiteUserModel> list = new List<SiteUserModel>();
            using(MyDatabaseEntities mde = new MyDatabaseEntities())
            {
                var v = (from a in mde.SiteUsers
                         join b in mde.UserRoles 
                         on a.RoleID equals b.ID
                         select new SiteUserModel
                         {
                             ID = a.ID,
                             FirstName = a.FirstName,
                             LastName = a.LastName,
                             DOB = a.DOB,
                             RoleID = a.RoleID,
                             RoleName = b.RoleName
                         });
                list = v.ToList();
            }

            return View(list);
        }
    }
}