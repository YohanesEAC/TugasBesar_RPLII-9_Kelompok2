/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.sf.jasperreports.engine.JasperFillManager;

import net.sf.jasperreports.engine.JasperPrint;

import net.sf.jasperreports.engine.JasperReport;

import net.sf.jasperreports.engine.util.JRLoader;

import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author YEAC
 */
public class frm_awal extends javax.swing.JFrame {
    String hakakses;
    koneksi dbsetting;
    String driver,database,user,pass,tgl;
    Object tabel;
    /**
     * Creates new form frm_barang
     */
    public JTextField level(){
        return txt_level; 
    }
    public void cekuser(){
            if(txt_level.getText().equals("Admin")){             
            jMenu5.setEnabled(true);
            }
            if(txt_level.getText().equals("Pegawai")){             
            jMenu5.setEnabled(false);
            }
    }
    public frm_awal() {
        initComponents();
        cekuser();
        ImageIcon ico = new ImageIcon("src/images/usuarios.png");
        setIconImage(ico.getImage());
        //untuk rata tengah
        Dimension ss = Toolkit.getDefaultToolkit ().getScreenSize ();
        Dimension frameSize = new Dimension (1150, 680 );
        this.setBounds ( ss.width / 2 - frameSize.width / 2, 
        ss.height / 2 - frameSize.height / 2,
        frameSize.width, frameSize.height );
        cekuser();        
    }

    frm_awal(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        txt_level = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PROGRAM MEBEL - 10114255_10114277_10114282");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setFocusable(false);
        setFont(new java.awt.Font("Segoe UI Light", 0, 10)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.jpg"))); // NOI18N

        txt_level.setEditable(false);
        txt_level.setEnabled(false);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1469614988_download.png"))); // NOI18N
        jMenu1.setText("Barang");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1469614853_shopping-cart.png"))); // NOI18N
        jMenu2.setText("Transaksi");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1469615297_money_bag.png"))); // NOI18N
        jMenuItem4.setText("Transaksi Tunai");
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem4MouseClicked(evt);
            }
        });
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1469615293_aiga_cashier.png"))); // NOI18N
        jMenuItem9.setText("Transaksi Cicil");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuBar1.add(jMenu2);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pegawai_1.png"))); // NOI18N
        jMenu5.setText("Pegawai");
        jMenu5.setEnabled(false);
        jMenu5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jMenu5FocusGained(evt);
            }
        });
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1469614407_user.png"))); // NOI18N
        jMenuItem5.setText("Data Pegawai");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1469615950_SEO_planchette_questionnaire.png"))); // NOI18N
        jMenu6.setText("Data Transaksi");
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1469615297_money_bag.png"))); // NOI18N
        jMenuItem3.setText("Data Transaksi Tunai");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem3);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1469615293_aiga_cashier.png"))); // NOI18N
        jMenuItem8.setText("Data Transaksi Cicil");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);

        jMenuBar1.add(jMenu6);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info-16.png"))); // NOI18N
        jMenu7.setText("About");
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu7);

        jMenu14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        jMenu14.setText("Logout");
        jMenu14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu14MouseClicked(evt);
            }
        });
        jMenu14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu14ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu14);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     public void runReportDefault(String sourcefilename, HashMap hash) {
        
try {
             Class.forName(driver);
             Connection kon = DriverManager.getConnection(database,user,pass); 
            InputStream report;
            report = getClass().getResourceAsStream(sourcefilename);
            JasperPrint jprint = JasperFillManager.fillReport(report,hash, kon);
            JasperViewer viewer = new JasperViewer(jprint, false);
            viewer.setFitPageZoomRatio();
            viewer.setVisible(true);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    private void jMenu14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu14MouseClicked
        // TODO add your handling code here:
        if(evt.getSource() == jMenu14){
            int a;
            a = JOptionPane.showConfirmDialog(null, "ANDA YAKIN AKAN LOGOUT ? ", "WARNING!", JOptionPane.YES_NO_OPTION);
            
            if(a == JOptionPane.YES_OPTION){
        Login kembali = new Login();
        kembali.setVisible(true);
        this.setVisible(false);
            }
        }
    }//GEN-LAST:event_jMenu14MouseClicked

    private void jMenu14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu14ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu14ActionPerformed

    private void jMenuItem4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuItem4MouseClicked

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        frm_transaksi_tunai tunai = new frm_transaksi_tunai();
        tunai.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        frm_transaksi_cicil cicil = new frm_transaksi_cicil();
        cicil.setVisible(true);

    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        frm_detail_transaksi_cicil cicildetail = new frm_detail_transaksi_cicil();
        cicildetail.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        frm_detail_transaksi_tunai tunaidetail = new frm_detail_transaksi_tunai();
        tunaidetail.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
        // TODO add your handling code here:
        cekuser();
    }//GEN-LAST:event_jMenu5ActionPerformed

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
         cekuser();

       
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jMenu5FocusGained
        // TODO add your handling code here:
        cekuser();
    }//GEN-LAST:event_jMenu5FocusGained

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

        // TODO add your handling code here:
        frm_barang barang = new frm_barang();
        barang.setVisible(true);
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        frm_barang barang = new frm_barang();
        barang.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        // TODO add your handling code here:
        Frm_pembuat aboutt = new Frm_pembuat();
        aboutt.setVisible(true);
    }//GEN-LAST:event_jMenu6MouseClicked

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        // TODO add your handling code here:
        Frm_pembuat aboutt = new Frm_pembuat();
        aboutt.setVisible(true);
    }//GEN-LAST:event_jMenu7MouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
          frm_pegawai pegawai = new frm_pegawai();
        pegawai.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
            java.util.logging.Logger.getLogger(frm_awal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_awal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_awal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_awal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_awal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JTextField txt_level;
    // End of variables declaration//GEN-END:variables

  }

