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
public class TransaksiCicil {
     public String txt_kode_pembeli,tanggal_pembeli,txt_nama_pembeli,txt_alamat_pembeli,tenggang_waktu,txt_banyak_barang,txt_stock,txt_keterangan;
    public double txt_harga_satuan,txt_harga_total,uang_muka,total_biaya,txt_sisa;
    String hargatotal = String.valueOf(txt_harga_total);
    String hargasatu = String.valueOf(txt_harga_satuan);
    String uangmuka = String.valueOf(uang_muka);
    String totalbiaya = String.valueOf(total_biaya);
    String sisa = String.valueOf(txt_sisa);
    
    public String GetKodePembeli(){
        return txt_kode_pembeli;
    }
    
    public void SetKodePembeli(String txt_kode_pembeli){
        this.txt_kode_pembeli = txt_kode_pembeli;
    }
    
    public String getTanggalPembeli(){
        return tanggal_pembeli;
    }
    
    public void setTanggalPembeli(String tanggal_pembeli){
        this.tanggal_pembeli = tanggal_pembeli;
    }
    
        public String getNamaPembeli(){
        return txt_nama_pembeli;
    }
    
    public void setNamaPembeli(String txt_nama_pembeli){
        this.txt_nama_pembeli =txt_nama_pembeli;
    }
        public String getAlamatPembeli(){
        return txt_alamat_pembeli;
    }
    
    public void setAlamatPembeli(String txt_alamat_pembeli){
        this.txt_alamat_pembeli = txt_alamat_pembeli;
    }
        public String getTenggangWaktu(){
        return tenggang_waktu;
    }
    
    public void setTenggangWaktu(String tenggang_waktu){
        this.tenggang_waktu = tenggang_waktu;
    }
    
        public String getBanyakBarang(){
        return txt_banyak_barang;
    }
    
    public void setBanyakBarang(String txt_banyak_barang){
        this.txt_banyak_barang =txt_banyak_barang;
    }
        public String getStock(){
        return txt_stock;
    }
    
    public void setStock(String txt_stock){
        this.txt_stock = txt_stock;
    }
    public String getHargaSatuan(){
        return hargasatu;
    }
    
    public void setHargaSatuan(String hargasatu){
        this.hargasatu = hargasatu;
    }
    
    public String getHargaTotal(){
        return hargatotal;
    }
    
    public void setHargaTotal(String hargatotal){
        this.hargatotal = hargatotal;
    }
        public String getUangMuka(){
        return uangmuka;
    }
    
    public void setUangMuka(String uangmuka){
        this.uangmuka = uangmuka;
    }
        public String getTotalBiaya(){
        return totalbiaya;
    }
    
    public void setTotalBiaya(String totalbiaya){
        this.totalbiaya = totalbiaya;
    }
    
            public String getSisa(){
        return sisa;
    }
    
    public void setSisa(String sisa){
        this.txt_sisa = txt_sisa;
    }
        public String getKeterangan(){
        return txt_keterangan;
    }
    
    public void setKeterangan(String txt_keterangan){
        this.txt_keterangan = totalbiaya;
    }

}
