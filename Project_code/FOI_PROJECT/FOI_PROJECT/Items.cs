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
            this.componentTableAdapter.Fill(this._17075i_DBDataSet5.component);


            con = new SqlConnection(@"Data Source=31.147.204.119\PISERVER,1433;Initial Catalog=17075i_DB;Persist Security Info=True;User ID=17075i_User;Password=Gjrwxk63");

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
            str = "SELECT *FROM component";
            sda = new SqlDataAdapter(str, con);
            dt = new DataTable();
            sda.Fill(dt);
            ItemsTable.DataSource = dt;
        }

        public void Fill_Compatible()
        {
            str = "SELECT item1.designation, item2.designation AS [Compatible with] " +
                  "FROM component item1, component item2, compatibility comp " +
                  "WHERE comp.id1 = item1.id AND comp.id2 = item2.id";
            sda = new SqlDataAdapter(str, con);
            dt = new DataTable();
            sda.Fill(dt);
            ItemCompatible.DataSource = dt;
        }


        private void button5_Click(object sender, EventArgs e)
        {
            this.Close();
            Principle p = new Principle();
            p.Show();
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
            try
            {
                if(txt_Search.Text == "") {
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
            catch(Exception ex)
            {
                MessageBox.Show(ex.Message,"Please Selected a ROW!", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            
        }

        private void txt_Table_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            
        }

        private void txt_Table_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            //id = Convert.ToInt32(txt_Table.Rows[e.RowIndex].Cells["id"].Value.ToString());
            category.Text = "";
            var item = ItemsTable.Rows[e.RowIndex].Cells[0].Value.ToString();

                if (SelectedItem1.Text != "")
                {
                    SelectedItem2.Text = item;
                    //string idItem2 = "INSERT INTO compatibility(id2) VALUES('" + SelectedItem2.Text + "')";
                    string idItem2 = "UPDATE compatibility SET id2 = '" + SelectedItem2.Text + "' WHERE id1 = '" + SelectedItem1.Text + "'";
                    sc = new SqlCommand(idItem2, con);
                    sc.ExecuteNonQuery();
                }
                else
                {
                    const string v = "Do you want to delete an item?";
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
                        else if (SelectedItem1.Text != "")
                        {
                            SelectedItem2.Text = item;
                            //string idItem2 = "INSERT INTO compatibility(id2) VALUES('" + SelectedItem2.Text + "')";
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
            /*
            const string m = "Please Confirm Closing the System.";
            const string caption = "Form Closing.";
            var result = MessageBox.Show(m, caption, MessageBoxButtons.YesNo, MessageBoxIcon.Question);

            //if the No button was pressed...
            if (result == DialogResult.No)
            {
                //cancel closure of the form.
                e.Cancel = true;
            }
            */
        }

        private void button6_Click(object sender, EventArgs e)
        {
           
        }

        private void button7_Click(object sender, EventArgs e)
        {
            this.Close();
            USBDetector usb = new USBDetector();
            usb.Show();
        }

        private void Slots_Click(object sender, EventArgs e)
        {
            this.Close();
            UsedSlot sl = new UsedSlot();
            sl.Show();
        }

        private void button8_Click(object sender, EventArgs e)
        {
            Document doc = new Document(iTextSharp.text.PageSize.LETTER, 10, 10, 42, 35);// A0, A1,...,A4,...
            PdfWriter writer = PdfWriter.GetInstance(doc, new FileStream("hardware.pdf", FileMode.Create));
            doc.Open();//open Document to write
            //write some content
            Paragraph para = new Paragraph("Wish List Of Items");
            Paragraph para1 = new Paragraph("\n");
            para.Alignment = Element.ALIGN_CENTER;
            doc.Add(para);
            doc.Add(para1);

            //list.IndentationLeft = 35f; when we create a list with a margin in the left

            //Add Header
            /*
            BaseFont bfntHead = BaseFont.CreateFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            iTextSharp.text.Font fntHead = new iTextSharp.text.Font(bfntHead, 16, 1, Color.GRAY);
            Paragraph prgHeading = new Paragraph();
            prgHeading.Alignment = Element.ALIGN_CENTER;
            prgHeading.Add(new Chunk("Wish List Of Items".ToUpper(), fntHead));
            doc.Add(prgHeading);
            */
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

            doc.Close();//close document
            //MessageBox.Show("Your Liste have been Created in PDF file successfully!");

            this.timer2.Start();

            System.Diagnostics.Process.Start("hardware.pdf");// (@"C:\Users\DARIN\Documents\Visual Studio 2017\Projects\FOI_PROJECT\FOI_PROJECT\bin\Debug\hardware.pdf");

        }

        private void progressBar1_Click(object sender, EventArgs e)
        {

        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            this.progressBar1.Increment(10);
        }

        private void mother_Click(object sender, EventArgs e)
        {
            
        }

        private void button9_Click(object sender, EventArgs e)
        {
            /*SelectQuery Sq = new SelectQuery("Win32_BaseBoard");// ("Win32_MotherboardDevice"); 
            ManagementObjectSearcher objOSDetails = new ManagementObjectSearcher(Sq);
            ManagementObjectCollection osDetailsCollection = objOSDetails.Get();
            StringBuilder sb = new StringBuilder();
            foreach (ManagementObject mo in osDetailsCollection)*/

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

        private void lblDesignation_Click(object sender, EventArgs e)
        {

        }

        private void button11_Click(object sender, EventArgs e)
        {
            this.Close();
            RAM r = new RAM();
            r.Show();
        }

        private void label3_Click(object sender, EventArgs e)
        {
            /*ComputerInfo CI = new ComputerInfo();
            ulong mem = ulong.Parse(CI.AvailablePhysicalMemory.ToString());
            usedRam.Text = (mem / (1024 * 1024) + " MB").ToString();*/
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

        private void label6_Click(object sender, EventArgs e)
        {

        }

        private void button4_Click_1(object sender, EventArgs e)
        {
            this.Close();
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
                string query = "UPDATE compatibility SET compatible = '1' WHERE id1 = '" + SelectedItem1.Text + "' AND id2 = '" + SelectedItem2.Text + "' ";
                SqlCommand sc = new SqlCommand(query, con);
                sc.ExecuteNonQuery();

                Fill_Compatible();

                MessageBox.Show("The level of Optimal Compatibility has been Reach between the two components.");

                SelectedItem1.Text = "";
                SelectedItem2.Text = "";
            }
        }
    }
}