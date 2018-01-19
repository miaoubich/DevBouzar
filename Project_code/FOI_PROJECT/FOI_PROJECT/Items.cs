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
using System.IO;
using iTextSharp.text;
using iTextSharp.text.pdf;
//using iTextSharp.text.Font;
using System.Management;
using Microsoft.VisualBasic;

namespace FOI_PROJECT
{
    public partial class Items : Form
    {
        SqlDataAdapter sda;
        SqlCommand sc,sc1,sc2;
        SqlCommandBuilder scb;
        DataTable dt;
        SqlConnection con;
        string str;
        public Items()
        {
            InitializeComponent();
            ItemsTable.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
        }

        private void Items_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the '_17075i_DBDataSet5.component' table. You can move, or remove it, as needed.
            //this.componentTableAdapter.Fill(this._17075i_DBDataSet5.component);


            //con = new SqlConnection(@"Data Source=31.147.204.119\PISERVER,1433;Initial Catalog=17075i_DB;Persist Security Info=True;User ID=17075i_User;Password=Gjrwxk63");
            con = new SqlConnection(@"Data Source=MIAOUBICH\SQLEXPRESS;Initial Catalog=Project_01;Integrated Security=True");

            if (con.State == ConnectionState.Open)
            {
                con.Close();
            }
            con.Open();
            
            Fill_Table();
            Fill_Compatible();
        }

        public void Fill_Table()
        {
            str = "SELECT id, code_item, designation, model, brand, price, stock FROM component";
            sda = new SqlDataAdapter(str, con);
            dt = new DataTable();
            sda.Fill(dt);
            ItemsTable.DataSource = dt;
        }

        public void Fill_Compatible()
        { 
            str = "SELECT item1.designation AS Component, item2.designation AS [Compatible with] " +
                  "FROM component item1, component item2, compatibility comp " +
                  "WHERE comp.id1 = item1.id AND comp.id2 = item2.id AND comp.compatible = 1 ORDER BY item1.designation ASC";
            sda = new SqlDataAdapter(str, con);
            dt = new DataTable();
            sda.Fill(dt);
            ItemsCompatible.DataSource = dt;
        }

        private void button5_Click(object sender, EventArgs e)
        {
            const string m = "Please confirm closing the Items Form";
            const string cap = "EXIT FORM";
            var result = MessageBox.Show(m, cap, MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (result == DialogResult.Yes) {
                this.Hide();
                Principle p = new Principle();
                p.Show();
            }
            else
            {

            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Fill_Table();
            Fill_Compatible();
            txt_Search.Clear();
            category.Text = "";
            timer2.Stop();
            progressBar1.Value = 0;
            SelectedItem1.Text = "";
            SelectedItem2.Text = "";
        }

        private void button2_Click(object sender, EventArgs e)
        {
            try
            {
                scb = new SqlCommandBuilder(sda);
                sda.Update(dt);
                Fill_Table();

                SelectedItem1.Text = "";
                SelectedItem2.Text = "";
                MessageBox.Show("Data have been SUCCESSFULLY saved.", "Message", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error!", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void txt_Search_TextChanged(object sender, EventArgs e)
        {
            if (category.Text == "code item")
            {
                sda = new SqlDataAdapter("SELECT *FROM component WHERE code_item like '" + txt_Search.Text + "%'", con);
                dt = new DataTable();
                sda.Fill(dt);
                ItemsTable.DataSource = dt;
            }else if (category.Text == "designation")
            {
                sda = new SqlDataAdapter("SELECT *FROM component WHERE designation like '" + txt_Search.Text + "%'", con);
                dt = new DataTable();
                sda.Fill(dt);
                ItemsTable.DataSource = dt;
            }
            else if (category.Text == "model")
            {
                sda = new SqlDataAdapter("SELECT *FROM component WHERE model like '" + txt_Search.Text + "%'", con);
                dt = new DataTable();
                sda.Fill(dt);
                ItemsTable.DataSource = dt;
            }
            else if (category.Text == "brand")
            {
                sda = new SqlDataAdapter("SELECT *FROM component WHERE brand like '" + txt_Search.Text + "%'", con);
                dt = new DataTable();
                sda.Fill(dt);
                ItemsTable.DataSource = dt;
            }
            else if (category.Text == "price")
            {
                sda = new SqlDataAdapter("SELECT *FROM component WHERE price like '" + txt_Search.Text + "%'", con);
                dt = new DataTable();
                sda.Fill(dt);
                ItemsTable.DataSource = dt;
            }
            else if (category.Text == "stock")
            {
                sda = new SqlDataAdapter("SELECT *FROM component WHERE stock like '" + txt_Search.Text + "%'", con);
                dt = new DataTable();
                sda.Fill(dt);
                ItemsTable.DataSource = dt;
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
           /*const string m = "Please Confirm.";
            const string c = "DELETION";
            var result = MessageBox.Show(m, c, MessageBoxButtons.YesNo, MessageBoxIcon.Question);

            if (result == DialogResult.Yes) {*/

                try
                {
                    if (txt_Search.Text == "") {
                        MessageBox.Show("Please Selected a ROW!");
                    }
                    else
                    {
                        string q = "DELETE FROM component WHERE (id = '" + txt_Search.Text + "')";
                        SqlCommand cmd = new SqlCommand(q, con);
                        cmd.ExecuteNonQuery();
                        Fill_Table();
                        MessageBox.Show("Data Have been DELETED Successfully!", "Message", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    }
                    txt_Search.Clear();
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message, "Please Selected a ROW!", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            //}
            
        }
        
        private void txt_Table_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            category.Text = "";
            var item = ItemsTable.Rows[e.RowIndex].Cells[0].Value.ToString();

                if (SelectedItem1.Text != "")
                {
                    SelectedItem2.Text = item;
                    string idItem2 = "UPDATE compatibility SET id2 = '" + SelectedItem2.Text + "' WHERE id1 = '" + SelectedItem1.Text + "'";
                    sc = new SqlCommand(idItem2, con);
                    sc.ExecuteNonQuery();
                }
                else
                {
                    const string v = "To DELETE click 'Yes', else click 'No'.";
                    const string info = "INFO MESSAGE";
                    var result = MessageBox.Show(v, info, MessageBoxButtons.YesNo, MessageBoxIcon.Question);
                    if (result == DialogResult.Yes)
                    {
                        txt_Search.Text = item;
                    }
                    else
                    {
                        if (SelectedItem1.Text == "")
                        {
                            SelectedItem1.Text = item;

                            string idItem1 = "INSERT INTO compatibility(id1) VALUES('" + SelectedItem1.Text + "')";
                            sc1 = new SqlCommand(idItem1, con);
                            sc1.ExecuteNonQuery();
                        }
                        else
                        {
                            SelectedItem2.Text = item;
                            string idItem2 = "UPDATE compatibility SET id2 = '" + SelectedItem2.Text + "' WHERE id1 = '" + SelectedItem1.Text + "'";
                            sc2 = new SqlCommand(idItem2, con);
                            sc2.ExecuteNonQuery();
                        }
                    }
                }
            
        }

        private void button4_Click(object sender, EventArgs e)
        {
            this.Hide();
            ComputerInformationSystem CIS = new ComputerInformationSystem();
            CIS.Show();
        }

        private void Items_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }

        private void button7_Click(object sender, EventArgs e)
        {
            this.Close();
            USBDetector usb = new USBDetector();
            usb.Show();
        }

        private void Slots_Click(object sender, EventArgs e)
        {
            this.Hide();
            UsedSlot sl = new UsedSlot();
            sl.Show();
        }

        private void button8_Click(object sender, EventArgs e)
        {
            Document doc = new Document(iTextSharp.text.PageSize.LETTER, 10, 10, 42, 35);// A0, A1,...,A4,...
            PdfWriter writer = PdfWriter.GetInstance(doc, new FileStream("hardware.pdf", FileMode.Create));
            doc.Open();//open Document to write
            //write some content
            Paragraph para = new Paragraph("List Of Computer Components");
            Paragraph para1 = new Paragraph("\n");
            para.Alignment = Element.ALIGN_CENTER;
            doc.Add(para);
            doc.Add(para1);

            
            PdfPTable table = new PdfPTable(ItemsTable.Columns.Count);
            //Add the header from txt_Table to the table
            for (int j = 0; j < ItemsTable.Columns.Count; j++)
            {
                table.AddCell(new Phrase(ItemsTable.Columns[j].HeaderText));
            }
            //Flag the first row as a header
            table.HeaderRows = 1;
            //Add the actual rows from txt_Table to the table
            for (int i = 0; i < ItemsTable.Rows.Count; i++)
            {
                for (int k = 0; k < ItemsTable.Columns.Count; k++)
                {
                    if (ItemsTable[k, i].Value != null)
                    {
                        table.AddCell(new Phrase(ItemsTable[k, i].Value.ToString()));
                    }
                }
            }
            //Add out table
            doc.Add(table);

            doc.Close();

            this.timer2.Start();

            System.Diagnostics.Process.Start("hardware.pdf");// (@"C:\Users\DARIN\Documents\Visual Studio 2017\Projects\FOI_PROJECT\FOI_PROJECT\bin\Debug\hardware.pdf");

        }
        
        private void timer1_Tick(object sender, EventArgs e)
        {
            this.progressBar1.Increment(10);
        }

        private void button9_Click(object sender, EventArgs e)
        {
            ManagementObjectSearcher searcher = new ManagementObjectSearcher("root\\CIMV2", "SELECT *FROM Win32_BaseBoard"); 
            
            foreach(ManagementObject mo in searcher.Get())
            {
                lblDesignation.Text = mo["Manufacturer"].ToString();
            }
        }

        private void button10_Click(object sender, EventArgs e)
        {
            ManagementObjectSearcher searcher1 = new ManagementObjectSearcher("root\\CIMV2", "SELECT *FROM Win32_BaseBoard");

            foreach (ManagementObject mo in searcher1.Get())
            {
                label6.Text = mo["SerialNumber"].ToString();
            }
        }

        private void timer2_Tick(object sender, EventArgs e)
        {
            this.progressBar1.Increment(10);
        }
        
        private void button11_Click(object sender, EventArgs e)
        {
            this.Close();
            RAM r = new RAM();
            r.Show();
        }

        private void usedRam_Click(object sender, EventArgs e)
        {
            ObjectQuery winQuery = new ObjectQuery("SELECT * FROM Win32_PhysicalMemory");
            ManagementObjectSearcher searcher = new ManagementObjectSearcher(winQuery);

            foreach (ManagementObject mo in searcher.Get())
            {
                var v = mo["Capacity"];
                float f = Convert.ToUInt64(v);
                float f1 = f/(1024*1024);
                usedRam.Text = f1.ToString();
            }
        }
        
        private void ItemsCompatible_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            var item = ItemsCompatible.Rows[e.RowIndex].Cells[0].Value.ToString();
            txt_Search.Text = item;
        }

        private void button6_Click_1(object sender, EventArgs e)
        {
            if(txt_Search.Text == "")
            {
                MessageBox.Show("Please select an Item.");
            }
            else
            {
                var itemDelete1 = "SELECT id FROM component WHERE designation = '" + txt_Search.Text + "'";
                sc2 = new SqlCommand(itemDelete1, con);
                sc2.ExecuteNonQuery();
                var itemDelete = sc2.ExecuteScalar().ToString();

                int idDelete = int.Parse(itemDelete);

                string str1 = "DELETE FROM compatibility WHERE id1 = '" + idDelete + "'";
                sc = new SqlCommand(str1, con);
                sc.ExecuteNonQuery();

                Fill_Compatible();
                MessageBox.Show("Item has been deleted.");
                txt_Search.Text = "";
            }
        }

        private void btn_Add_Click(object sender, EventArgs e)
        {
            if (InputCode.Text == "" && InputDesignation.Text == "" && InputModel.Text == "" && InputBrand.Text == "" || InputPrice.Text == "" || InputStock.Text == "")
            {
                MessageBox.Show("Please Fill all the Boxes.");
            }
            else
            {
                string strAdd = "INSERT INTO component(code_item, designation, model, brand, price, stock) " +
                                "VALUES('" + InputCode.Text + "', '" + InputDesignation.Text + "', '" + InputModel.Text + "'," +
                                " '" + InputBrand.Text + "', " + InputPrice.Text + ", " + InputStock.Text + ")";
                sc = new SqlCommand(strAdd, con);
                sc.ExecuteNonQuery();
                Fill_Table();
                InputCode.Text = "";
                InputDesignation.Text = "";
                InputModel.Text = "";
                InputBrand.Text = "";
                InputPrice.Text = "";
                InputStock.Text = "";

                MessageBox.Show("Data Have been Added Successfully !");
            }
        }

        private void btn_delete_MouseHover(object sender, EventArgs e)
        {
            //Color.White.ToString();
        }

        private void usedRam_Click_1(object sender, EventArgs e)
        {

        }

        private void button4_Click_1(object sender, EventArgs e)
        {
            this.Hide();
            PC_info pc = new PC_info();
            pc.Show();
        }

        private void btn_compatible_Click(object sender, EventArgs e)
        {
            if (SelectedItem1.Text == "" || SelectedItem2.Text == "")
            {
                MessageBox.Show("Please select Two Items To continue The Compatibility Test Proof.");
            }
            else
            {
                string query = "UPDATE compatibility SET compatible = 1 WHERE id1 = '" + SelectedItem1.Text + "' AND id2 = '" + SelectedItem2.Text + "' ";
                SqlCommand sc = new SqlCommand(query, con);
                sc.ExecuteNonQuery();
                
                Fill_Compatible();

                MessageBox.Show("The level of Optimal Compatibility has been Reach Successfully!");

                SelectedItem1.Text = "";
                SelectedItem2.Text = "";
            }
        }
    }
}