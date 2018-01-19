using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace DatabaseCRUD.Models
{
    [MetadataType(typeof(EmployeeMetadata))]
    public partial class Employees
    {

    }

    public  class EmployeeMetadata
    {
        [Required(AllowEmptyStrings =false, ErrorMessage ="Please provide a first name")]
        public string FirstName { get; set; }

        [Required(AllowEmptyStrings =false, ErrorMessage ="Please provide a last name")]
        public string LastName { get; set; }
    }
}