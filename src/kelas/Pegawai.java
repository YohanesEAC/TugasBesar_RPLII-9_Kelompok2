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
public class Pegawai {
     public String txt_kode_pegawai,txt_nama_pegawai,txt_password,txt_level,txt_alamat_pegawai,cbx_jeniskelamin;
    
    
    public String GetKodePegawai(){
        return txt_kode_pegawai;
    }
    
    public void SetKodePegawai(String txt_kode_pegawai){
        this.txt_kode_pegawai = txt_kode_pegawai;
    }
    
    public String GetNamaPegawai(){
        return txt_nama_pegawai;
    }
    
    public void SetNamaPegawai(String txt_nama_pegawai){
        this.txt_nama_pegawai = txt_nama_pegawai;
    }
    
     public void SetJenisKelamin(String cbx_jeniskelamin){
        this.cbx_jeniskelamin = cbx_jeniskelamin;
    }
     public String GetJenisKelamin(){
        return cbx_jeniskelamin;
    }
     public void SetAlamatPegawai(String txt_alamat_pegawai){
        this.txt_alamat_pegawai = txt_alamat_pegawai;
    }
     public String GetAlamatPegawai(){
        return txt_alamat_pegawai;
    }
     public void SetPassword(String txt_password){
        this.txt_password = txt_password;
    }
     public String GetPassword(){
        return txt_password;
    }
     public void SetLevel(String txt_level){
        this.txt_level = txt_level;
    }
     public String GetLevel(){
        return txt_level;
    }
    
}



