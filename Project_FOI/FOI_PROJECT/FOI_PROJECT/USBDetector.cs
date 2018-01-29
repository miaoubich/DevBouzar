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
    public partial class USBDetector : Form
    {
        
        public USBDetector()
        {
            InitializeComponent();
        }

        class USBDeviceInfoClass
        {
            public USBDeviceInfoClass(string deviceID, string pnpDeviceID, string description)
            {
                this.DeviceID = deviceID;
                this.PnpDeviceID = pnpDeviceID;
                this.Description = description;
            }
            public string DeviceID { get; private set; }
            public string PnpDeviceID { get; private set; }
            public string Description { get; private set; }
        }

        private void USBDetector_Load(object sender, EventArgs e)
        {
            var usbDevices = GetConnectedUSBDevices();
            dataGridView1.DataSource = usbDevices;
            dataGridView1.Columns[0].Width = 233;
            dataGridView1.Columns[1].Width = 233;
            dataGridView1.Columns[2].Width = 233;
        }
        
        static List<USBDeviceInfoClass> GetConnectedUSBDevices()
        {
            List<USBDeviceInfoClass> _devices = new List<USBDeviceInfoClass>(); // Create List of USBDeviceInfoClass with _devices named

            ManagementObjectCollection collection; // Create a object of ManagementObjectCollection class which is hold the list of connected devices
            using (var searcher = new ManagementObjectSearcher(@"Select * From Win32_USBHub")) // This line fetch all the connected device with windows query
            {
                collection = searcher.Get();
            }

            foreach (var device in collection)
            {
                _devices.Add(new USBDeviceInfoClass(
                 (string)device.GetPropertyValue("DeviceID"),
                 (string)device.GetPropertyValue("PNPDeviceID"),
                 (string)device.GetPropertyValue("Description")
                ));

            }

            collection.Dispose();
            return _devices;
        }
        

        private void button1_Click(object sender, EventArgs e)
        {
            this.Close();
            PC_info it = new PC_info();
            it.Show();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            USBDetector_Load(sender, e);
        }
    }
}
