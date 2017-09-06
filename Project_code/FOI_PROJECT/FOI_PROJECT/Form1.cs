using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace FOI_PROJECT
{
    public partial class Form1 : Form
    {
        SqlDataAdapter sda;
        DataTable dt;
        SqlConnection con;
        string utype, utype1, str;
        //public static string utype;
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            con = new SqlConnection(@"Data Source=31.147.204.119\PISERVER,1433;Initial Catalog=17075i_DB;Persist Security Info=True;User ID=17075i_User;Password=Gjrwxk63");

            if(con.State == ConnectionState.Open)
            {
                con.Close();
            }
            con.Open();

            str = "SELECT COUNT(*) FROM [user] WHERE  username = '" + txt_Username.Text + "' AND password = '" + txt_Password.Text + "'";
            utype1 = "SELECT type FROM [user] WHERE  username = '" + txt_Username.Text + "' AND password = '" + txt_Password.Text + "'";
            SqlCommand sc = new SqlCommand(utype1, con);
            sc.ExecuteNonQuery();
            utype = sc.ExecuteScalar().ToString();

            sda = new SqlDataAdapter(str, con);
            dt = new DataTable();
            sda.Fill(dt);
            //utype = dt.Rows[0][8].ToString();

            if (dt.Rows.Count > 0)
            {
                if (utype == "administrator")
                {
                    this.Hide();
                    Principle it = new Principle();
                    it.Show();
                }
                else
                {
                    this.Hide();
                    Client c = new Client();
                    c.Show();
                    //MessageBox.Show(utype);
                }
                
            }
            else
            {
                MessageBox.Show("Username or Password is INCORRECT!!!");
            }

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            const string m = "Please Confirm Closing the System.";
            const string caption = "Form Closing.";
            var result = MessageBox.Show(m, caption, MessageBoxButtons.YesNo, MessageBoxIcon.Question);

            //if the No button was pressed...
            if (result == DialogResult.Yes)
            {
                Application.Exit();
            }
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {/*
            const string m = "Please Confirm Closing the System.";
            const string caption = "Form Closing.";
            var result = MessageBox.Show(m, caption, MessageBoxButtons.YesNo, MessageBoxIcon.Question);

            //if the No button was pressed...
            if (result == DialogResult.No)
            {
                //cancel closure of the form.
                e.Cancel = true;
            }*/
            Application.Exit();
        }
    }
}
