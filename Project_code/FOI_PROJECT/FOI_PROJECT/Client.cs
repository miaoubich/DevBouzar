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
        String str, str1;
        SqlCommandBuilder scb;
        SqlCommand cmd;
        int i = 0;
        int i1 = 0;
        int stock1 = 0;
        int qBuy = 0;
        int qLeft = 0;
        int v = 0, v1;
        
        public Client()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
           this.Close();
           Principle p = new Principle();
           p.Show(); 
        }

        private void Client_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
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
            str = "SELECT item1.code_item AS [code], item1.designation, item1.model, item1.brand, item1.price, item1.stock, " +
                  "item2.designation AS [Compatible with] FROM component item1, component item2, compatibility comp " +
                  "WHERE comp.id1 = item1.id AND comp.id2 = item2.id";
            sda = new SqlDataAdapter(str, con);
            dt = new DataTable();
            sda.Fill(dt);
            ItemsTable.DataSource = dt;

            /*foreach (DataRow item in dt.Rows)
            {
                int n = dataGridView1.Rows.Add();
                dataGridView1.Rows[n].Cells[0].Value = false;
                dataGridView1.Rows[n].Cells[1].Value = item[1].ToString();
                dataGridView1.Rows[n].Cells[2].Value = item[2].ToString();
                dataGridView1.Rows[n].Cells[3].Value = item[3].ToString();
                dataGridView1.Rows[n].Cells[4].Value = item[4].ToString();
                dataGridView1.Rows[n].Cells[5].Value = item[5].ToString();
                dataGridView1.Rows[n].Cells[6].Value = item[6].ToString();
                dataGridView1.Rows[n].Cells[7].Value = item[7].ToString();
                dataGridView1.Rows[n].Cells[8].Value = item[8].ToString();
            }*/
        }

        void Fill_wish()
        {
            str = "SELECT code_item, designation, model, brand, price, quantity FROM wish_List";
            sda1 = new SqlDataAdapter(str, con);
            dt1 = new DataTable();
            sda1.Fill(dt1);
            wish_Table.DataSource = dt1;
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }


        private void txtPrint_Click(object sender, EventArgs e)
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
        }

        private void progressBar1_Click(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void button4_Click(object sender, EventArgs e)
        {

        }

        private void button3_Click(object sender, EventArgs e)
        {
            cmd = new SqlCommand("UPDATE wish_List SET quantity = " + txt_Quantity.Text + " WHERE id = " + txt_Search.Text + "", con);
            cmd.ExecuteNonQuery();
            
            i1 = Convert.ToInt32(txt_Search.Text);
            int r1 = ItemsTable.Rows.Count;
            int t1 = i1 - r1;

            if (t1 > 0)
            {
                i = i1 - t1 - 1;
                qBuy = Convert.ToInt32(txt_Quantity.Text);
                qLeft = Convert.ToInt32(ItemsTable.Rows[i].Cells[6].Value.ToString());
                stock1 = qLeft - qBuy;
                stock1 = Convert.ToInt32(stock1);
                SqlCommand cmd1 = new SqlCommand("UPDATE component SET stock = " + stock1 + " WHERE id = " + txt_Search.Text + "", con);
                cmd1.ExecuteNonQuery();
            }
            else if(t1 < 0)
            {
                i = i1 - 1;
                qBuy = Convert.ToInt32(txt_Quantity.Text);
                qLeft = Convert.ToInt32(ItemsTable.Rows[i].Cells[6].Value.ToString());
                stock1 = qLeft - qBuy;
                stock1 = Convert.ToInt32(stock1);
                SqlCommand cmd1 = new SqlCommand("UPDATE component SET stock = " + stock1 + " WHERE id = " + txt_Search.Text + "", con);
                cmd1.ExecuteNonQuery();
            }
            else
            {
                i = i1 - 2;
                qBuy = Convert.ToInt32(txt_Quantity.Text);
                qLeft = Convert.ToInt32(ItemsTable.Rows[i].Cells[6].Value.ToString());
                stock1 = qLeft - qBuy;
                stock1 = Convert.ToInt32(stock1);
                SqlCommand cmd1 = new SqlCommand("UPDATE component SET stock = " + stock1 + " WHERE id = " + txt_Search.Text + "", con);
                cmd1.ExecuteNonQuery();
            }
            Fill_table();
            Fill_wish();
            txt_Quantity.Text = "";
            txt_Search.Text = "";
        }

        private void btn_Add_Click(object sender, EventArgs e)
        {
            var r = 0;
            v1 = Convert.ToInt32(txt_Search.Text);
            //v = v - 1;
            r = ItemsTable.Rows.Count;
            int t = v1 - r;
            if (t > 0) {
                v = v1 - t-1;
                SqlCommand cmd = new SqlCommand(@"INSERT INTO wish_List VALUES(" + ItemsTable.Rows[v].Cells[0].Value + ",'" + ItemsTable.Rows[v].Cells[1].Value + "', '" + ItemsTable.Rows[v].Cells[2].Value + "', '" + ItemsTable.Rows[v].Cells[3].Value + "', '" + ItemsTable.Rows[v].Cells[4].Value + "', " + ItemsTable.Rows[v].Cells[5].Value + ", " + ItemsTable.Rows[v].Cells[6].Value + ")", con);
                cmd.ExecuteNonQuery();
                Fill_wish();
            }
            else if(t < 0)
            {
                v = v1-1;
                SqlCommand cmd = new SqlCommand(@"INSERT INTO wish_List VALUES(" + ItemsTable.Rows[v].Cells[0].Value + ",'" + ItemsTable.Rows[v].Cells[1].Value + "', '" + ItemsTable.Rows[v].Cells[2].Value + "', '" + ItemsTable.Rows[v].Cells[3].Value + "', '" + ItemsTable.Rows[v].Cells[4].Value + "', " + ItemsTable.Rows[v].Cells[5].Value + ", " + ItemsTable.Rows[v].Cells[6].Value + ")", con);
                cmd.ExecuteNonQuery();
                Fill_wish();
            }
            else
            {
                v = v1 - 2;
                SqlCommand cmd = new SqlCommand(@"INSERT INTO wish_List VALUES(" + ItemsTable.Rows[v].Cells[0].Value + ",'" + ItemsTable.Rows[v].Cells[1].Value + "', '" + ItemsTable.Rows[v].Cells[2].Value + "', '" + ItemsTable.Rows[v].Cells[3].Value + "', '" + ItemsTable.Rows[v].Cells[4].Value + "', " + ItemsTable.Rows[v].Cells[5].Value + ", " + ItemsTable.Rows[v].Cells[6].Value + ")", con);
                cmd.ExecuteNonQuery();
                Fill_wish();
            }
            txt_Search.Text = "";
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
            else if (comboBox1.Text == "Compatible")
            {
                str = "SELECT FROM component WHERE compatibility LIKE '" + txt_Search.Text + "%'";
                sda = new SqlDataAdapter(str, con);
                dt = new DataTable();
                sda.Fill(dt);
                ItemsTable.DataSource = dt;
            }
        }

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            comboBox1.Text = "";
            /*for (int i = 0; i < dataGridView1.Rows.Count; i++)
            {
                dataGridView1.Rows[i].Cells[0].Value = false;
            }*/
            var item = ItemsTable.Rows[e.RowIndex].Cells[0].Value.ToString();
            txt_Search.Text = item;

            //int id = Convert.ToInt32(dataGridView1.Rows[e.RowIndex].Cells[0].Value.ToString());

            str1 = "SELECT code_item,designation,model,brand,price,stock FROM component WHERE id LIKE '" + txt_Search.Text + "%'";
            sda1 = new SqlDataAdapter(str1, con);
            dt1 = new DataTable();
            sda1.Fill(dt1);
            wish_Table.DataSource = dt1;
        }
    }
}


