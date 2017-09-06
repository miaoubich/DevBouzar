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
using System.IO;
using System.IO.Ports;

namespace FOI_PROJECT
{
    public partial class HardwareInfo : Form
    {
        SqlConnection con;
        SqlDataAdapter sda;
        DataTable dt;
        public HardwareInfo()
        {
            InitializeComponent();
        }

        private void HardwareInfo_Load(object sender, EventArgs e)
        {
            con = new SqlConnection(@"Data Source=31.147.204.119\PISERVER,1433;Initial Catalog=17075i_DB;Persist Security Info=True;User ID=17075i_User;Password=Gjrwxk63");

            if (con.State == ConnectionState.Open) {
                con.Close();
            }
            con.Open();

            //ManagementObjectSearcher searcher = new ManagementObjectSearcher("SELECT * FROM Win32_Processor");
            ManagementObjectSearcher searcher = new ManagementObjectSearcher("SELECT ProcessorId, Architecture, maxclockspeed, datawidth, name, manufacturer FROM  Win32_Processor");

            ManagementObjectCollection objCol = searcher.Get();
            foreach (ManagementObject obj in objCol)
            {
                lblCpuId.Text = obj["ProcessorId"].ToString();
                Arc.Text = obj["Architecture"].ToString();
                lebelName.Text = obj["name"].ToString();
                labelMaker.Text = obj["manufacturer"].ToString();
                labelSpeed.Text = obj["maxclockspeed"].ToString();
                labelWidth.Text = obj["datawidth"].ToString();
            }

                /*
                cpuID.Text = HardwareInfo.GetProcessorId();


                hdd.Text = HardwareInfo.GetHDDSerialNo();


                boardmaker.Text = HardwareInfo.GetBoardMaker();


                bios.Text = HardwareInfo.GetBIOSmaker();


                physicalMemory.Text = HardwareInfo.GetPhysicalMemory();

                cpuSpeed.Text = HardwareInfo.GetCpuSpeedInGHz().ToString();


                cpuMaker.Text = HardwareInfo.GetCPUManufacturer();
                */
                ManagementObjectSearcher searcher1 = new ManagementObjectSearcher("SELECT * FROM Win32_DisplayConfiguration");

            string graphicsCard = string.Empty;
            foreach (ManagementObject mo in searcher1.Get())
            {
                foreach (PropertyData property in mo.Properties)
                {
                    if (property.Name == "Description")
                    {
                        graphicsCard = property.Value.ToString();
                    }
                }
            }
            label7.Text = graphicsCard;
        }

        private void button1_Click(object sender, EventArgs e)
        {
         /*
            sda = new SqlDataAdapter("SELECT *FROM Win32_SystemSlot", con);
            dt = new DataTable();
            sda.Fill(dt);
            dataGridView1.DataSource = dt;
         */
        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
            Items it = new Items();
            it.Show();
        }

        private void label7_Click(object sender, EventArgs e)
        {

        }

        private void label14_Click(object sender, EventArgs e)
        {

        }

        private void label13_Click(object sender, EventArgs e)
        {

        }
    }
}
