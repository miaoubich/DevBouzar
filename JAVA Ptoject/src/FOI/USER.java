
package FOI;

import Data_Base.DATA_BASE;
import Data_Base.Parameter;
import Data_Base.ResultSetTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.print.*;
import java.text.*;
import javax.swing.JTable;

public class USER extends javax.swing.JFrame {

    ResultSet rs;
    DATA_BASE db;
    
    
    public USER(){
        db = new DATA_BASE(new Parameter().HOST_DB, new Parameter().USERNAME_DB, new Parameter().PASSWORD_DB, 
                new Parameter().IPHOST, new Parameter().PORT);
        initComponents();
        table();
    }
    
    //function table
    public void table() {
        String a[] = {"id", "id_user", "username", "password", "type"};
        rs = db.querySelect(a, "user");
        table_user.setModel(new ResultSetTableModel(rs));
    }
     void refreash() {
        txt_id.setText("");
        txt_us.setText("");
        txt_pa.setText("");
        com_ty.setSelectedItem("Typpppe");
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_user = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_rech = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        txt_us = new javax.swing.JTextField();
        txt_pa = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        com_rech = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        com_ty = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(755, 530));
        setSize(new java.awt.Dimension(755, 530));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        jLabel1.setText(" User Management");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(220, 20, 330, 50);

        table_user.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "ID User", "Username", "Password", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_userMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_user);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 92, 718, 140);

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
        jButton1.setBounds(400, 410, 120, 40);

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
        jButton2.setBounds(180, 250, 110, 40);

        jButton3.setBackground(new java.awt.Color(102, 102, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(290, 250, 110, 40);

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
        jButton4.setBounds(510, 250, 110, 40);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel3.setText("Search by category:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(390, 360, 180, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Username:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 360, 90, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Password:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 400, 90, 30);

        txt_rech.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_rech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rechActionPerformed(evt);
            }
        });
        getContentPane().add(txt_rech);
        txt_rech.setBounds(540, 410, 180, 40);

        txt_id.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        getContentPane().add(txt_id);
        txt_id.setBounds(130, 320, 130, 30);

        txt_us.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_us.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usActionPerformed(evt);
            }
        });
        getContentPane().add(txt_us);
        txt_us.setBounds(130, 360, 130, 30);

        txt_pa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_pa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_paActionPerformed(evt);
            }
        });
        getContentPane().add(txt_pa);
        txt_pa.setBounds(130, 400, 130, 30);

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
        jButton5.setBounds(400, 250, 110, 40);

        com_rech.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id_user", "username", "password", "type" }));
        com_rech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_rechActionPerformed(evt);
            }
        });
        getContentPane().add(com_rech);
        com_rech.setBounds(550, 370, 140, 20);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("User Id:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 320, 70, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel7.setText("type:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 450, 60, 30);

        com_ty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "director", "cashier" }));
        com_ty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_tyActionPerformed(evt);
            }
        });
        getContentPane().add(com_ty);
        com_ty.setBounds(140, 460, 80, 20);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOI/rsz_back3_1.jpg"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(20, 20, 50, 47);

        jButton6.setBackground(new java.awt.Color(102, 102, 255));
        jButton6.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Print");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(400, 450, 120, 40);

        setSize(new java.awt.Dimension(758, 543));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (txt_id.getText().equals("") || txt_us.getText().equals("") || txt_pa.getText().equals("")
                || com_ty.getSelectedItem().equals("Typpppe")) {
            JOptionPane.showMessageDialog(this, "Please enter all the information!");
        } else {
            String[] colon = {"id_user", "username", "password", "type"};
            String[] inf = {txt_id.getText(), txt_us.getText(), txt_pa.getText(), com_ty.getSelectedItem().toString()};
            System.out.println(db.queryInsert("user", colon, inf));
            table();
            refreash();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_rechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rechActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rechActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void txt_usActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usActionPerformed

    private void txt_paActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_paActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_paActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txt_rech.getText().equals("")){
            JOptionPane.showMessageDialog(this, "PLEASE, Enter something!");// if you click on search botton with an empty text field
        } else {
            if (com_rech.getSelectedItem().equals("id_user")) {
                rs = db.querySelectAll("user", "id_user LIKE '%" + txt_rech.getText() + "%' ");
                table_user.setModel(new ResultSetTableModel(rs));
            } else if (com_rech.getSelectedItem().equals("username")) {
                rs = db.querySelectAll("user", "username LIKE '%" + txt_rech.getText() + "%' ");
                table_user.setModel(new ResultSetTableModel(rs));
            } else if (com_rech.getSelectedItem().equals("password")) {
                rs = db.querySelectAll("user", "password LIKE '%" + txt_rech.getText() + "%' ");
                table_user.setModel(new ResultSetTableModel(rs));
            } else if (com_rech.getSelectedItem().equals("type")) {
                rs = db.querySelectAll("user", "type LIKE '%" + txt_rech.getText() + "%' ");
                table_user.setModel(new ResultSetTableModel(rs));
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         if (txt_id.getText().equals("") || txt_us.getText().equals("") || txt_pa.getText().equals("")
                || com_ty.getSelectedItem().equals("Typpppe")){
            JOptionPane.showMessageDialog(this, "Please enter all the information!");
        } else {
            String[] colon = {"id_user", "username", "password", "type"};
            String[] inf = {txt_id.getText(), txt_us.getText(), txt_pa.getText(), com_ty.getSelectedItem().toString()};
            String id = String.valueOf(table_user.getValueAt(table_user.getSelectedRow(), 0));
            System.out.println(db.queryUpdate("user", colon, inf, "id='" + id + "'"));
            table();
            refreash();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String id = String.valueOf(table_user.getValueAt(table_user.getSelectedRow(), 0));
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to delete it?", "attention!!!", 
                JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            db.queryDelete("user", "id=" + id);
        } else {
            return;
        }
        table();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        refreash();
        table();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void com_tyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com_tyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_com_tyActionPerformed

    private void com_rechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com_rechActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_com_rechActionPerformed

    private void table_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_userMouseClicked
        txt_id.setText(String.valueOf(table_user.getValueAt(table_user.getSelectedRow(), 1)));
        txt_us.setText(String.valueOf(table_user.getValueAt(table_user.getSelectedRow(), 2)));
        txt_pa.setText(String.valueOf(table_user.getValueAt(table_user.getSelectedRow(), 3)));
        com_ty.setSelectedItem(String.valueOf(table_user.getValueAt(table_user.getSelectedRow(), 4)));
    }//GEN-LAST:event_table_userMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         this.dispose();
         Principle p = new Principle();
         p.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        MessageFormat header = new MessageFormat("List Of User");
        MessageFormat footer = new MessageFormat("Page {1,number,integer}");

        try{
            table_user.print(JTable.PrintMode.FIT_WIDTH, header, footer);
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
            java.util.logging.Logger.getLogger(USER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(USER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(USER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(USER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new USER().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> com_rech;
    private javax.swing.JComboBox<String> com_ty;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_user;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_pa;
    private javax.swing.JTextField txt_rech;
    private javax.swing.JTextField txt_us;
    // End of variables declaration//GEN-END:variables
}
