/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YEAC
 */
public class frm_detail_transaksi_tunai extends javax.swing.JFrame {
    koneksi dbsetting;
    String driver,database,user,pass,tgl;
    Object tabel;
    /**
     * Creates new form frm_detail_transaksi_tunai
     */
    public frm_detail_transaksi_tunai() {
        initComponents();
        ImageIcon ico = new ImageIcon("src/images/usuarios.png");
        setIconImage(ico.getImage());
        Dimension ss = Toolkit.getDefaultToolkit ().getScreenSize ();
        Dimension frameSize = new Dimension ( 730, 255 );
        this.setBounds ( ss.width / 2 - frameSize.width / 2, 
        ss.height / 2 - frameSize.height / 2,
        frameSize.width, frameSize.height );
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        tabel_detail_transaksi_tunai.setModel(tableModel);
        settableload();
    }
private javax.swing.table.DefaultTableModel tableModel = getDefaultTabelModel();
private javax.swing.table.DefaultTableModel getDefaultTabelModel()
{
    //membuat judul header
    return new javax.swing.table.DefaultTableModel
            (
                new  Object[][] {},
                new String[]{"Kode Pembeli",
                            "Tanggal Pembelian",
                            "Nama Pembeli",
                            "Alamat Pembeli",
                            "Nama Barang",
                            "Harga Satuan",
                            "Jumlah Beli "}
            )
    //disable perubahan pada grid
    {
        boolean[] canEdit = new boolean[]
        {
            false, false, false, false, false
        };
        
        public boolean isCellEdittable(int  rowIndex, int columnIndex)
        {
            return canEdit[columnIndex];
        }
    };
}
String data[] = new String[15];
private void settableload()
{
    String stat = "";
    try
    {
        Class.forName(driver);
        Connection kon = DriverManager.getConnection(database,user,pass);
        Statement stt = kon.createStatement();
        String SQL ="SELECT * FROM tabel_detail_transaksi_tunai GROUP BY kode_pembeli_tunai";
        ResultSet res = stt.executeQuery(SQL);
        while (res.next()) 
        {
           data[0] = res.getString(2);
           data[1] = res.getString(3);
           data[2] = res.getString(4);
           data[3] = res.getString(5);
           data[4] = res.getString(7);
           data[5] = res.getString(9);
           data[6] = res.getString(8);
           tableModel.addRow(data);
        }
        res.close();
        stt.close();
        kon.close();
    }
    catch(Exception ex)
    {
        System.err.println(ex.getMessage());
        JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_detail_transaksi_tunai = new javax.swing.JTable();
        btn_keluar = new javax.swing.JButton();
        carii = new javax.swing.JComboBox();
        cari = new javax.swing.JTextField();
        go = new javax.swing.JButton();
        pembuat1 = new Form.pembuat();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detail Transaksi Tunai");
        setAutoRequestFocus(false);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setFocusable(false);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabel_detail_transaksi_tunai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode Pegawai", "Tanggal Pembeli", "Nama Pembeli", "Alamat Pembeli", "Harga Total"
            }
        ));
        jScrollPane1.setViewportView(tabel_detail_transaksi_tunai);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 728, 131));

        btn_keluar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/oneline_home-16 (1).png"))); // NOI18N
        btn_keluar.setText("Keluar");
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 182, -1, -1));

        carii.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cari Berdasarkan", "Kode Pembeli", "Nama Pembeli", "Tanggal Pembelian" }));
        carii.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cariiMouseClicked(evt);
            }
        });
        carii.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariiActionPerformed(evt);
            }
        });
        getContentPane().add(carii, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 13, 130, -1));

        cari.setEnabled(false);
        getContentPane().add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 13, 120, -1));

        go.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search-ico.png"))); // NOI18N
        go.setText("Cari");
        go.setEnabled(false);
        go.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goMouseClicked(evt);
            }
        });
        go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goActionPerformed(evt);
            }
        });
        getContentPane().add(go, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 11, -1, -1));

        javax.swing.GroupLayout pembuat1Layout = new javax.swing.GroupLayout(pembuat1);
        pembuat1.setLayout(pembuat1Layout);
        pembuat1Layout.setHorizontalGroup(
            pembuat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );
        pembuat1Layout.setVerticalGroup(
            pembuat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );

        getContentPane().add(pembuat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        // TODO add your handling code here:
        if(evt.getSource() == btn_keluar){
            int a;
            a = JOptionPane.showConfirmDialog(null, "ANDA YAKIN AKAN KELUAR?", "WARNING!", JOptionPane.YES_NO_OPTION);
            
            if(a == JOptionPane.YES_OPTION){
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void cariiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cariiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cariiMouseClicked

    private void cariiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariiActionPerformed
        cari.setEnabled(true);
        go.setEnabled(true);
    }//GEN-LAST:event_cariiActionPerformed
public void carikodepembeli() {
    try {
        Class.forName(driver);
        Object row[] = {"Kode Pembeli",
                            "Tanggal Pembelian",
                            "Nama Pembeli",
                            "Alamat Pembeli",
                            "Nama Barang",
                            "Harga Satuan",
                            "Jumlah Beli "};
        tableModel = new DefaultTableModel(null,row);
        tabel_detail_transaksi_tunai.setModel(tableModel); 
        Connection kon = DriverManager.getConnection(database,user,pass);
        Statement stt = kon.createStatement();
        String sql = "select * from tabel_detail_transaksi_tunai where kode_pembeli_tunai" + " like '%" + cari.getText() + "%' GROUP BY kode_pembeli_tunai";
        ResultSet res = stt.executeQuery(sql);
        while (res.next()) {
            String a = res.getString(2);
            String b = res.getString(3);
            String c = res.getString(4);   
            String d = res.getString(5);
            String e = res.getString(7);
            String f = res.getString(9);
            String g = res.getString(8);
            String[] data = {a,b,c,d,e,f,g};
        tableModel.addRow(data);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(frm_barang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_barang.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void carinamapembeli() {
    try {
        Class.forName(driver);
        Object row[] = {"Kode Pembeli",
                            "Tanggal Pembelian",
                            "Nama Pembeli",
                            "Alamat Pembeli",
                            "Nama Barang",
                            "Harga Satuan",
                            "Jumlah Beli "};
        tableModel = new DefaultTableModel(null,row);
        tabel_detail_transaksi_tunai.setModel(tableModel); 
        Connection kon = DriverManager.getConnection(database,user,pass);
        Statement stt = kon.createStatement();
        String sql = "select * from tabel_detail_transaksi_tunai where nama_pembeli" + " like '%" + cari.getText() + "%' GROUP BY kode_pembeli_tunai";
        ResultSet res = stt.executeQuery(sql);
        while (res.next()) {
            String a = res.getString(2);
            String b = res.getString(3);
            String c = res.getString(4);   
            String d = res.getString(5);
            String e = res.getString(7);
            String f = res.getString(9);
            String g = res.getString(8);
            String[] data = {a,b,c,d,e,f,g};
        tableModel.addRow(data);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(frm_barang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_barang.class.getName()).log(Level.SEVERE, null, ex);
        }
}


public void caritanggalpembeli() {
    try {
        Class.forName(driver);
        Object row[] = {"Kode Pembeli",
                            "Tanggal Pembelian",
                            "Nama Pembeli",
                            "Alamat Pembeli",
                            "Nama Barang",
                            "Harga Satuan",
                            "Jumlah Beli "};
        tableModel = new DefaultTableModel(null,row);
        tabel_detail_transaksi_tunai.setModel(tableModel); 
        Connection kon = DriverManager.getConnection(database,user,pass);
        Statement stt = kon.createStatement();
        String sql = "select * from tabel_detail_transaksi_tunai where tanggal_pembeli" + " like '%" + cari.getText() + "%' GROUP BY kode_pembeli_tunai";
        ResultSet res = stt.executeQuery(sql);
        while (res.next()) {
            String a = res.getString(2);
            String b = res.getString(3);
            String c = res.getString(4);   
            String d = res.getString(5);
            String e = res.getString(7);
            String f = res.getString(9);
            String g = res.getString(8);
            String[] data = {a,b,c,d,e,f,g};
        tableModel.addRow(data);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(frm_barang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_barang.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    private void goMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goMouseClicked
        if(carii.getSelectedIndex() == 1){
            carikodepembeli();
        }

        if (carii.getSelectedIndex()== 2) {
            carinamapembeli();
        }
        if (carii.getSelectedIndex()== 3) {
            caritanggalpembeli();
        }
    }//GEN-LAST:event_goMouseClicked

    private void goActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_goActionPerformed

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
            java.util.logging.Logger.getLogger(frm_detail_transaksi_tunai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_detail_transaksi_tunai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_detail_transaksi_tunai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_detail_transaksi_tunai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_detail_transaksi_tunai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_keluar;
    private javax.swing.JTextField cari;
    private javax.swing.JComboBox carii;
    private javax.swing.JButton go;
    private javax.swing.JScrollPane jScrollPane1;
    private Form.pembuat pembuat1;
    private javax.swing.JTable tabel_detail_transaksi_tunai;
    // End of variables declaration//GEN-END:variables
}
