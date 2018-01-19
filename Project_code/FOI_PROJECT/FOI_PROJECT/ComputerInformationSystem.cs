using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace FOI_PROJECT
{
    public partial class ComputerInformationSystem : Form
    {
        public ComputerInformationSystem()
        {
            InitializeComponent();
        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void ComputerInformationSystem_Load(object sender, EventArgs e)
        {
            textBox7.Enabled = false;
            textBox8.Enabled = false;
            button4.Enabled = false;
            button5.Enabled = false;
        }

        private void ComputerInformationSystem_FormClosing(object sender, FormClosingEventArgs e)
        {
            
        }

        private void button3_Click(object sender, EventArgs e)
        {
            this.Close();
            PC_info i = new PC_info();
            i.Show();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            textBox1.Text = "";
            textBox2.Text = "";
            textBox3.Text = "";
            textBox4.Text = "";
            textBox5.Text = "";
            textBox6.Text = "";
            textBox7.Text = "";
            textBox8.Text = "";
            textBox7.Enabled = false;
            textBox8.Enabled = false;
            button4.Enabled = false;
            button5.Enabled = false;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            textBox7.Enabled = true;
            textBox8.Enabled = true;
            String n = Environment.MachineName; // Computer Name
            textBox1.Text = Convert.ToString(n);

            String u = Environment.UserName; // Username
            textBox2.Text = Convert.ToString(u);

            String vv = Environment.OSVersion.Version.ToString(); // Version of the OS
            textBox3.Text = vv;

            String v = (Environment.OSVersion.ToString()); // System Name
            textBox4.Text = v;

            String sp = Environment.OSVersion.Platform.ToString(); // System Platform
            textBox5.Text = sp;

            int c = Environment.ProcessorCount; // Processor Counter
            textBox6.Text = Convert.ToString(c);

            bool bo = Environment.Is64BitOperatingSystem; // Is your system 64 Bit OS
            textBox7.Text = Convert.ToString(bo);
            

            bool bp = Environment.Is64BitProcess; // Is your system 64 Bit Process
            textBox8.Text = Convert.ToString(bp);
            
        }

        private void button4_Click(object sender, EventArgs e)
        {
            const string message =
                "Your System is 32 Bit Operating System";
            const string caption = "32 Bit Operating System";
            var res = MessageBox.Show(message, caption, MessageBoxButtons.OK, MessageBoxIcon.Exclamation);

            //button4.Enabled = false;
        }

        private void button5_Click(object sender, EventArgs e)
        {
            const string message =
                "Your System is 32 Bit Processor";
            const string caption = "32 Bit Processor";
            var res = MessageBox.Show(message, caption, MessageBoxButtons.OK, MessageBoxIcon.Exclamation);

            //button5.Enabled = false;
        }

        private void textBox7_Click(object sender, EventArgs e)
        {
            if (textBox7.Text == "False")
            {
                button4.Enabled = true;
            }
        }

        private void textBox8_Click(object sender, EventArgs e)
        {
            if (textBox8.Text == "False")
            {
                button5.Enabled = true;
            }
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
