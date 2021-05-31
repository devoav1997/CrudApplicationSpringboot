package com.credit.ACCFinance.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Salesman  implements Serializable{
	
	@Id
	private Integer id_salesman;
	private String salesman_name;
	private Integer id_prod;
	private String region;
	private String keterangan;
	
	public Integer getId_salesman() {
		return id_salesman;
	}
	public void setId_salesman(Integer id_salesman) {
		this.id_salesman = id_salesman;
	}
	public String getSalesman_name() {
		return salesman_name;
	}
	public void setSalesman_name(String salesman_name) {
		this.salesman_name = salesman_name;
	}
	public Integer getId_prod() {
		return id_prod;
	}
	public void setId_prod(Integer id_prod) {
		this.id_prod = id_prod;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	
}