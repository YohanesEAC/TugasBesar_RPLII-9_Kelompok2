/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author YEAC
 */
public class frm_transaksi_tunai extends javax.swing.JFrame {
    koneksi dbsetting;
    String driver,database,user,pass,tgl;
    Object tabel;
    /**
     * Creates new form frm_transaksi_tunai
     */
    public frm_transaksi_tunai() {
        initComponents();
        id_detail.setVisible(false);
        ImageIcon ico = new ImageIcon("src/images/usuarios.png");
        setIconImage(ico.getImage());
        tglskrg();
        Dimension ss = Toolkit.getDefaultToolkit ().getScreenSize ();
        Dimension frameSize = new Dimension ( 800, 460 );
        this.setBounds ( ss.width / 2 - frameSize.width / 2, 
        ss.height / 2 - frameSize.height / 2,
        frameSize.width, frameSize.height );
        //koneksi database
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        tabel_transaksi_tunai.setModel(tableModel);
        settableload();
        kode_ambil_barang();
    }
    public void membersihkan_tabel(){
    while(tableModel.getRowCount()>0){
        for(int i=0;i<tableModel.getRowCount();i++){
            tableModel.removeRow(i);
        }
    }
}
int row = 0;  
private javax.swing.table.DefaultTableModel tableModel = getDefaultTabelModel();
private javax.swing.table.DefaultTableModel getDefaultTabelModel()
{
    //membuat judul header
    return new javax.swing.table.DefaultTableModel
            (
                new  Object[][] {},
                new String[]{"Id Detail",
                            "Kode Pembeli",
                            "Tanggal Pembelian",
                            "Nama Pembeli",
                            "Alamat Pembeli",}
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
String data[] = new String[10];
private void settableload()
{
    String stat = "";
    try
    {
        Class.forName(driver);
        Connection kon = DriverManager.getConnection(database,user,pass);
        Statement stt = kon.createStatement();
        String SQL ="SELECT * FROM tabel_detail_transaksi_tunai WHERE kode_pembeli_tunai = '"+txt_kode_pembeli.getText()+"'";
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
 public void kode_ambil_barang(){
        String sql = "SELECT * FROM tabel_barang";
        try {
         Class.forName(driver);
         Connection kon = DriverManager.getConnection(database,user,pass);                      
         Statement stt = kon.createStatement();  
         ResultSet res = stt.executeQuery(sql);
         while(res.next()){
             cbx_kode.addItem(res.getString("kode_barang"));
         }
        } catch (Exception e) {
        }
    }
    public void tglskrg(){
        Date skrg= new Date();
        SimpleDateFormat format= new SimpleDateFormat("dd MMMM yyyy");
        SimpleDateFormat format2= new SimpleDateFormat("yyyy-MM-dd");
        String tgl = format2.format(skrg);
        txt_tanggal_pembeli.setText(format.format(skrg));
    }
    public void tambah_transaksi_tunai() throws ClassNotFoundException, SQLException{
         try{            
           Class.forName(driver);
           Connection kon = DriverManager.getConnection(database,user,pass);
           Statement stt = kon.createStatement();
           
           String sql= "SELECT MAX(right(kode_pembeli_tunai,5)) AS kode_pembeli_tunai FROM tabel_transaksi_tunai";
           ResultSet res = stt.executeQuery(sql);
    
        while(res.next())
            {
                if(res.first() == false)
                {
        txt_kode_pembeli.setText("FKT-000001");
       
}
                else
        {
                   res.last();
                   int auto_id = res.getInt(1) + 1;
                   String no = String.valueOf(auto_id);
                   int noLong = no.length();
                   //MENGATUR jumlah 0
                    for(int a=0;a<6-noLong;a++)
                    { 
                        no = "0" + no;
                    }
                   txt_kode_pembeli.setText("FKT-" + no);
                
                 }        
            }
}    
catch (Exception e){
            JOptionPane.showMessageDialog(this, "ERROR: \n" + e.toString(),
                            "Kesalahan", JOptionPane.WARNING_MESSAGE);

        }
}
    public void membersihkan_teks(){
    cbx_kode.setSelectedItem("");
    txt_nama_barang.setText("-");
    txt_banyak_barang.setText("0");
    txt_harga_satuan.setText("0");
    txt_harga_total.setText("0");
}
    public void tambah_detail_transaksi_tunai() throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        Connection kon = DriverManager.getConnection(database,user,pass);      
        String SQL ="select id_detail_transaksi_tunai from tabel_detail_transaksi_tunai";
        try {
            Statement stt = kon.createStatement();
            ResultSet res = stt.executeQuery(SQL);
            if(res.last()){
                id_detail.setText(String.valueOf(res.getInt(1)+1));
            }
            else
                id_detail.setText("1");
        } catch (Exception e) {
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

        txt_kode_pembeli = new javax.swing.JTextField();
        txt_tanggal_pembeli = new javax.swing.JTextField();
        txt_nama_pembeli = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_alamat_pembeli = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_banyak_barang = new javax.swing.JTextField();
        txt_nama_barang = new javax.swing.JTextField();
        txt_harga_satuan = new javax.swing.JTextField();
        btn_simpan = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        txt_harga_total = new javax.swing.JTextField();
        btn_keluar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_cetak = new javax.swing.JButton();
        txt_total_biaya = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_transaksi_tunai = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        id_detail = new javax.swing.JTextField();
        txt_stock = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cbx_kode = new javax.swing.JComboBox();
        pembuat1 = new Form.pembuat();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Transaksi Tunai");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_kode_pembeli.setEditable(false);
        getContentPane().add(txt_kode_pembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 13, 90, -1));

        txt_tanggal_pembeli.setEditable(false);
        getContentPane().add(txt_tanggal_pembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 46, 166, -1));

        txt_nama_pembeli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nama_pembeliKeyTyped(evt);
            }
        });
        getContentPane().add(txt_nama_pembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 77, 166, -1));

        txt_alamat_pembeli.setColumns(20);
        txt_alamat_pembeli.setRows(5);
        txt_alamat_pembeli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_alamat_pembeliKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txt_alamat_pembeli);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 115, -1, 77));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tanggal Pembeli");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 49, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama Pembeli");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Harga Total");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 158, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Alamat Pembeli");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 115, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Banyak Barang");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 76, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nama Barang");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 104, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Harga Satuan");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 132, -1, -1));

        txt_banyak_barang.setText("0");
        txt_banyak_barang.setToolTipText("Isi Menggunakan Angka !");
        txt_banyak_barang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_banyak_barangKeyTyped(evt);
            }
        });
        getContentPane().add(txt_banyak_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 73, 50, -1));

        txt_nama_barang.setEditable(false);
        txt_nama_barang.setText("0");
        getContentPane().add(txt_nama_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 103, 154, -1));

        txt_harga_satuan.setEditable(false);
        txt_harga_satuan.setText("0");
        txt_harga_satuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_harga_satuanActionPerformed(evt);
            }
        });
        getContentPane().add(txt_harga_satuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 129, 154, -1));

        btn_simpan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/multimedia-27-16.png"))); // NOI18N
        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 236, 100, -1));

        btn_batal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alert.png"))); // NOI18N
        btn_batal.setText("Batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });
        getContentPane().add(btn_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 236, -1, -1));

        txt_harga_total.setEditable(false);
        txt_harga_total.setText("0");
        txt_harga_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_harga_totalActionPerformed(evt);
            }
        });
        getContentPane().add(txt_harga_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 155, 154, -1));

        btn_keluar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/oneline_home-16 (1).png"))); // NOI18N
        btn_keluar.setText("Keluar");
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 236, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Kode Barang");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 14, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kode Pembeli");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 16, -1, -1));

        btn_cetak.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1469624709_22.png"))); // NOI18N
        btn_cetak.setText("Cetak");
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(668, 396, 105, -1));

        txt_total_biaya.setEditable(false);
        getContentPane().add(txt_total_biaya, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 396, 152, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Total Biaya");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 399, -1, -1));

        tabel_transaksi_tunai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Pembeli", "Nama Pembeli", "Tanggal Pembelian", "Kode Barang", "Nama Barang", "Banyak Barang", "Harga Total"
            }
        ));
        jScrollPane2.setViewportView(tabel_transaksi_tunai);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 272, 780, 118));

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_cross_new_plus_create-16.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 13, -1, -1));

        id_detail.setEditable(false);
        id_detail.setEnabled(false);
        id_detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_detailActionPerformed(evt);
            }
        });
        getContentPane().add(id_detail, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 398, -1, -1));

        txt_stock.setEditable(false);
        txt_stock.setText("0");
        getContentPane().add(txt_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 42, 143, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Stock");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 45, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reload-16.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(656, 155, 65, 20));

        cbx_kode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SILAHKAN PILIH" }));
        cbx_kode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbx_kodeItemStateChanged(evt);
            }
        });
        cbx_kode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbx_kodeMouseClicked(evt);
            }
        });
        getContentPane().add(cbx_kode, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 11, -1, -1));

        pembuat1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pembuat1Layout = new javax.swing.GroupLayout(pembuat1);
        pembuat1.setLayout(pembuat1Layout);
        pembuat1Layout.setHorizontalGroup(
            pembuat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        pembuat1Layout.setVerticalGroup(
            pembuat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        getContentPane().add(pembuat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_harga_satuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_harga_satuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_harga_satuanActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            // TODO add your handling code here:
            
            tambah_transaksi_tunai();
            tambah_detail_transaksi_tunai();
            membersihkan_tabel();
            txt_nama_pembeli.setEnabled(true);
            txt_alamat_pembeli.setEnabled(true);
            txt_nama_pembeli.setText("");
            txt_alamat_pembeli.setText("");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_transaksi_tunai.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frm_transaksi_tunai.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton5ActionPerformed
 public void simpan_transaksi(){
          String data[]=new String[5];
                       String SQL = "INSERT INTO tabel_transaksi_tunai(kode_pembeli_tunai,"+"tanggal_pembeli,"+"nama_pembeli,"+"alamat)"+"VALUES"
                        +"('"+txt_kode_pembeli.getText()+"',"
                        +"'"+txt_tanggal_pembeli.getText()+"',"
                        +"'"+txt_nama_pembeli.getText()+"',"
                        +"'"+txt_alamat_pembeli.getText()+"')";
                       
            try {
            Class.forName(driver);    
            Connection kon = DriverManager.getConnection(database,user,pass);                      
            Statement stt = kon.createStatement();                           
            stt.executeUpdate(SQL);
            data[0]=txt_kode_pembeli.getText();
            data[1]=txt_tanggal_pembeli.getText();
            data[2]=txt_nama_pembeli.getText();
            data[3]=txt_alamat_pembeli.getText();
        } catch (Exception e) {
        }
    } 
    
    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        String input = txt_banyak_barang.getText();
        if (input.matches("[0-9]*")) {
            System.out.println("OK");
            } else {
                    JOptionPane.showMessageDialog(null, "Banyak Barang Hanya Diisi Oleh Angka [0-9]!");
                    }
        //untuk mengurangi jumlah barang dibeli, dan stock barang yang tersedia
        Integer jumlahqty = Integer.parseInt(txt_stock.getText()) - Integer.parseInt(txt_banyak_barang.getText());
        txt_stock.setText(Integer.toString(jumlahqty));
        int total = Integer.parseInt(txt_harga_satuan.getText()) * Integer.parseInt(txt_banyak_barang.getText());
        
            int simpan2 = 0;
            if(txt_total_biaya.getText().equals("")){
                simpan2 = 0;
            }
            else
                simpan2 = Integer.valueOf(txt_total_biaya.getText());
          String data[]=new String[13];
        if((txt_kode_pembeli.getText().isEmpty()) ||(txt_nama_barang.getText().isEmpty()) ||(txt_alamat_pembeli.getText().isEmpty()) ||(txt_stock.getText().isEmpty()) ||(txt_banyak_barang.getText().isEmpty())){
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong, Silahkan Dilengkapi!");
        }
        else{     
                     String SQL1 = "INSERT INTO tabel_detail_transaksi_tunai(id_detail_transaksi_tunai,"+"kode_pembeli_tunai,"+"tanggal_pembeli,"+"nama_pembeli,"+"alamat_pembeli,"+"kode_barang,"+"nama_barang,"+"banyak_barang,"+"harga_satuan,"+"harga_total)"+"VALUES"
                     +"('"+id_detail.getText()+"',"
                        +"'"+txt_kode_pembeli.getText()+"',"
                        +"'"+txt_tanggal_pembeli.getText()+"',"
                        +"'"+txt_nama_pembeli.getText()+"',"
                        +"'"+txt_alamat_pembeli.getText()+"',"
                        +"'"+cbx_kode.getSelectedItem()+"',"
                        +"'"+txt_nama_barang.getText()+"',"
                        +"'"+txt_banyak_barang.getText()+"',"
                        +"'"+txt_harga_satuan.getText()+"',"
                        +"'"+txt_harga_total.getText()+"')";
                     try {
                         txt_total_biaya.setText(String.valueOf(simpan2+total));
                         cek_harga();
                         simpan_transaksi();   
                         Class.forName(driver);
                     Connection kon = DriverManager.getConnection(database,user,pass);                      
                     Statement stt = kon.createStatement();  
                     stt.executeUpdate(SQL1);
                 stt.executeUpdate("update tabel_barang set kode_barang='"+cbx_kode.getSelectedItem()+"',"+
                 "jumlah='"+txt_stock.getText()+"'where kode_barang ='"+cbx_kode.getSelectedItem()+"'");
                 
                data[0]=id_detail.getText();
                data[1]=txt_kode_pembeli.getText();
                data[2]=txt_tanggal_pembeli.getText();
                data[3]=txt_nama_pembeli.getText();
                data[4]=txt_alamat_pembeli.getText();
                data[5]=tgl;
                data[6]=cbx_kode.getSelectedItem().toString();
                data[7]=txt_nama_barang.getText();
                data[8]=txt_banyak_barang.getText();
                data[9]=txt_harga_satuan.getText();
                data[10]=txt_harga_total.getText();
                tambah_detail_transaksi_tunai();
                tableModel.insertRow(0, data);
                txt_nama_pembeli.setEnabled(false);
                txt_alamat_pembeli.setEnabled(false);
                btn_simpan.setEnabled(true);
                btn_keluar.setEnabled(true);
                //untuk update jumlah barang ke tabel barang
                 
              membersihkan_teks();
                JOptionPane.showMessageDialog(this, "Transaksi Berhasil!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void id_detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_detailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_detailActionPerformed
public void cek_harga(){
    int harga = Integer.parseInt(txt_harga_satuan.getText()) * Integer.parseInt(txt_banyak_barang.getText());
    int harga2 = 0;
            if(txt_harga_total.getText().equals("")){
                harga2 = 0;
            }
            else
                harga2  = Integer.valueOf(txt_harga_total.getText());
                txt_harga_total.setText(String.valueOf(harga));
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cek_harga();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_harga_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_harga_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_harga_totalActionPerformed

    private void cbx_kodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbx_kodeMouseClicked
        // TODO add your handling code here:
         String sql = "SELECT * FROM tabel_barang WHERE kode_barang = '"+cbx_kode.getSelectedItem().toString()+"'";
        try {
              Class.forName(driver);
              Connection kon = DriverManager.getConnection(database,user,pass);                      
              Statement stt = kon.createStatement();  
              ResultSet res = stt.executeQuery(sql);
            if(res.next()){
                txt_nama_barang.setText(res.getString("nama_barang"));
                txt_harga_satuan.setText(res.getString("harga_satuan"));
                txt_stock.setText(res.getString("jumlah"));
            }
            res.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbx_kodeMouseClicked

    private void cbx_kodeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbx_kodeItemStateChanged
        // TODO add your handling code here:
          String sql = "SELECT * FROM tabel_barang WHERE kode_barang = '"+cbx_kode.getSelectedItem().toString()+"'";
        try {
              Class.forName(driver);
              Connection kon = DriverManager.getConnection(database,user,pass);                      
              Statement stt = kon.createStatement();  
              ResultSet res = stt.executeQuery(sql);
            if(res.next()){
                txt_nama_barang.setText(res.getString("nama_barang"));
                txt_harga_satuan.setText(res.getString("harga_satuan"));
                txt_stock.setText(res.getString("jumlah"));
            }
            res.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbx_kodeItemStateChanged

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
    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        // TODO add your handling code here:
        String NamaFile = "/report/report_transaksi_tunai.jasper";
            HashMap hash = new HashMap();
        try {
            hash.put("kodepembelitunai", txt_kode_pembeli.getText());
            runReportDefault(NamaFile,hash);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_cetakActionPerformed

    private void txt_nama_pembeliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nama_pembeliKeyTyped
    // TODO add your handling code here:
        if (txt_nama_pembeli.getText().length() == 15 ) {
        evt.consume();
    }
    }//GEN-LAST:event_txt_nama_pembeliKeyTyped

    private void txt_alamat_pembeliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_alamat_pembeliKeyTyped
        // TODO add your handling code here:
        if (txt_alamat_pembeli.getText().length() == 30 ) {
        evt.consume();
    }
    }//GEN-LAST:event_txt_alamat_pembeliKeyTyped

    private void txt_banyak_barangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_banyak_barangKeyTyped
        // TODO add your handling code here:
        if (txt_banyak_barang.getText().length() == 3 ) {
        evt.consume();
    }
    }//GEN-LAST:event_txt_banyak_barangKeyTyped

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        membersihkan_teks();
    }//GEN-LAST:event_btn_batalActionPerformed

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
            java.util.logging.Logger.getLogger(frm_transaksi_tunai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_transaksi_tunai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_transaksi_tunai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_transaksi_tunai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_transaksi_tunai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_cetak;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JComboBox cbx_kode;
    private javax.swing.JTextField id_detail;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private Form.pembuat pembuat1;
    private javax.swing.JTable tabel_transaksi_tunai;
    private javax.swing.JTextArea txt_alamat_pembeli;
    private javax.swing.JTextField txt_banyak_barang;
    private javax.swing.JTextField txt_harga_satuan;
    private javax.swing.JTextField txt_harga_total;
    private javax.swing.JTextField txt_kode_pembeli;
    private javax.swing.JTextField txt_nama_barang;
    private javax.swing.JTextField txt_nama_pembeli;
    private javax.swing.JTextField txt_stock;
    private javax.swing.JTextField txt_tanggal_pembeli;
    private javax.swing.JTextField txt_total_biaya;
    // End of variables declaration//GEN-END:variables
}
