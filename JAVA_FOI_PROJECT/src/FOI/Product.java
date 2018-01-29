package FOI;

import Data_Base.DATA_BASE;
import Data_Base.Parameter;
import Data_Base.ResultSetTableModel;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.text.*;


public class Product extends javax.swing.JFrame {

    ResultSet rs;
    DATA_BASE db;
    
    public Product(){
        db = new DATA_BASE(new Parameter().HOST_DB, new Parameter().USERNAME_DB, new Parameter().PASSWORD_DB, 
                new Parameter().IPHOST, new Parameter().PORT);
        
        initComponents();
        table();
    }
    
    public void table() {
        String a[] = {"id", "code_product", "reference", "designation", "storage", "provider", "discount", "price", "stock"};
        rs = db.querySelect(a, "product");
        table_product.setModel(new ResultSetTableModel(rs));
    }
    
    void refreash() {
        txt_code.setText("");
        txt_reference.setText("");
        txt_designation.setText("");
        txt_storage.setText("");
        txt_provider.setText("");
        txt_discount.setText("");
        txt_price.setText("");
        txt_stock.setText("");
        com_search.setSelectedItem("Typpppe");
        txt_rech.setText("");
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_product = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_rech = new javax.swing.JTextField();
        com_search = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_code = new javax.swing.JTextField();
        txt_reference = new javax.swing.JTextField();
        txt_designation = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_provider = new javax.swing.JTextField();
        txt_discount = new javax.swing.JTextField();
        txt_price = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_storage = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_stock = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(820, 560));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        jLabel1.setText(" Product Management");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(210, 20, 370, 52);

        table_product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Code Product", "Reference", "Designation", "Storage", "Provider", "Discount", "Price", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_productMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_product);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 90, 779, 150);

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(160, 250, 110, 40);

        jButton3.setBackground(new java.awt.Color(102, 102, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Modify");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(270, 250, 110, 40);

        jButton4.setBackground(new java.awt.Color(255, 51, 51));
        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(490, 250, 110, 40);

        jButton5.setBackground(new java.awt.Color(102, 102, 255));
        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(380, 250, 110, 40);

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(540, 350, 90, 40);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel3.setText("Search by category:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(490, 310, 160, 30);

        txt_rech.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_rech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rechActionPerformed(evt);
            }
        });
        getContentPane().add(txt_rech);
        txt_rech.setBounds(640, 360, 160, 30);

        com_search.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id", "code_product", "reference", "designation", "storage", "provider", "discount", "price", "stock" }));
        com_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_searchActionPerformed(evt);
            }
        });
        getContentPane().add(com_search);
        com_search.setBounds(650, 320, 140, 20);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Reference:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 380, 80, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Designation:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 420, 100, 30);

        txt_code.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codeActionPerformed(evt);
            }
        });
        getContentPane().add(txt_code);
        txt_code.setBounds(120, 340, 110, 30);

        txt_reference.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_reference.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_referenceActionPerformed(evt);
            }
        });
        getContentPane().add(txt_reference);
        txt_reference.setBounds(120, 380, 110, 30);

        txt_designation.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_designation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_designationActionPerformed(evt);
            }
        });
        getContentPane().add(txt_designation);
        txt_designation.setBounds(120, 420, 110, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Code Product:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 340, 110, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Discount (%):");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(260, 380, 100, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Price (€):");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(260, 420, 80, 30);

        txt_provider.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_provider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_providerActionPerformed(evt);
            }
        });
        getContentPane().add(txt_provider);
        txt_provider.setBounds(370, 340, 110, 30);

        txt_discount.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_discount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_discountActionPerformed(evt);
            }
        });
        getContentPane().add(txt_discount);
        txt_discount.setBounds(370, 380, 110, 30);

        txt_price.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_priceActionPerformed(evt);
            }
        });
        getContentPane().add(txt_price);
        txt_price.setBounds(370, 420, 110, 30);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Provider:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(260, 340, 80, 30);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Storage:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(10, 460, 80, 30);

        txt_storage.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_storage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_storageActionPerformed(evt);
            }
        });
        getContentPane().add(txt_storage);
        txt_storage.setBounds(120, 460, 110, 30);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Stock:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(260, 460, 80, 30);

        txt_stock.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_stockActionPerformed(evt);
            }
        });
        getContentPane().add(txt_stock);
        txt_stock.setBounds(370, 460, 110, 30);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOI/rsz_back3_1.jpg"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(20, 20, 50, 47);

        jButton6.setBackground(new java.awt.Color(102, 102, 255));
        jButton6.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Print");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(600, 430, 130, 50);

        setSize(new java.awt.Dimension(827, 559));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (txt_code.getText().equals("") || txt_reference.getText().equals("") || txt_designation.getText().equals("")
                || txt_storage.getText().equals("") || txt_provider.getText().equals("") || txt_discount.getText().equals("")
                || txt_price.getText().equals("") || txt_stock.getText().equals("")){ 
            JOptionPane.showMessageDialog(this, "Please fill in all the boxes!");
        } else {
            String[] colon = {"code_product", "reference", "designation", "storage", "provider", "discount", "price", "stock"};
            String[] inf = {txt_code.getText(), txt_reference.getText(), txt_designation.getText(), txt_storage.getText(), txt_provider.getText(), 
                            txt_discount.getText(), txt_price.getText(), txt_stock.getText()};
            System.out.println(db.queryInsert("product", colon, inf));
            table();
            refreash();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (txt_code.getText().equals("") || txt_reference.getText().equals("") || txt_designation.getText().equals("") 
                || txt_storage.getText().equals("") || txt_provider.getText().equals("") || txt_discount.getText().equals("")
                || txt_price.getText().equals("") || txt_stock.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter all the information!");
        } else {
            String[] colon = {"code_product", "reference", "designation", "storage", "provider", "discount", "price", "stock"};
            String[] inf = {txt_code.getText(), txt_reference.getText(), txt_designation.getText(), txt_storage.getText(), txt_provider.getText(), 
                            txt_discount.getText(), txt_price.getText(), txt_stock.getText()};
            String id = String.valueOf(table_product.getValueAt(table_product.getSelectedRow(), 0));
            System.out.println(db.queryUpdate("product", colon, inf, "id='" + id + "'"));
            table();
            refreash();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String id = String.valueOf(table_product.getValueAt(table_product.getSelectedRow(), 0));
        if (txt_code.getText().equals("") || txt_reference.getText().equals("") || txt_designation.getText().equals("") 
                || txt_storage.getText().equals("") || txt_provider.getText().equals("") || txt_discount.getText().equals("")
                || txt_price.getText().equals("") || txt_stock.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter all the information!");
        }else if (JOptionPane.showConfirmDialog(this, "Are you sure you want to delete it?", "attention!!!",
            JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION){
            db.queryDelete("product", "id=" + id);
        }else{
            return;
        }
        table();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        refreash();
        table();
    }//GEN-LAST:event_jButton5ActionPerformed

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

    private void txt_providerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_providerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_providerActionPerformed

    private void txt_discountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_discountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_discountActionPerformed

    private void txt_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_priceActionPerformed

    private void txt_storageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_storageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_storageActionPerformed

    private void txt_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_stockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_stockActionPerformed

    private void table_productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_productMouseClicked
        txt_code.setText(String.valueOf(table_product.getValueAt(table_product.getSelectedRow(), 1)));
        txt_reference.setText(String.valueOf(table_product.getValueAt(table_product.getSelectedRow(), 2)));
        txt_designation.setText(String.valueOf(table_product.getValueAt(table_product.getSelectedRow(), 3)));
        txt_storage.setText(String.valueOf(table_product.getValueAt(table_product.getSelectedRow(), 4)));
        txt_provider.setText(String.valueOf(table_product.getValueAt(table_product.getSelectedRow(), 5)));
        txt_discount.setText(String.valueOf(table_product.getValueAt(table_product.getSelectedRow(), 6)));
        txt_price.setText(String.valueOf(table_product.getValueAt(table_product.getSelectedRow(), 7)));
        txt_stock.setText(String.valueOf(table_product.getValueAt(table_product.getSelectedRow(), 8)));
    }//GEN-LAST:event_table_productMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         this.dispose();
         Principle p = new Principle();
         p.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        MessageFormat header = new MessageFormat("List Of Products");
        MessageFormat footer = new MessageFormat("Page {1,number,integer}");

        try{
            table_product.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (java.awt.print.PrinterException e){
            System.err.format("Can not print %s%n", e.getMessage());
        }
    }//GEN-LAST:event_jButton6ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> com_search;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable table_product;
    private javax.swing.JTextField txt_code;
    private javax.swing.JTextField txt_designation;
    private javax.swing.JTextField txt_discount;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_provider;
    private javax.swing.JTextField txt_rech;
    private javax.swing.JTextField txt_reference;
    private javax.swing.JTextField txt_stock;
    private javax.swing.JTextField txt_storage;
    // End of variables declaration//GEN-END:variables
}
