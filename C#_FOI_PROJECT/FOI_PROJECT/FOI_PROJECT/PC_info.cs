using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Management;

namespace FOI_PROJECT
{
    public partial class PC_info : Form
    {
        public PC_info()
        {
            InitializeComponent();
        }

        private void mother_Click(object sender, EventArgs e)
        {
            SelectQuery Sq = new SelectQuery("Win32_BaseBoard");// Win32_MotherboardDevice"); 
            ManagementObjectSearcher objOSDetails = new ManagementObjectSearcher(Sq);
            ManagementObjectCollection osDetailsCollection = objOSDetails.Get();
            StringBuilder sb = new StringBuilder();
            foreach (ManagementObject mo in osDetailsCollection)
            /*{
                sb.AppendLine(string.Format("Availability: {0}", mo["Availability"].ToString()));
                sb.AppendLine(string.Format("Caption: {0}", (string)mo["Caption"]));
                sb.AppendLine(string.Format("ConfigManager Error Code: {0}", (string)mo["ConfigManagerErrorCode"]));
                sb.AppendLine(string.Format("ConfigManager User Config: {0}", (string)mo["ConfigManagerUserConfig"]));
                sb.AppendLine(string.Format("Creation ClassName : {0}", (string)mo["CreationClassName"]));
                sb.AppendLine(string.Format("Description: {0}", (string)mo["Description"]));
                sb.AppendLine(string.Format("DeviceID : {0}", (string)mo["DeviceID"]));
                sb.AppendLine(string.Format("Error Cleared: {0}", (string)mo["ErrorCleared"]));
                sb.AppendLine(string.Format("Error Description : {0}", (string)mo["ErrorDescription"]));
                sb.AppendLine(string.Format("Install Date: {0}", Convert.ToDateTime(mo["InstallDate"]).ToString()));
                sb.AppendLine(string.Format("Last Error Code : {0}", (string)mo["LastErrorCode"]));
                sb.AppendLine(string.Format("Name : {0}", (string)mo["Name"]));
                sb.AppendLine(string.Format("PNPDeviceID: {0}", (string)mo["PNPDeviceID"]));
                sb.AppendLine(string.Format("Power Management Capabilities : {0}", (string)mo["PowerManagementCapabilities"]));
                sb.AppendLine(string.Format("Power Management Supported : {0}", mo["PowerManagementSupported"]).ToString());
                sb.AppendLine(string.Format("Primary BusType : {0}", (string)mo["PrimaryBusType"]));
                sb.AppendLine(string.Format("Revision Number : {0}", (string)mo["RevisionNumber"]));
                sb.AppendLine(string.Format("Secondary BusType : {0}", (string)mo["SecondaryBusType"]));
                sb.AppendLine(string.Format("Status : {0}", (string)mo["Status"]));
                sb.AppendLine(string.Format("Status Info : {0}", (string)mo["StatusInfo"]));
                sb.AppendLine(string.Format("System Creation ClassName : {0}", (string)mo["SystemCreationClassName"]));
                sb.AppendLine(string.Format("System Name: {0}", (string)mo["SystemName"]));
            }*/
            {
                sb.AppendLine(string.Format("Caption: {0}", mo["Caption"].ToString()));
                sb.AppendLine(string.Format("ConfigOptions: {0}", mo["ConfigOptions"]));
                sb.AppendLine(string.Format("Depth: {0}", (string)mo["Depth"]));
                sb.AppendLine(string.Format("CreationClassName : {0}", (string)mo["CreationClassName"]));
                sb.AppendLine(string.Format("Description: {0}", (string)mo["Description"]));
                sb.AppendLine(string.Format("Height : {0}", (string)mo["Height"]));
                sb.AppendLine(string.Format("HostingBoard: {0}", mo["HostingBoard"]));
                sb.AppendLine(string.Format("HotSwappable: {0}", mo["HotSwappable"]));
                sb.AppendLine(string.Format("Install Date: {0}", Convert.ToDateTime(mo["InstallDate"]).ToString()));
                sb.AppendLine(string.Format("Manufacturer: {0}", (string)mo["Manufacturer"]));
                sb.AppendLine(string.Format("Model: {0}", (string)mo["Model"]));
                sb.AppendLine(string.Format("Name: {0}", (string)mo["Name"]));
                sb.AppendLine(string.Format("OtherIdentifyingInfo: {0}", (string)mo["OtherIdentifyingInfo"]));
                sb.AppendLine(string.Format("PartNumber: {0}", mo["PartNumber"]).ToString());
                sb.AppendLine(string.Format("PoweredOn: {0}", mo["PoweredOn"]));
                sb.AppendLine(string.Format("Product: {0}", (string)mo["Product"]));
                sb.AppendLine(string.Format("Removable: {0}", mo["Removable"]));
                sb.AppendLine(string.Format("Replaceable: {0}", mo["Replaceable"]));
                sb.AppendLine(string.Format("RequirementsDescription: {0}", (string)mo["RequirementsDescription"]));
                sb.AppendLine(string.Format("RequiresDaughterBoard: {0}", mo["RequiresDaughterBoard"]));
                sb.AppendLine(string.Format("SerialNumber: {0}", (string)mo["SerialNumber"]));
                sb.AppendLine(string.Format("SKU: {0}", (string)mo["SKU"]));
                sb.AppendLine(string.Format("SlotLayout: {0}", (string)mo["SlotLayout"]));
                sb.AppendLine(string.Format("SpecialRequirements: {0}", mo["SpecialRequirements"]));
                sb.AppendLine(string.Format("Status: {0}", (string)mo["Status"]));
                sb.AppendLine(string.Format("Tag: {0}", (string)mo["Tag"]));
                sb.AppendLine(string.Format("Version: {0}", (string)mo["Version"]));
                sb.AppendLine(string.Format("Weight: {0}", (string)mo["Weight"]));
                sb.AppendLine(string.Format("Width: {0}", (string)mo["Width"]));
            }
            MessageBox.Show(sb.ToString());
        }

        private void button6_Click(object sender, EventArgs e)
        {
            this.Close();
            HardwareInfo hi = new HardwareInfo();
            hi.Show();
        }

        private void button7_Click(object sender, EventArgs e)
        {
            this.Close();
            USBDetector usb = new USBDetector();
            usb.Show();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            this.Hide();
            ComputerInformationSystem CIS = new ComputerInformationSystem();
            CIS.Show();
        }

        private void button11_Click(object sender, EventArgs e)
        {
            this.Close();
            RAM r = new RAM();
            r.Show();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Close();
            Items it = new Items();
            it.Show();
        }
    }
}
