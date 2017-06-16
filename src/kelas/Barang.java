/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelas;

/**
 *
 * @author YohanesEAC
 */

public class Barang {
    public String txt_kode_barang,txt_nama_barang,txt_tanggal_barang_masuk,cbx_jenis;
    public double txt_harga_satuan,txt_jumlah_barang;
    String jml = String.valueOf(txt_jumlah_barang);
    String hrg = String.valueOf(txt_harga_satuan);
    
    public String getkodeBarang(){
        return txt_kode_barang;
    }
    
    public void setkodeBarang(String txt_kode_barang){
        this.txt_kode_barang = txt_kode_barang;
    }
    
    public String getNamaBarang(){
        return txt_nama_barang;
    }
    
    public void setNamaBarang(String txt_nama_barang){
        this.txt_nama_barang = txt_nama_barang;
    }
    
        public String getTanggalBarangMasuk(){
        return txt_tanggal_barang_masuk;
    }
    
    public void setTanggalBarangMasuk(String txt_tanggal_barang_masuk){
        this.txt_tanggal_barang_masuk =txt_tanggal_barang_masuk;
    }
        public String getJenisBarang(){
        return cbx_jenis;
    }
    
    public void setJenisBarang(String cbx_jenis){
        this.cbx_jenis = cbx_jenis;
    }
    public String getJumlah(){
        return jml;
    }
    
    public void setJumlah(String jml){
        this.jml = jml;
    }
    
    public String getHarga(){
        return hrg;
    }
    
    public void setHarga(String hrg){
        this.hrg = hrg;
    }
}

