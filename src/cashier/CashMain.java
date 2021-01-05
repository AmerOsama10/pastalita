package cashier;

import admin.EnterSystem;
import orders.recipes;
import client.ClientsDetails;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import orders.backtoorder;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amer Osama
 */
public class CashMain extends javax.swing.JFrame {

    /**
     * Creates new form CashMain
     */
    public CashMain() {
        initComponents();
               this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        deliverorder = new javax.swing.JButton();
        clientdatabtn = new javax.swing.JButton();
        backtorderbtn = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quick Bill");
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deliverorder.setBackground(new java.awt.Color(255, 153, 0));
        deliverorder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deliverorder.setForeground(new java.awt.Color(255, 255, 255));
        deliverorder.setText("قائمه الطعام");
        deliverorder.setBorder(null);
        deliverorder.setContentAreaFilled(true);
        deliverorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliverorderActionPerformed(evt);
            }
        });
        jPanel1.add(deliverorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 140, 40));

        clientdatabtn.setBackground(new java.awt.Color(153, 0, 0));
        clientdatabtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clientdatabtn.setForeground(new java.awt.Color(255, 255, 255));
        clientdatabtn.setText("بيانات العملاء");
        clientdatabtn.setBorder(null);
        clientdatabtn.setContentAreaFilled(true);
        clientdatabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientdatabtnActionPerformed(evt);
            }
        });
        jPanel1.add(clientdatabtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 130, 40));

        backtorderbtn.setBackground(new java.awt.Color(153, 0, 0));
        backtorderbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backtorderbtn.setForeground(new java.awt.Color(255, 255, 255));
        backtorderbtn.setText("الرجوع للاوردر");
        backtorderbtn.setBorder(null);
        backtorderbtn.setContentAreaFilled(true);
        backtorderbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backtorderbtnActionPerformed(evt);
            }
        });
        jPanel1.add(backtorderbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 130, 40));

        exit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        exit.setForeground(new java.awt.Color(0, 0, 102));
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        exit.setBorder(null);
        exit.setContentAreaFilled(false);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 40, 30));

        jLabel1.setBackground(new java.awt.Color(153, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menu2.jpg"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clientdatabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientdatabtnActionPerformed
     this.setVisible(false);
     ClientsDetails client=new ClientsDetails(); 
     client.setVisible(true);
    }//GEN-LAST:event_clientdatabtnActionPerformed
       public void exitdata()
    {
        Connection con;
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projecth", "root", "");
             Statement s;    
             Cash cashier=new Cash();
             cashier.clockOut();
             String query="UPDATE `cashiers` SET `cashier_state`='"+cashier.getWorkState()+"'WHERE `cashier_state`=1;";
             s = con.createStatement();
             s.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CashMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
     // TODO add your handling code here:
    
       this.dispose();
       EnterSystem e=new EnterSystem();
       e.setVisible(true);
       exitdata();
    }//GEN-LAST:event_exitActionPerformed

    private void deliverorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliverorderActionPerformed
   this.setVisible(false);
        recipes recipe=new recipes();
    recipe.setVisible(true);
        
        
    }//GEN-LAST:event_deliverorderActionPerformed
    public Connection getConnection()
    {
        Connection con;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
            return con;
        } catch(Exception e)
        {
           return null;
        }
    }
    
    void deletedata(){
         Connection connection= getConnection();
        String query1="DELETE FROM `dates`;";
        String query2="DELETE FROM `orders`;";
        Statement st;
        ResultSet rs;
        try{
            st=connection.createStatement();
            st.executeUpdate(query1);
            st.executeUpdate(query2);
            JOptionPane.showMessageDialog(null, "تم حذف جميع الاوردرات بتجاح");     
        }
            catch(Exception e)
        {
               JOptionPane.showMessageDialog(null, "لم يتم الحذف بنحاح");
        }
        
    }
    
    private void backtorderbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backtorderbtnActionPerformed
     this.setVisible(false);
     backtoorder back=new backtoorder(); 
     back.setVisible(true);
     
     
    }//GEN-LAST:event_backtorderbtnActionPerformed

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
            java.util.logging.Logger.getLogger(CashMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CashMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CashMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CashMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CashMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backtorderbtn;
    private javax.swing.JButton clientdatabtn;
    private javax.swing.JButton deliverorder;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}