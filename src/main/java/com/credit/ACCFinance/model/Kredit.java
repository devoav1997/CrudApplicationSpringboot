package com.credit.ACCFinance.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kredit implements Serializable{
	
	@Id
	private String kredit_id; 
	private String tenor;
	private Integer total_pelunasan;
	private Integer sisa_pelunasan;
	private String jatuh_tempo;
	private String tahun_kredit;
	private String id_prod;
	private String sisa_tenor;
	public String getKredit_id() {
		return kredit_id;
	}
	public void setKredit_id(String kredit_id) {
		this.kredit_id = kredit_id;
	}
	public String getTenor() {
		return tenor;
	}
	public void setTenor(String tenor) {
		this.tenor = tenor;
	}
	public Integer getTotal_pelunasan() {
		return total_pelunasan;
	}
	public void setTotal_pelunasan(Integer total_pelunasan) {
		this.total_pelunasan = total_pelunasan;
	}
	public Integer getSisa_pelunasan() {
		return sisa_pelunasan;
	}
	public void setSisa_pelunasan(Integer sisa_pelunasan) {
		this.sisa_pelunasan = sisa_pelunasan;
	}
	public String getJatuh_tempo() {
		return jatuh_tempo;
	}
	public void setJatuh_tempo(String jatuh_tempo) {
		this.jatuh_tempo = jatuh_tempo;
	}
	public String getTahun_kredit() {
		return tahun_kredit;
	}
	public void setTahun_kredit(String tahun_kredit) {
		this.tahun_kredit = tahun_kredit;
	}
	public String getId_prod() {
		return id_prod;
	}
	public void setId_prod(String id_prod) {
		this.id_prod = id_prod;
	}
	public String getSisa_tenor() {
		return sisa_tenor;
	}
	public void setSisa_tenor(String sisa_tenor) {
		this.sisa_tenor = sisa_tenor;
	}
	
}
