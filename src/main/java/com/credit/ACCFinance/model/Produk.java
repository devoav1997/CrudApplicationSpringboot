package com.credit.ACCFinance.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produk")
public class Produk implements Serializable {
	
	@Id
	private String id_prod;
	private String nama_prod;
	private String tipe_prod;
	private String tahun_pembuatan;
	private Float discount;
	private Integer harga_prod;
	public String getId_prod() {
		return id_prod;
	}
	public void setId_prod(String id_prod) {
		this.id_prod = id_prod;
	}
	public String getNama_prod() {
		return nama_prod;
	}
	public void setNama_prod(String nama_prod) {
		this.nama_prod = nama_prod;
	}
	public String getTipe_prod() {
		return tipe_prod;
	}
	public void setTipe_prod(String tipe_prod) {
		this.tipe_prod = tipe_prod;
	}
	public String getTahun_pembuatan() {
		return tahun_pembuatan;
	}
	public void setTahun_pembuatan(String tahun_pembuatan) {
		this.tahun_pembuatan = tahun_pembuatan;
	}
	public Float getDiscount() {
		return discount;
	}
	public void setDiscount(Float discount) {
		this.discount = discount;
	}
	public Integer getHarga_prod() {
		return harga_prod;
	}
	public void setHarga_prod(Integer harga_prod) {
		this.harga_prod = harga_prod;
	}

	
}
