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
import java.sql.PreparedStatement;
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
public class frm_pegawai extends javax.swing.JFrame {
    koneksi dbsetting;
    String driver,database,user,pass;
    Object tabel;
    /**
     * Creates new form frm_cari_pegawai
     */
    public frm_pegawai() {
        initComponents();
        //mengatur icon serta panel
        ImageIcon ico = new ImageIcon("src/images/usuarios.png");
        setIconImage(ico.getImage());
        Dimension ss = Toolkit.getDefaultToolkit ().getScreenSize ();
        Dimension frameSize = new Dimension ( 630, 490 );
        this.setBounds ( ss.width / 2 - frameSize.width / 2, 
        ss.height / 2 - frameSize.height / 2,
        frameSize.width, frameSize.height );
        //koneksi database
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        tabel_pegawai.setModel(tableModel);
        //membuat textfield supaya tidak aktif
        txt_nama_pegawai.setEnabled(false);
        txt_jeniskelamin.setEnabled(false);
        txt_alamat_pegawai.setEnabled(false);
        txt_password.setEnabled(false);
        txt_level.setEnabled(false);
        //memanggil tabel
        settableload();
        
    }
int row = 0;  
private javax.swing.table.DefaultTableModel tableModel = getDefaultTabelModel();
private javax.swing.table.DefaultTableModel getDefaultTabelModel()
{
    //membuat judul header
    return new javax.swing.table.DefaultTableModel
            (
                new  Object[][] {},
                new String[]{"Kode Pegawai",
                            "Nama Pegawai",
                            "Jenis Kelamin",
                            "Alamat",
                            "Level"}
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
  
public void tambah_pegawai() throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        Connection kon = DriverManager.getConnection(database,user,pass);      
        String SQL= "SELECT MAX(kode_pegawai) AS kode_pegawai FROM tabel_pegawai";
        try {
            Statement stt = kon.createStatement();
            ResultSet res = stt.executeQuery(SQL);
            if(res.last()){
                txt_kode_pegawai.setText(String.valueOf(res.getInt(1)+1));
            }
            else
                txt_kode_pegawai.setText("01");
        } catch (Exception e) {
        }
    }

//CARI DATA
public void carikodepegawai() {
    try {
        Class.forName(driver);
        Object row[] = {"Kode Pegawai",
                            "Nama Pegawai",
                            "Jenis Kelamin",
                            "Alamat",
                            "Level"};
        tableModel = new DefaultTableModel(null,row);
        tabel_pegawai.setModel(tableModel); 
        Connection kon = DriverManager.getConnection(database,user,pass);
        Statement stt = kon.createStatement();
        String sql = "select * from tabel_pegawai where kode_pegawai" + " like '%" + cari.getText() + "%'";
        ResultSet res = stt.executeQuery(sql);
        while (res.next()) {
            String a = res.getString(1);
            String b = res.getString(2);
            String c = res.getString(3);   
            String d = res.getString(4);
            String e = res.getString(5);
            String[] data = {a,b,c,d,e};
        tableModel.addRow(data);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(frm_barang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_barang.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void carinamapegawai() {
    try {
        Class.forName(driver);
        Object row[] = {"Kode Pegawai",
                            "Nama Pegawai",
                            "Jenis Kelamin",
                            "Alamat",
                            "Level"};
        tableModel = new DefaultTableModel(null,row);
        tabel_pegawai.setModel(tableModel); 
        Connection kon = DriverManager.getConnection(database,user,pass);
        Statement stt = kon.createStatement();
        String sql = "select * from tabel_pegawai where username" + " like '%" + cari.getText() + "%'";
        ResultSet res = stt.executeQuery(sql);
        while (res.next()) {
            String a = res.getString(1);
            String b = res.getString(2);
            String c = res.getString(3);   
            String d = res.getString(4);
            String e = res.getString(5);
            String[] data = {a,b,c,d,e};
        tableModel.addRow(data);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(frm_barang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_barang.class.getName()).log(Level.SEVERE, null, ex);
        }
}


public void carilevelpegawai() {
    try {
        Class.forName(driver);
        Class.forName(driver);
        Object row[] = {"Kode Pegawai",
                            "Nama Pegawai",
                            "Jenis Kelamin",
                            "Alamat",
                            "Level"};
        tableModel = new DefaultTableModel(null,row);
        tabel_pegawai.setModel(tableModel); 
        Connection kon = DriverManager.getConnection(database,user,pass);
        Statement stt = kon.createStatement();
        String sql = "select * from tabel_pegawai where level" + " like '%" + cari.getText() + "%'";
        ResultSet res = stt.executeQuery(sql);
        while (res.next()) {
            String a = res.getString(1);
            String b = res.getString(2);
            String c = res.getString(3);   
            String d = res.getString(4);
            String e = res.getString(5);
            String[] data = {a,b,c,d,e};
        tableModel.addRow(data);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(frm_barang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_barang.class.getName()).log(Level.SEVERE, null, ex);
        }
}

//MENAMPILKAN FIELD 
public void tampil_field()
{
    row = tabel_pegawai.getSelectedRow();
    txt_kode_pegawai.setText(tableModel.getValueAt(row, 0).toString());
    txt_nama_pegawai.setText(tableModel.getValueAt(row, 1).toString());
    txt_jeniskelamin.setSelectedItem(tableModel.getValueAt(row, 2).toString());
    txt_alamat_pegawai.setText(tableModel.getValueAt(row, 3).toString());
    txt_level.setSelectedItem(tableModel.getValueAt(row, 4).toString());
    
    btn_simpan.setEnabled(false);
    btn_ubah.setEnabled(true);
    btn_hapus.setEnabled(true);  
}
public void membersihkan_teks(){
    txt_kode_pegawai.setText("");
    txt_nama_pegawai.setText("");
    txt_jeniskelamin.setSelectedItem("");
    txt_alamat_pegawai.setText("");
    txt_password.setText("");
    txt_nama_pegawai.setEnabled(false);
    txt_jeniskelamin.setEnabled(false);
    txt_alamat_pegawai.setEnabled(false);
    txt_password.setEnabled(false);
    txt_level.setSelectedItem("");
}
public void membersihkan_tabel(){
    while(tableModel.getRowCount()>0){
        for(int i=0;i<tableModel.getRowCount();i++){
            tableModel.removeRow(i);
        }
    }
}
String data[] = new String[8];
private void settableload()
{
    String stat = "";
    try
    {
        Class.forName(driver);
        Connection kon = DriverManager.getConnection(database,user,pass);
        Statement stt = kon.createStatement();
        String SQL ="select * from tabel_pegawai";
        ResultSet res = stt.executeQuery(SQL);
        while (res.next()) 
        {
           data[0] = res.getString(1);
           data[1] = res.getString(2);
           data[2] = res.getString(3);
           data[3] = res.getString(4);
           data[4] = res.getString(5);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_pegawai = new javax.swing.JTable();
        btn_ubah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_keluar = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_kode_pegawai = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_nama_pegawai = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_alamat_pegawai = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        btn_simpan = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        carii = new javax.swing.JComboBox();
        cari = new javax.swing.JTextField();
        go = new javax.swing.JButton();
        txt_level = new javax.swing.JComboBox();
        txt_jeniskelamin = new javax.swing.JComboBox();
        pembuat1 = new Form.pembuat();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Pegawai");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabel_pegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode Pegawai", "Nama Pegawai", "Jenis Kelamin", "Alamat", "Level"
            }
        ));
        tabel_pegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_pegawaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_pegawai);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 309, 630, 105));

        btn_ubah.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_editor_pen_pencil_write-16 - Copy.png"))); // NOI18N
        btn_ubah.setText("Ubah");
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        btn_hapus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bin-16.png"))); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 420, -1, -1));

        btn_keluar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/oneline_home-16 (1).png"))); // NOI18N
        btn_keluar.setText("Keluar");
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 420, -1, -1));

        btn_batal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alert.png"))); // NOI18N
        btn_batal.setText("Batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });
        getContentPane().add(btn_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kode Pegawai");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 3, -1, -1));

        txt_kode_pegawai.setEditable(false);
        getContentPane().add(txt_kode_pegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 0, 101, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama Pegawai");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 34, -1, -1));

        txt_nama_pegawai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nama_pegawaiKeyTyped(evt);
            }
        });
        getContentPane().add(txt_nama_pegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 31, 166, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jenis Kelamin");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Alamat Pegawai");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 85, -1, -1));

        txt_alamat_pegawai.setColumns(20);
        txt_alamat_pegawai.setRows(5);
        txt_alamat_pegawai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_alamat_pegawaiKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txt_alamat_pegawai);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 85, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Level");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 233, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Password");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 192, -1, -1));

        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_passwordKeyTyped(evt);
            }
        });
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 192, 106, -1));

        btn_simpan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/multimedia-27-16.png"))); // NOI18N
        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 278, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_cross_new_plus_create-16.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 0, -1, -1));

        carii.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cari Berdasarkan", "Kode Pegawai", "Nama Pegawai", "Level" }));
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
        getContentPane().add(carii, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 130, -1));

        cari.setEnabled(false);
        getContentPane().add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 280, 120, -1));

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
        getContentPane().add(go, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 278, 80, -1));

        txt_level.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "=Silahkan Pilih Level=", "Admin", "Pegawai" }));
        getContentPane().add(txt_level, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 230, -1, -1));

        txt_jeniskelamin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "= SILAHKAN PILIH =", "Pria", "Wanita" }));
        getContentPane().add(txt_jeniskelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 57, -1, -1));

        javax.swing.GroupLayout pembuat1Layout = new javax.swing.GroupLayout(pembuat1);
        pembuat1.setLayout(pembuat1Layout);
        pembuat1Layout.setHorizontalGroup(
            pembuat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );
        pembuat1Layout.setVerticalGroup(
            pembuat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        getContentPane().add(pembuat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 740, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void simpan_login(){
    String datalogin[]=new String[4];
                String SQL = "INSERT INTO login(username,password,level) VALUES('"+txt_nama_pegawai.getText()+"',md5('"+String.valueOf(txt_password.getPassword())+"'),'"+txt_level.getSelectedItem()+"')"; 
            try {
            Class.forName(driver);    
            Connection kon = DriverManager.getConnection(database,user,pass);                      
            Statement stt = kon.createStatement();                           
            stt.executeUpdate(SQL);
            data[0]=txt_nama_pegawai.getText();
            data[1]=txt_nama_pegawai.getText();
            data[2]=txt_level.getSelectedItem().toString();
        } catch (Exception e) {
        
        }
    }
    public void SimpanPegawai()
    {
         String data[]=new String[8];
        if((txt_kode_pegawai.getText().isEmpty())|| (txt_nama_pegawai.getText().isEmpty()) ||(txt_jeniskelamin.getSelectedItem().equals(null)) ||(txt_alamat_pegawai.getText().isEmpty())||(txt_password.getText().isEmpty()) ||(txt_level.getSelectedItem().equals("")))
        {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong, Silahkan Dilengkapi!");
        txt_kode_pegawai.requestFocus();
        }
        else
        {
            try{
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
                String SQL = "INSERT INTO tabel_pegawai(kode_pegawai,"+"username,"+"jenis_kelamin,"+"alamat,"+"level)"+"VALUES"
                        +"('"+txt_kode_pegawai.getText()+"',"
                        +"'"+txt_nama_pegawai.getText()+"',"
                        +"'"+txt_jeniskelamin.getSelectedItem()+"',"
                        +"'"+txt_alamat_pegawai.getText()+"',"
                        +"'"+txt_level.getSelectedItem()+"')";
                
                stt.executeUpdate(SQL);
                data[0]=txt_kode_pegawai.getText();
                data[1]=txt_nama_pegawai.getText();
                data[2]=txt_jeniskelamin.getSelectedItem().toString();
                data[3]=txt_alamat_pegawai.getText();
                data[4]=txt_level.getSelectedItem().toString();
                simpan_login();
                tableModel.insertRow(0, data);
                stt.close();
                kon.close();
                JOptionPane.showMessageDialog(null, "Berhasil Tersimpan !");
                txt_kode_pegawai.setText("");
                txt_nama_pegawai.setText("");
                txt_jeniskelamin.setSelectedItem("");
                txt_alamat_pegawai.setText("");
                txt_password.setText("");
                btn_simpan.setEnabled(true);
                btn_ubah.setEnabled(true);
                btn_hapus.setEnabled(true);
                btn_keluar.setEnabled(true);
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
       SimpanPegawai();
    }//GEN-LAST:event_btn_simpanActionPerformed
    public void HapusPegawai()
    {
         
        int a;
        a = JOptionPane.showConfirmDialog(null, "ANDA YAKIN AKAN MENGHAPUS DATA ? ", "WARNING!", JOptionPane.YES_NO_OPTION);        
        if(a == JOptionPane.YES_OPTION){
        int row = tabel_pegawai.getSelectedRow();
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            if(row == -1){
                JOptionPane.showMessageDialog(this, "Mohon pilih tabel terlebih dahulu","Pesan",JOptionPane.WARNING_MESSAGE);
            }
            else{
                String sqlhapus = "DELETE FROM tabel_pegawai WHERE kode_pegawai = '"+txt_kode_pegawai.getText()+"'";
                String sqlhapus1 = "DELETE FROM login WHERE username = '"+txt_nama_pegawai.getText()+"'";
                stt.executeUpdate(sqlhapus);
                stt.executeUpdate(sqlhapus1);
                JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
                tableModel.removeRow(row);
                membersihkan_teks();
                jButton1.setEnabled(true);
            }
        } catch (Exception e) {
        }
        }
        
    }
    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
      if(evt.getSource() == btn_hapus){
HapusPegawai();
}
    }//GEN-LAST:event_btn_hapusActionPerformed

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

    private void tabel_pegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_pegawaiMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1)
        {
            tampil_field();
        }
        btn_hapus.setEnabled(true);
        btn_ubah.setEnabled(true); 
        btn_simpan.setEnabled(false);
        txt_level.setEnabled(false);
        txt_nama_pegawai.setEnabled(false);
        txt_jeniskelamin.setEnabled(true);
        txt_alamat_pegawai.setEnabled(true);
        txt_password.setEnabled(true);
        jLabel7.setVisible(false);
        txt_password.setVisible(false);
        
    }//GEN-LAST:event_tabel_pegawaiMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            tambah_pegawai();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_barang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frm_barang.class.getName()).log(Level.SEVERE, null, ex);
        }
        btn_ubah.setEnabled(false);
        btn_hapus.setEnabled(false);   
        btn_simpan.setEnabled(true);
        txt_nama_pegawai.setEnabled(true);
        txt_jeniskelamin.setEnabled(true);
        txt_alamat_pegawai.setEnabled(true);
        txt_password.setEnabled(true);
        txt_password.setVisible(true);
        jLabel7.setVisible(true);
        txt_level.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        membersihkan_tabel();
        settableload();
        membersihkan_teks();
        jLabel7.setVisible(true);
        txt_password.setVisible(true);
    }//GEN-LAST:event_btn_batalActionPerformed
    public void UbahPegawai()
    {
        int row = tabel_pegawai.getSelectedRow();
        try {
            Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
                if(txt_alamat_pegawai.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong, Silahkan Dilengkapi!");
        txt_alamat_pegawai.requestFocus();
        }
            if(row == -1){
                JOptionPane.showMessageDialog(this, "Mohon pilih tabel terlebih dahulu","Pesan",JOptionPane.WARNING_MESSAGE);
            }
            else{
                String sql = "UPDATE tabel_pegawai SET username = '"+txt_nama_pegawai.getText()+"'"
                        + ", jenis_kelamin = '"+txt_jeniskelamin.getSelectedItem()+"', alamat = '"+txt_alamat_pegawai.getText()+"', level = '"+txt_level.getSelectedItem()+"' WHERE kode_pegawai = '"+txt_kode_pegawai.getText()+"'";
                stt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Berhasil Diubah");
                membersihkan_tabel();
                settableload();
                membersihkan_teks();
                jButton1.setEnabled(true);
                txt_jeniskelamin.setEnabled(false);
                txt_alamat_pegawai.setEnabled(false);
            }
        } catch (Exception e) {
        }
    }
    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        // TODO add your handling code here:
        UbahPegawai();
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void cariiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cariiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cariiMouseClicked

    private void cariiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariiActionPerformed
        cari.setEnabled(true);
        go.setEnabled(true);
    }//GEN-LAST:event_cariiActionPerformed

    private void goMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goMouseClicked
        if(carii.getSelectedIndex() == 1){
            carikodepegawai();
        }

        if (carii.getSelectedIndex()== 2) {
            carinamapegawai();
        }
        if (carii.getSelectedIndex()== 3) {
            carilevelpegawai();
        }
    }//GEN-LAST:event_goMouseClicked

    private void goActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_goActionPerformed

    private void txt_nama_pegawaiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nama_pegawaiKeyTyped
        // TODO add your handling code here:
        if ( txt_nama_pegawai.getText().length() == 15 ) {
        evt.consume();
        
    }
    }//GEN-LAST:event_txt_nama_pegawaiKeyTyped

    private void txt_alamat_pegawaiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_alamat_pegawaiKeyTyped
        // TODO add your handling code here:
            if ( txt_alamat_pegawai.getText().length() == 30 ) {
        evt.consume();
        
    }
    }//GEN-LAST:event_txt_alamat_pegawaiKeyTyped

    private void txt_passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyTyped
        // TODO add your handling code here:
        if ( txt_password.getText().length() == 10 ) {
        evt.consume();
        
    }
    }//GEN-LAST:event_txt_passwordKeyTyped

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
            java.util.logging.Logger.getLogger(frm_pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_pegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_ubah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cari;
    private javax.swing.JComboBox carii;
    private javax.swing.JButton go;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private Form.pembuat pembuat1;
    private javax.swing.JTable tabel_pegawai;
    private javax.swing.JTextArea txt_alamat_pegawai;
    private javax.swing.JComboBox txt_jeniskelamin;
    private javax.swing.JTextField txt_kode_pegawai;
    private javax.swing.JComboBox txt_level;
    private javax.swing.JTextField txt_nama_pegawai;
    private javax.swing.JPasswordField txt_password;
    // End of variables declaration//GEN-END:variables
}
