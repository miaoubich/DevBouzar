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
    public partial class User : Form
    {
        SqlConnection con;
        SqlDataAdapter sda;
        DataTable dt;
        string str;
        SqlCommandBuilder scb;
        SqlCommand sc;
        public User()
        {
            InitializeComponent();
        }

        private void User_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the '_17075i_DBDataSet6.user' table. You can move, or remove it, as needed.
            this.userTableAdapter.Fill(this._17075i_DBDataSet6.user);

            con = new SqlConnection(@"Data Source=31.147.204.119\PISERVER,1433;Initial Catalog=17075i_DB;Persist Security Info=True;User ID=17075i_User;Password=Gjrwxk63");

            if (con.State == ConnectionState.Open)
            {
                con.Close();
            }
            con.Open();
            Fill_Table();
        }

        void Fill_Table()
        {
            str = "SELECT *FROM [user]";
            sda = new SqlDataAdapter(str, con);
            dt = new DataTable();
            sda.Fill(dt);
            userTable.DataSource = dt;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Fill_Table();
            txt_Search.Text = "";
            comboBox1.Text = "";
        }

        private void button2_Click(object sender, EventArgs e)
        {
            try
            {
                scb = new SqlCommandBuilder(sda);
                sda.Update(dt);
                Fill_Table();
                MessageBox.Show("Records have been STORED Successfully", "Message", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error!", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            try
            {
                if (txt_Search.Text == "")
                {
                    MessageBox.Show("Please select an Item you wish to delete.");
                }
                else
                {
                    str = "DELETE FROM [user] WHERE (id = " + txt_Search.Text + ")";
                    sc = new SqlCommand(str, con);
                    sc.ExecuteNonQuery();
                    Fill_Table();
                    MessageBox.Show("Data has been DELETED successfully", "Message", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                txt_Search.Clear();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error!", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }
        
        private void txt_Search_TextChanged(object sender, EventArgs e)
        {
            if (txt_Search.Text == "")
            {
                Fill_Table();
            }
            else if (comboBox1.Text == "Id user")
            {
                str = "SELECT *FROM [user] WHERE id_user like '" + txt_Search.Text + "%'";
                sda = new SqlDataAdapter(str, con);
                dt = new DataTable();
                sda.Fill(dt);
                userTable.DataSource = dt;
                /*
                sda = new SqlDataAdapter("SELECT *FROM [user] WHERE id_user like '" + txt_Search.Text + "%'", con);
                dt = new DataTable();
                sda.Fill(dt);
                userTable.DataSource = dt;
                */
            }
            else if (comboBox1.Text == "Name")
            {
                str = "SELECT *FROM [user] WHERE name like '" + txt_Search.Text + "%'";
                sda = new SqlDataAdapter(str, con);
                dt = new DataTable();
                sda.Fill(dt);
                userTable.DataSource = dt;
            }
            else if (comboBox1.Text == "Surname")
            {
                str = "SELECT *FROM [user] WHERE surname like '" + txt_Search.Text + "%'";
                sda = new SqlDataAdapter(str, con);
                dt = new DataTable();
                sda.Fill(dt);
                userTable.DataSource = dt;
            }
            else if (comboBox1.Text == "Username")
            {
                str = "SELECT *FROM [user] WHERE username like '" + txt_Search.Text + "%'";
                sda = new SqlDataAdapter(str, con);
                dt = new DataTable();
                sda.Fill(dt);
                userTable.DataSource = dt;
            }
            else if (comboBox1.Text == "Password")
            {
                str = "SELECT *FROM [user] WHERE password like '" + txt_Search.Text + "%'";
                sda = new SqlDataAdapter(str, con);
                dt = new DataTable();
                sda.Fill(dt);
                userTable.DataSource = dt;
            }
            else if (comboBox1.Text == "Email")
            {
                str = "SELECT *FROM [user] WHERE email like '" + txt_Search.Text + "%'";
                sda = new SqlDataAdapter(str, con);
                dt = new DataTable();
                sda.Fill(dt);
                userTable.DataSource = dt;
            }
            else if (comboBox1.Text == "Phone Number")
            {
                str = "SELECT *FROM [user] WHERE phone_num like '" + txt_Search.Text + "%'";
                sda = new SqlDataAdapter(str, con);
                dt = new DataTable();
                sda.Fill(dt);
                userTable.DataSource = dt;
            }
            else if (comboBox1.Text == "Type")
            {
                str = "SELECT *FROM [user] WHERE type like '" + txt_Search.Text + "%'";
                sda = new SqlDataAdapter(str, con);
                dt = new DataTable();
                sda.Fill(dt);
                userTable.DataSource = dt;
            }
        }

        private void userTable_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            comboBox1.Text = "";
            var item = userTable.Rows[e.RowIndex].Cells[0].Value.ToString();
            txt_Search.Text = item;
        }

        private void button5_Click(object sender, EventArgs e)
        {
            this.Close();
            Principle p = new Principle();
            p.Show();
        }
    }
}
