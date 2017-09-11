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

namespace FOI_PROJECT
{
    public partial class Client : Form
    {

        SqlConnection con;
        SqlDataAdapter sda, sda1;
        DataTable dt, dt1;
        String str;
        SqlCommand cmd;
        
        public Client()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (Form1.utype == "administrator")
            {
                this.Hide();
                Principle p = new Principle();
                p.Show();
            }
            else
            {
                const string m = "Please confirm closing the system?";
                const string cap = "Closing FORM.";
                var result = MessageBox.Show(m, cap, MessageBoxButtons.YesNo,MessageBoxIcon.Question);
                if (result == DialogResult.Yes) {
                    Application.Exit();
                }
                else
                {

                }
            }
        }

        private void Client_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
           
        }

        private void Client_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the '_17075i_DBDataSet8.component' table. You can move, or remove it, as needed.
            this.componentTableAdapter1.Fill(this._17075i_DBDataSet8.component);

            con = new SqlConnection(@"Data Source=31.147.204.119\PISERVER,1433;Initial Catalog=17075i_DB;Persist Security Info=True;User ID=17075i_User;Password=Gjrwxk63");

            if (con.State == ConnectionState.Open)
            {
                con.Close();
            }
            con.Open();
            Fill_table();
            Fill_wish();
        }

        void Fill_table()
        {
            str = "SELECT item1.id, item1.code_item AS [code], item1.designation, item1.model, item1.brand, item1.price, item1.stock, " +
                  "item2.designation AS [Compatible with] FROM component item1, component item2, compatibility comp " +
                  "WHERE comp.id1 = item1.id AND comp.id2 = item2.id ORDER BY item1.id ASC";
            sda = new SqlDataAdapter(str, con);
            dt = new DataTable();
            sda.Fill(dt);
            ItemsTable.DataSource = dt;
        }

        void Fill_wish()
        {
            str = "SELECT *FROM wish_List";
            sda1 = new SqlDataAdapter(str, con);
            dt1 = new DataTable();
            sda1.Fill(dt1);
            wish_Table.DataSource = dt1;
        }
        
        private void txtPrint_Click(object sender, EventArgs e)
        {
            Random r = new Random();
            int x = r.Next(100000);
            Document doc = new Document(iTextSharp.text.PageSize.LETTER, 10, 10, 42, 35);// A0, A1,...,A4,...
            PdfWriter writer = PdfWriter.GetInstance(doc, new FileStream("Shopping List"+ x + ".pdf", FileMode.Create));
            doc.Open();//open Document to write
            //write some content
            Paragraph para = new Paragraph("Components Shopping List");
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
            PdfPTable table = new PdfPTable(wish_Table.Columns.Count);
            //Add the header from txt_Table to the table
            for (int j = 0; j < wish_Table.Columns.Count; j++)
            {
                table.AddCell(new Phrase(wish_Table.Columns[j].HeaderText));
            }
            //Flag the first row as a header
            table.HeaderRows = 1;
            //Add the actual rows from txt_Table to the table
            for (int i = 0; i < wish_Table.Rows.Count; i++)
            {
                for (int k = 0; k < wish_Table.Columns.Count; k++)
                {
                    if (wish_Table[k, i].Value != null)
                    {
                        table.AddCell(new Phrase(wish_Table[k, i].Value.ToString()));
                    }
                }
            }
            //Add out table
            doc.Add(table);

            doc.Close();//close document
            //MessageBox.Show("Your Liste have been Created in PDF file successfully!");

            this.timer1.Start();

            System.Diagnostics.Process.Start("hardware.pdf");// (@"C:\Users\DARIN\Documents\Visual Studio 2017\Projects\FOI_PROJECT\FOI_PROJECT\bin\Debug\hardware.pdf");

        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            this.progressBar1.Increment(50);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            comboBox1.Text = "";
            txt_Search.Text = "";
            Fill_table();
            timer1.Stop();
            progressBar1.Value = 0;
            Fill_wish();

            txt_ID.Text = "";
            txt_Code.Text = "";
            txt_Designation.Text = "";
            txt_Model.Text = "";
            txt_Brand.Text = "";
            txt_Price.Text = "";
            txt_Quantite.Text = "";
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void button4_Click(object sender, EventArgs e)
        {
            if (txt_ID.Text != "" && txt_Code.Text != "" && txt_Designation.Text != "" && txt_Model.Text != "" && txt_Brand.Text != "" && txt_Price.Text != "" && txt_Quantite.Text != "")
            {
                string strDelete = "DELETE FROM wish_List WHERE id = " + txt_ID.Text + "";
                SqlCommand sc = new SqlCommand(strDelete, con);
                sc.ExecuteNonQuery();

                Fill_wish();

                txt_ID.Text = "";
                txt_Code.Text = "";
                txt_Designation.Text = "";
                txt_Model.Text = "";
                txt_Brand.Text = "";
                txt_Price.Text = "";
                txt_Quantite.Text = "";

                MessageBox.Show("Item has been DELETED Successfully!");
            }
            else
            {
                MessageBox.Show("Please select an item from the wish list.");
            }
        }

        private void wish_Table_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            txt_ID.Text = wish_Table.Rows[e.RowIndex].Cells[0].Value.ToString();
            txt_Code.Text = wish_Table.Rows[e.RowIndex].Cells[1].Value.ToString();
            txt_Designation.Text = wish_Table.Rows[e.RowIndex].Cells[2].Value.ToString();
            txt_Model.Text = wish_Table.Rows[e.RowIndex].Cells[3].Value.ToString();
            txt_Brand.Text = wish_Table.Rows[e.RowIndex].Cells[4].Value.ToString();
            txt_Price.Text = wish_Table.Rows[e.RowIndex].Cells[5].Value.ToString();
            txt_Quantite.Text = wish_Table.Rows[e.RowIndex].Cells[6].Value.ToString();

        }

        private void button3_Click_1(object sender, EventArgs e)
        {
            const string m = "Please confirm deleting your items wish list?";
            const string c = "CONFIRM DELETION";
            var result = MessageBox.Show(m, c, MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (result == DialogResult.Yes)
            {

                string str = "TRUNCATE TABLE wish_List";
                cmd = new SqlCommand(str, con);
                cmd.ExecuteNonQuery();
                Fill_wish();
                MessageBox.Show("The Wish List has been DELETED Successfully!");
            }
            else
            {

            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (txt_ID.Text != "" && txt_Code.Text != "" && txt_Designation.Text != "" && txt_Model.Text != "" && txt_Brand.Text != "" && txt_Price.Text != "" && txt_Quantite.Text != "")
            {
                //string QuantityBack = "SELECT quantity FROM Wish_List WHERE id = " + txt_ID.Text + "";

                cmd = new SqlCommand("UPDATE wish_List SET quantity = " + txt_Quantite.Text + " WHERE id = " + txt_ID.Text + "", con);
                cmd.ExecuteNonQuery();

                txt_ID.Text = "";
                txt_Code.Text = "";
                txt_Designation.Text = "";
                txt_Model.Text = "";
                txt_Brand.Text = "";
                txt_Price.Text = "";
                txt_Quantite.Text = "";
                txt_Search.Text = "";

                Fill_table();
                Fill_wish();

                MessageBox.Show("Item has been UPDATED Successfully!");
            }
            else
            {
                MessageBox.Show("Please select an item from the wish list.");
            }
        }

        private void btn_Add_Click(object sender, EventArgs e)
        {
            if(txt_ID.Text != "" && txt_Code.Text != "" && txt_Designation.Text != "" && txt_Model.Text != "" && txt_Brand.Text != "" && txt_Price.Text != "" && txt_Quantite.Text != ""){

                string strAdd = "INSERT INTO wish_List(code_item, designation, model, brand, price, quantity) " +
                                "VALUES('" + txt_Code.Text + "', '" + txt_Designation.Text + "', '" + txt_Model.Text + "'," +
                                " '" + txt_Brand.Text + "', " + txt_Price.Text + ", " + txt_Quantite.Text + ")";
                SqlCommand sc = new SqlCommand(strAdd, con);
                sc.ExecuteNonQuery();

                string oldstk = "SELECT stock FROM component WHERE id = " + txt_ID.Text + "";
                string soldQ = "SELECT quantity FROM wish_List WHERE code_item = '"+ txt_Code.Text + "'";

                SqlCommand sc1 = new SqlCommand(oldstk, con);
                sc1.ExecuteNonQuery();
                string oldStock = sc1.ExecuteScalar().ToString();

                SqlCommand sc2 = new SqlCommand(soldQ, con);
                sc2.ExecuteScalar();
                string SoldQuantity = sc2.ExecuteScalar().ToString();

                int oldStock1 = int.Parse(oldStock);
                int SoldQuantity1 = int.Parse(SoldQuantity);

                int NewStock = oldStock1 - SoldQuantity1;
                if (NewStock >= 0) {
                    /*
                    string strAdd = "INSERT INTO wish_List(code_item, designation, model, brand, price, quantity) " +
                                "VALUES('" + txt_Code.Text + "', '" + txt_Designation.Text + "', '" + txt_Model.Text + "'," +
                                " '" + txt_Brand.Text + "', " + txt_Price.Text + ", " + txt_Quantite.Text + ")";
                    SqlCommand sc = new SqlCommand(strAdd, con);
                    sc.ExecuteNonQuery();*/
                    
                    string UpdateQuantity = "UPDATE component SET stock = " + NewStock + " WHERE id = " + txt_ID.Text + "";
                    SqlCommand cmdUpdate = new SqlCommand(UpdateQuantity, con);
                    cmdUpdate.ExecuteNonQuery();
                }
                else
                {
                    MessageBox.Show("Sorry but the quantity selected is not available, please adjust the quantity.");
                    txt_Quantite.Text = "";
                }
                txt_ID.Text = "";
                txt_Code.Text = "";
                txt_Designation.Text = "";
                txt_Model.Text = "";
                txt_Brand.Text = "";
                txt_Price.Text = "";
                txt_Quantite.Text = "";

                Fill_table();
                Fill_wish();

                txt_Search.Text = "";
            }
            else
            {
                MessageBox.Show("Please select an item from the component table.");
            }
        }

        private void txt_Quantite_Leave(object sender, EventArgs e)
        {

        }

        private void txt_Search_TextChanged(object sender, EventArgs e)
        {
            if (comboBox1.Text == "Code Item")
            {
                str = "SELECT *from component WHERE code_item LIKE '" + txt_Search.Text + "%'";
                sda = new SqlDataAdapter(str, con);
                dt = new DataTable();
                sda.Fill(dt);
                ItemsTable.DataSource = dt;
            }
            else if (comboBox1.Text == "Designation")
            {
                str = "SELECT *FROM component WHERE designation LIKE '" + txt_Search.Text + "%'";
                sda = new SqlDataAdapter(str, con);
                dt = new DataTable();
                sda.Fill(dt);
                ItemsTable.DataSource = dt;
            }
            else if (comboBox1.Text == "Model")
            {
                str = "SELECT *FROM component WHERE model LIKE '" + txt_Search.Text + "%'";
                sda = new SqlDataAdapter(str, con);
                dt = new DataTable();
                sda.Fill(dt);
                ItemsTable.DataSource = dt;
            }
            else if (comboBox1.Text == "Brand")
            {
                str = "SELECT *FROM component WHERE brand LIKE '" + txt_Search.Text + "%'";
                sda = new SqlDataAdapter(str, con);
                dt = new DataTable();
                sda.Fill(dt);
                ItemsTable.DataSource = dt;
            }
            else if (comboBox1.Text == "Price")
            {
                str = "SELECT *FROM component WHERE price LIKE '" + txt_Search.Text + "%'";
                sda = new SqlDataAdapter(str, con);
                dt = new DataTable();
                sda.Fill(dt);
                ItemsTable.DataSource = dt;
            }
            else if (comboBox1.Text == "Stock")
            {
                str = "SELECT *FROM component WHERE stock LIKE '" + txt_Search.Text + "%'";
                sda = new SqlDataAdapter(str, con);
                dt = new DataTable();
                sda.Fill(dt);
                ItemsTable.DataSource = dt;
            }
        }

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            comboBox1.Text = "";
            
            txt_ID.Text = ItemsTable.Rows[e.RowIndex].Cells[0].Value.ToString();
            txt_Code.Text = ItemsTable.Rows[e.RowIndex].Cells[1].Value.ToString();
            txt_Designation.Text = ItemsTable.Rows[e.RowIndex].Cells[2].Value.ToString();
            txt_Model.Text = ItemsTable.Rows[e.RowIndex].Cells[3].Value.ToString();
            txt_Brand.Text = ItemsTable.Rows[e.RowIndex].Cells[4].Value.ToString();
            txt_Price.Text = ItemsTable.Rows[e.RowIndex].Cells[5].Value.ToString();
            txt_Quantite.Text = ItemsTable.Rows[e.RowIndex].Cells[6].Value.ToString();

            int q = int.Parse(txt_Quantite.Text);

            if (q<1)
            {
                txt_ID.Text = "";
                txt_Code.Text = "";
                txt_Designation.Text = "";
                txt_Model.Text = "";
                txt_Brand.Text = "";
                txt_Price.Text = "";
                txt_Quantite.Text = "";

                MessageBox.Show("Sorry but this item is not available.");
            }
            //int id = Convert.ToInt32(dataGridView1.Rows[e.RowIndex].Cells[0].Value.ToString());
            
        }
    }
}


