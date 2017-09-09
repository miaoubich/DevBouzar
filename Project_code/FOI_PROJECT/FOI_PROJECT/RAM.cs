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
    public partial class RAM : Form
    {
        public RAM()
        {
            InitializeComponent();
        }

        private void RAM_Load(object sender, EventArgs e)
        {
            ObjectQuery winQuery = new ObjectQuery("SELECT * FROM Win32_PhysicalMemory");
            ManagementObjectSearcher searcher = new ManagementObjectSearcher(winQuery);

            ObjectQuery winQuery1 = new ObjectQuery("SELECT * FROM Win32_MemoryDevice");
            ManagementObjectSearcher searcher1 = new ManagementObjectSearcher(winQuery1);
            int i = 0;
            foreach (ManagementObject mo in searcher.Get())
            {
                label9.Text = mo["Capacity"].ToString();
                label13.Text = mo["DeviceLocator"].ToString();
                label12.Text = mo["Manufacturer"].ToString();
                label11.Text = mo["SerialNumber"].ToString();
                label10.Text = mo["Speed"].ToString();
                i+=1;
            }
            foreach (ManagementObject mo in searcher1.Get())
            {
                label7.Text = mo["DeviceID"].ToString();
                label8.Text = mo["Name"].ToString();
                //textBox3.Text = mo["DeviceLocator"].ToString();
                label14.Text = mo["DeviceID"].ToString();
            }

            label15.Text = i.ToString();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Close();
            Items it = new Items();
            it.Show();
        }
    }
}
