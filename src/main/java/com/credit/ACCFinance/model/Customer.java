package com.credit.ACCFinance.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Entity;

@Entity //Connect to DB
@Table(name="customer") //@Table = Penamaan Table 
public class Customer implements Serializable {
	
	@Id 
	private String id_cust; //PK
	private String nama_cust;
	private String alamat;
	private String no_ktp;
	private String id_kredit;
	private String keterangan;
	public String getId_cust() {
		return id_cust;
	}
	public void setId_cust(String id_cust) {
		this.id_cust = id_cust;
	}
	public String getNama_cust() {
		return nama_cust;
	}
	public void setNama_cust(String nama_cust) {
		this.nama_cust = nama_cust;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getNo_ktp() {
		return no_ktp;
	}
	public void setNo_ktp(String no_ktp) {
		this.no_ktp = no_ktp;
	}
	public String getId_kredit() {
		return id_kredit;
	}
	public void setId_kredit(String id_kredit) {
		this.id_kredit = id_kredit;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
}