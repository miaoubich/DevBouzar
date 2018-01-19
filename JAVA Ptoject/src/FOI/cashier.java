package FOI;

import Data_Base.Parameter;
import Data_Base.ResultSetTableModel;
import Data_Base.DATA_BASE;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.util.GregorianCalendar;

public final class cashier extends javax.swing.JFrame {

    ResultSet rs;
    DATA_BASE db;
    int old, current, now;
    
    public Timer timer = null;
        
    public cashier(){
       db = new DATA_BASE(new Parameter().HOST_DB, new Parameter().USERNAME_DB, new Parameter().PASSWORD_DB, 
                new Parameter().IPHOST, new Parameter().PORT);
        
        initComponents();
         table();
         Date s = new Date();
         Calendar cal = Calendar.getInstance();
        
        SimpleDateFormat tgl = new SimpleDateFormat("EEEE dd MMM yyyy");
        SimpleDateFormat jam = new SimpleDateFormat("HH:mm:ss");
        txt_date.setText(tgl.format(cal.getTime()));
        /*txt_time.setText(jam.format(s));
        //txt_date.setText(tgl.format(s)); 
         //jam();
         timer = new Timer(1000, new ActionListener(){
             public void actionPerformed(ActionEvent e){
                txt_time.setText(jam.format(cal.getTime()));
             }
         });*/
        currentTime();
    }
    
    public void currentTime(){
        
        Thread clock = new Thread(){
            public void run(){
                for(;;){
                    Calendar cal = new GregorianCalendar();
                    int second = cal.get(Calendar.SECOND);
                    int minute = cal.get(Calendar.MINUTE);
                    int hour = cal.get(Calendar.HOUR);
                    txt_time.setText((hour+12) +":"+minute+":"+second);
                    try{
                        sleep(1000);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }
        };
        clock.start();
    }

    public void table() {
        String a[] = {"id", "code_product", "reference", "designation", "storage", "provider", "discount", "price", "stock"};
        rs = db.querySelect(a, "product");
        table_product.setModel(new ResultSetTableModel(rs));
    }
    
    public void importer() {
        String colon[] = {"id","num_invoice","code_product","reference","sales_price","stock_out","subtotal"};
        rs = db.fcSelectCommand(colon, "sales", "num_invoice='" + invoice_num.getText() + "'");
        table_sale.setModel(new ResultSetTableModel(rs));
    }
   
     
     
    /*public void jam() {
        Date s = new Date();
        SimpleDateFormat tgl = new SimpleDateFormat("EEEE-dd-MMM-yyyy");
        SimpleDateFormat jam = new SimpleDateFormat("HH:mm");
        txt_time.setText(jam.format(s));
        txt_date.setText(tgl.format(s)); 
     }*/
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_product = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_rech = new javax.swing.JTextField();
        com_search = new javax.swing.JComboBox<>();
        txt_code = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_reference = new javax.swing.JTextField();
        txt_designation = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_storage = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_provider = new javax.swing.JTextField();
        txt_discount = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        new_price = new javax.swing.JTextField();
        txt_stock = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_price = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        total_Rp1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        invoice_num = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txt_date = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_sale = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtpay = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_cash = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        total_Rp2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        txt_time = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1247, 720));
        setPreferredSize(new java.awt.Dimension(947, 720));
        setSize(new java.awt.Dimension(947, 720));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(" Cashier");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(520, 20, 150, 50);

        table_product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "code_product", "reference", "designation", "storage", "provider", "discount", "price", "stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_productMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_product);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(140, 80, 930, 150);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOI/rsz_back3_1.jpg"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(30, 20, 50, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1230, 250);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 100, 100);

        jPanel3.setMinimumSize(new java.awt.Dimension(900, 800));
        jPanel3.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel3.setText("Search by category:");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(20, 80, 160, 30);

        txt_rech.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_rech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rechActionPerformed(evt);
            }
        });
        jPanel3.add(txt_rech);
        txt_rech.setBounds(180, 110, 160, 30);

        com_search.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id", "code_produit", "reference", "designation", "storage", "provider", "discount", "price", "stock" }));
        com_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_searchActionPerformed(evt);
            }
        });
        jPanel3.add(com_search);
        com_search.setBounds(180, 90, 160, 20);

        txt_code.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codeActionPerformed(evt);
            }
        });
        jPanel3.add(txt_code);
        txt_code.setBounds(140, 190, 110, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Code Product:");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(20, 190, 120, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Reference:");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(20, 230, 90, 30);

        txt_reference.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_reference.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_referenceActionPerformed(evt);
            }
        });
        jPanel3.add(txt_reference);
        txt_reference.setBounds(140, 230, 110, 30);

        txt_designation.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_designation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_designationActionPerformed(evt);
            }
        });
        jPanel3.add(txt_designation);
        txt_designation.setBounds(140, 270, 110, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Designation:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(20, 270, 110, 30);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Storage:");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(20, 310, 90, 30);

        txt_storage.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_storage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_storageActionPerformed(evt);
            }
        });
        jPanel3.add(txt_storage);
        txt_storage.setBounds(140, 310, 110, 30);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Provider:");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(20, 350, 90, 30);

        txt_provider.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_provider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_providerActionPerformed(evt);
            }
        });
        jPanel3.add(txt_provider);
        txt_provider.setBounds(140, 350, 110, 30);

        txt_discount.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_discount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_discountActionPerformed(evt);
            }
        });
        jPanel3.add(txt_discount);
        txt_discount.setBounds(390, 230, 110, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Discount (%):");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(270, 230, 110, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("New price (€):");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(270, 270, 110, 30);

        new_price.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        new_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_priceActionPerformed(evt);
            }
        });
        jPanel3.add(new_price);
        new_price.setBounds(390, 270, 110, 30);

        txt_stock.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_stockActionPerformed(evt);
            }
        });
        txt_stock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_stockKeyReleased(evt);
            }
        });
        jPanel3.add(txt_stock);
        txt_stock.setBounds(390, 310, 110, 30);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Stock out:");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(270, 310, 90, 30);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("TTC : ");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(140, 410, 60, 40);

        txt_price.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_priceActionPerformed(evt);
            }
        });
        jPanel3.add(txt_price);
        txt_price.setBounds(390, 190, 110, 30);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setText("Price:");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(270, 190, 70, 40);

        total_Rp1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        total_Rp1.setText("        0");
        total_Rp1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                total_Rp1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel3.add(total_Rp1);
        total_Rp1.setBounds(220, 410, 80, 40);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel16.setText("€");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(200, 410, 20, 40);

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Add To Sale");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(310, 400, 130, 50);

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(350, 100, 100, 40);

        jButton7.setBackground(new java.awt.Color(102, 102, 255));
        jButton7.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Refresh");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7);
        jButton7.setBounds(350, 140, 100, 40);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 190, 510, 460);

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 34, 14);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 0, 100, 100);

        jPanel5.setMinimumSize(new java.awt.Dimension(870, 450));
        jPanel5.setPreferredSize(new java.awt.Dimension(870, 450));
        jPanel5.setLayout(null);

        invoice_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoice_numActionPerformed(evt);
            }
        });
        jPanel5.add(invoice_num);
        invoice_num.setBounds(430, 160, 160, 30);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Invoice number :");
        jPanel5.add(jLabel14);
        jLabel14.setBounds(300, 160, 130, 30);

        jButton4.setBackground(new java.awt.Color(255, 51, 51));
        jButton4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4);
        jButton4.setBounds(600, 200, 100, 40);

        jButton3.setBackground(new java.awt.Color(51, 51, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3);
        jButton3.setBounds(600, 160, 100, 40);

        jPanel6.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        jLabel12.setText("    Sales Table");
        jLabel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.add(jLabel12);
        jLabel12.setBounds(60, 40, 230, 50);

        txt_date.setBackground(new java.awt.Color(0, 0, 153));
        txt_date.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        txt_date.setForeground(new java.awt.Color(0, 0, 153));
        txt_date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel6.add(txt_date);
        txt_date.setBounds(330, 10, 220, 30);

        jPanel5.add(jPanel6);
        jPanel6.setBounds(20, 50, 570, 90);

        table_sale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "num_invoice", "code_product", "reference", "sales_price", "stock_out", "subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_sale.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                table_saleAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        table_sale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_saleMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_sale);

        jPanel5.add(jScrollPane2);
        jScrollPane2.setBounds(10, 200, 580, 140);

        jLabel21.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Total :");
        jPanel5.add(jLabel21);
        jLabel21.setBounds(40, 360, 110, 40);

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("TTC:");
        jPanel5.add(jLabel19);
        jLabel19.setBounds(140, 360, 60, 40);

        txtpay.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtpay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpay.setText("00");
        txtpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpayActionPerformed(evt);
            }
        });
        jPanel5.add(txtpay);
        txtpay.setBounds(360, 410, 130, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Pay back:");
        jPanel5.add(jLabel18);
        jLabel18.setBounds(250, 410, 90, 30);

        txt_cash.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_cash.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cash.setText("00");
        txt_cash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cashActionPerformed(evt);
            }
        });
        txt_cash.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txt_cashPropertyChange(evt);
            }
        });
        txt_cash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cashKeyReleased(evt);
            }
        });
        jPanel5.add(txt_cash);
        txt_cash.setBounds(100, 410, 130, 30);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Cash :");
        jPanel5.add(jLabel20);
        jLabel20.setBounds(40, 410, 50, 30);

        jButton5.setBackground(new java.awt.Color(102, 102, 255));
        jButton5.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Create Receipt");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5);
        jButton5.setBounds(510, 390, 180, 50);

        jButton6.setBackground(new java.awt.Color(102, 102, 255));
        jButton6.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Cancel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6);
        jButton6.setBounds(600, 240, 100, 40);

        total_Rp2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        total_Rp2.setText("        0");
        total_Rp2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                total_Rp2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                total_Rp2AncestorRemoved(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                total_Rp2AncestorMoved(evt);
            }
        });
        total_Rp2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                total_Rp2PropertyChange(evt);
            }
        });
        jPanel5.add(total_Rp2);
        total_Rp2.setBounds(220, 360, 90, 40);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel17.setText("€");
        jPanel5.add(jLabel17);
        jLabel17.setBounds(200, 360, 30, 40);

        jButton9.setBackground(new java.awt.Color(102, 102, 255));
        jButton9.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Sales List");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton9);
        jButton9.setBounds(600, 280, 100, 40);

        txt_time.setBackground(new java.awt.Color(0, 0, 0));
        txt_time.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        txt_time.setForeground(new java.awt.Color(0, 0, 153));
        txt_time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_time.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txt_time.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txt_timeAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel5.add(txt_time);
        txt_time.setBounds(560, 60, 130, 30);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(530, 200, 700, 750);

        jLabel22.setText("jLabel22");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(0, 0, 60, 30);

        jLabel23.setText("jLabel23");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(0, 0, 40, 14);

        setSize(new java.awt.Dimension(1250, 697));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txt_rech.getText().equals("")){
            JOptionPane.showMessageDialog(this, "PLEASE, Enter something!");// if you click on search botton with an empty text field
        } else {
            if (com_search.getSelectedItem().equals("id")) {
                rs = db.querySelectAll("product", "id LIKE '%" + txt_rech.getText() + "%' ");
                table_product.setModel(new ResultSetTableModel(rs));
            } else if (com_search.getSelectedItem().equals("code_product")) {
                rs = db.querySelectAll("product", "code_product LIKE '%" + txt_rech.getText() + "%' ");
                table_product.setModel(new ResultSetTableModel(rs));
            }else if (com_search.getSelectedItem().equals("reference")) {
                rs = db.querySelectAll("product", "reference LIKE '%" + txt_rech.getText() + "%' ");
                table_product.setModel(new ResultSetTableModel(rs));
            }else if (com_search.getSelectedItem().equals("designation")) {
                rs = db.querySelectAll("product", "designation LIKE '%" + txt_rech.getText() + "%' ");
                table_product.setModel(new ResultSetTableModel(rs));
            }else if (com_search.getSelectedItem().equals("storage")) {
                rs = db.querySelectAll("product", "storage LIKE '%" + txt_rech.getText() + "%' ");
                table_product.setModel(new ResultSetTableModel(rs));
            }else if (com_search.getSelectedItem().equals("provider")) {
                rs = db.querySelectAll("product", "provider LIKE '%" + txt_rech.getText() + "%' ");
                table_product.setModel(new ResultSetTableModel(rs));
            }else if (com_search.getSelectedItem().equals("discount")) {
                rs = db.querySelectAll("product", "discount LIKE '%" + txt_rech.getText() + "%' ");
                table_product.setModel(new ResultSetTableModel(rs));
            }else if (com_search.getSelectedItem().equals("price")) {
                rs = db.querySelectAll("product", "price LIKE '%" + txt_rech.getText() + "%' ");
                table_product.setModel(new ResultSetTableModel(rs));
            }else if (com_search.getSelectedItem().equals("stock")) {
                rs = db.querySelectAll("product", "stock LIKE '%" + txt_rech.getText() + "%' ");
                table_product.setModel(new ResultSetTableModel(rs));
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_rechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rechActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rechActionPerformed

    private void com_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_com_searchActionPerformed

    private void txt_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codeActionPerformed

    private void txt_referenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_referenceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_referenceActionPerformed

    private void txt_designationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_designationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_designationActionPerformed

    private void txt_storageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_storageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_storageActionPerformed

    private void txt_providerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_providerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_providerActionPerformed

    private void txt_discountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_discountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_discountActionPerformed

    private void new_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_new_priceActionPerformed

    private void txt_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_stockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_stockActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (txt_code.getText().equals("") || txt_reference.getText().equals("") || txt_designation.getText().equals("")
            || txt_storage.getText().equals("") || txt_discount.getText().equals("") || txt_price.getText().equals("") 
                || txt_stock.getText().equals("")|| txt_provider.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter the DATA!");
        } else if (invoice_num.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter an INVOICE NUMBER!");
        } else {
            String[] colon = {"num_invoice","code_product", "reference", "sales_price", "stock_out", "subtotal"};
            String[] sales_data = {invoice_num.getText(), txt_code.getText(), txt_reference.getText(), new_price.getText(), txt_stock.getText(), total_Rp1.getText()};//RP: lbltot1(subtotal)
            System.out.println(db.queryInsert("sales", colon, sales_data));
            try {
                if (!test_stock()) {
                    JOptionPane.showMessageDialog(this, "The stock is limited!");
                } else {
                    def(); //true
                    table(); //true
                }
            } catch (SQLException ex) {
                Logger.getLogger(cashier.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("\n"+ex);
            }
            subtotal();
            importer();
            total();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void invoice_numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoice_numActionPerformed
        // TODO add your handling code here:
        /*String s;
        s = invoice_num.getText();
        receipt.set_st(s);*/
    }//GEN-LAST:event_invoice_numActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String id = String.valueOf(table_sale.getValueAt(table_sale.getSelectedRow(), 0));
        if (JOptionPane.showConfirmDialog(this, "Are you sure to delete this data? ", "ATTENTION!", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            db.queryDelete("sales", "id=" + id);
        } else {
            return;
        }
        importer();
        total();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        importer();
        total();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txt_cashKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cashKeyReleased
        payafter();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cashKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        receipt1 n = new receipt1();
         n.setVisible(true);
         payafter();
    }//GEN-LAST:event_jButton5ActionPerformed

    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String invoice = invoice_num.getText();
        if (JOptionPane.showConfirmDialog(this,"Are you sure you want to cancel? ","attention!!!", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            db.queryDelete("sales", "num_invoice = " + invoice);
        } else {
            return;
        }
        importer();
        total();
        txt_cash.setText("00");
        txtpay.setText("00");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txt_stockKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_stockKeyReleased
        subtotal();
    }//GEN-LAST:event_txt_stockKeyReleased

    private void table_productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_productMouseClicked
        txt_code.setText(String.valueOf(table_product.getValueAt(table_product.getSelectedRow(), 1)));
        txt_reference.setText(String.valueOf(table_product.getValueAt(table_product.getSelectedRow(), 2)));
        txt_designation.setText(String.valueOf(table_product.getValueAt(table_product.getSelectedRow(), 3)));
        txt_storage.setText(String.valueOf(table_product.getValueAt(table_product.getSelectedRow(), 4)));
        txt_provider.setText(String.valueOf(table_product.getValueAt(table_product.getSelectedRow(), 5)));
        txt_discount.setText(String.valueOf(table_product.getValueAt(table_product.getSelectedRow(), 6)));
        txt_price.setText(String.valueOf(table_product.getValueAt(table_product.getSelectedRow(), 7)));
        //new_price.setText(String.valueOf(table_product.getValueAt(table_product.getSelectedRow(), 8)));
        //txt_stock.setText(String.valueOf(table_product.getValueAt(table_product.getSelectedRow(), 9)));
       cout();
    }//GEN-LAST:event_table_productMouseClicked

    private void txt_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_priceActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        table();
        txt_code.setText("");
        txt_reference.setText("");
        txt_designation.setText("");
        txt_storage.setText("");
        txt_provider.setText("");
        txt_discount.setText("");
        txt_price.setText("");
        new_price.setText("");
        txt_stock.setText("");
        total_Rp1.setText("0");
        invoice_num.setText("");
        importer();
        total();
        txt_cash.setText("00");
        txtpay.setText("00");
        total_Rp2.setText("00");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.dispose();
        Principle p = new Principle();
        p.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txt_cashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cashActionPerformed
        // TODO add your handling code here:
        
        /*String s2;
        s2 = txt_cash.getText();
        receipt.set_st(s2);*/
    }//GEN-LAST:event_txt_cashActionPerformed

    private void table_saleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_saleMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_table_saleMouseClicked

    private void total_Rp1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_total_Rp1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_total_Rp1AncestorAdded

    private void table_saleAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_table_saleAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_table_saleAncestorAdded

    private void total_Rp2AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_total_Rp2AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_total_Rp2AncestorMoved

    private void total_Rp2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_total_Rp2AncestorAdded
        // TODO add your handling code here:
        /*String s1;
        s1 = total_Rp2.getText();
        receipt.set_st(s1);*/
    }//GEN-LAST:event_total_Rp2AncestorAdded

    private void total_Rp2AncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_total_Rp2AncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_total_Rp2AncestorRemoved

    private void txtpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpayActionPerformed

    private void txt_cashPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txt_cashPropertyChange
        // TODO add your handling code here:
       /*String s2;
        s2 = txt_cash.getText();
        receipt.set_st(s2);
        //javax.swing.JOptionPane.showMessageDialog(null,s2);*/
    }//GEN-LAST:event_txt_cashPropertyChange

    private void total_Rp2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_total_Rp2PropertyChange
        // TODO add your handling code here:
        /*String s1;
        s1 = total_Rp2.getText();
        receipt.set_st(s1);*/
        //javax.swing.JOptionPane.showMessageDialog(null,s1); 
    }//GEN-LAST:event_total_Rp2PropertyChange

    private void txt_timeAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txt_timeAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timeAncestorAdded

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Sales s = new Sales();
        s.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    public void cout() {
        double a = Double.parseDouble(txt_price.getText());
        double b = Double.parseDouble(txt_discount.getText());
        double c = a - a * (b / 100);
        new_price.setText(String.valueOf(c));
    }
    
    public void subtotal() {
        double a = Double.parseDouble(new_price.getText());
        double b = Double.parseDouble(txt_stock.getText());
        double c = a * b;
        total_Rp1.setText(String.valueOf(c));// lbltot1:represent RP
    }
    
    public boolean test_stock() throws SQLException {
        boolean teststock;
        rs = db.querySelectAll("product","code_product='" + txt_code.getText() + "'");
        while (rs.next()) {
            old = rs.getInt("stock");
        }
        current = Integer.parseInt(txt_stock.getText());
        if (old < current) {
            teststock = false;
        } else {
            teststock = true;
        }
        return teststock;
    }
    
    public void def() throws SQLException {
        rs = db.querySelectAll("product", "code_product='" + txt_code.getText() + "'");
        while (rs.next()) {
            old = rs.getInt("stock");
        }
        current = Integer.parseInt(txt_stock.getText());
        now = old - current;
         String newstock = Integer.toString(now);

        String a = String.valueOf(newstock);
        String[] colon = {"stock"};
        String[] isi = {a};
        System.out.println(db.queryUpdate("product", colon, isi, "code_product='" + txt_code.getText() + "'"));
    }
    
     public void total() {
        rs = db.exécutionQuery("SELECT SUM(subtotal) as subtotal FROM sales WHERE num_invoice = '" + invoice_num.getText() + "'");
        try {
            rs.next();
            //total_Rp2.setText(rs.getString("total_Rp1"));
            total_Rp2.setText(rs.getString("subtotal"));
        } catch (SQLException ex) {
            Logger.getLogger(cashier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void payafter() {
        double a = Double.parseDouble(total_Rp1.getText()); 
        double b = Double.parseDouble(txt_cash.getText());
        double c = b - a;
        txtpay.setText(Double.toString(c));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new cashier().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> com_search;
    public static javax.swing.JTextField invoice_num;
    private javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton3;
    public static javax.swing.JButton jButton4;
    public static javax.swing.JButton jButton5;
    public static javax.swing.JButton jButton6;
    public static javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    public static javax.swing.JLabel jLabel13;
    public static javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    public static javax.swing.JLabel jLabel18;
    public static javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel20;
    public static javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    public static javax.swing.JPanel jPanel4;
    public static javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField new_price;
    private javax.swing.JTable table_product;
    private javax.swing.JTable table_sale;
    private javax.swing.JLabel total_Rp1;
    public static javax.swing.JLabel total_Rp2;
    public static javax.swing.JTextField txt_cash;
    private javax.swing.JTextField txt_code;
    public static javax.swing.JLabel txt_date;
    private javax.swing.JTextField txt_designation;
    private javax.swing.JTextField txt_discount;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_provider;
    private javax.swing.JTextField txt_rech;
    private javax.swing.JTextField txt_reference;
    private javax.swing.JTextField txt_stock;
    private javax.swing.JTextField txt_storage;
    public static javax.swing.JLabel txt_time;
    public static javax.swing.JTextField txtpay;
    // End of variables declaration//GEN-END:variables
}
