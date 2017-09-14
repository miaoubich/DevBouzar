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
using System.Data.SqlClient;

namespace FOI_PROJECT
{
    public partial class UsedSlot : Form
    {
        ManagementObjectSearcher searcher, searcher1, searcher2, searcher3;
        public UsedSlot()
        {
            InitializeComponent();
        }

        private void UsedSlot_Load(object sender, EventArgs e)
        {
            searcher = new ManagementObjectSearcher("root\\CIMV2", "SELECT * FROM Win32_SystemSlot");
            searcher1 = new ManagementObjectSearcher("root\\CIMV2", "SELECT * FROM Win32_Bus");
            searcher2 = new ManagementObjectSearcher("root\\CIMV2", "SELECT * FROM Win32_DeviceBus");
            searcher3 = new ManagementObjectSearcher("root\\CIMV2", "SELECT *FROM Win32_PnPEntity");

            foreach (ManagementObject Obj in searcher.Get())
            {
                listBox1.Items.Add("Current Usage: " + Obj["CurrentUsage"]).ToString(); 
                listBox1.Items.Add("Slot Designation: " + Obj["SlotDesignation"]).ToString();
                listBox1.Items.Add("-------------------------------------------------").ToString();
            }
            foreach (ManagementObject Obj1 in searcher1.Get())
            {
                listBox2.Items.Add("BusType: " + Obj1["BusType"]).ToString();
                listBox2.Items.Add("DeviceID: " + Obj1["DeviceID"]).ToString();
            }
            foreach (ManagementObject Obj2 in searcher2.Get())
            {
                listBox3.Items.Add("System: " + Obj2).ToString();
            }
            foreach(ManagementObject Obj3 in searcher3.Get())
            {
                listBox4.Items.Add("DeviceID: " + Obj3["DeviceID"]).ToString();
                listBox4.Items.Add("Device Name: " + Obj3["Name"]).ToString();
                listBox4.Items.Add("Manufacturer: " + Obj3["Manufacturer"]).ToString();
                listBox4.Items.Add("Device Status: " + Obj3["Status"]).ToString();
                listBox4.Items.Add("------------------------------------------------------").ToString();
            }

        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Close();
            Items it = new Items();
            it.Show();
        }

        private void search_textBox_TextChanged(object sender, EventArgs e)
        {/*
            ManagementObjectSearcher searcher = new ManagementObjectSearcher("root\\CIMV2", "SELECT FROM Win32_PnPEntity WHERE DeviceID = '" + deviceID + "%'");
            
            foreach (ManagementObject Obj in searcher.Get())
            {
                listBox4.Items.Add("Description: " + Obj["Description"]).ToString();
                listBox4.Items.Add("DeviceID: " + Obj["DeviceID"]).ToString();
                listBox4.Items.Add("-------------------------------------").ToString();
            }
            */
        }


        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            /*
            ManagementObjectSearcher searcher4 = new ManagementObjectSearcher("root\\CIMV2", "SELECT *FROM Win32_PnPEntity WHERE DeviceID = '" + deviceID.Text + "%'");
            
            if (deviceID.Text != "") {
                foreach (ManagementObject Obj in searcher4.Get())
                {
                    //listBox4.Items.Add("thalatha").ToString();
                    listBox4.Items.Add("Description: " + Obj["Description"]).ToString();
                    listBox4.Items.Add("DeviceID: " + Obj["DeviceID"]).ToString();
                    listBox4.Items.Add("-------------------------------------").ToString();
                }
            }
            else
            {
                MessageBox.Show("Please enter a Device ID.");
            }
            */

            listBox4.SelectedItems.Clear();
            int j = listBox4.Items.Count;// nbr of items in the listBox4
            for (int i = j-1; i>=0; i--)
            {
                if (listBox4.Items[i].ToString().Contains("DeviceID: " + deviceID.Text))
                {
                    listBox4.SetSelected(i, true);
                }
            }
        }
    }
}
