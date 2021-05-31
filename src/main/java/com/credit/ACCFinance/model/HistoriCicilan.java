package com.credit.ACCFinance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name="histori")
public class HistoriCicilan implements Serializable {
	
	@Id
	@GenericGenerator(name = "uuid-gen", strategy = "uuid2")
	@GeneratedValue(generator = "uuid-gen")
	private String no_reff;
	private Integer total_trx;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date tanggal_bayar;
	private String id_cust;
	private Integer denda;
	public String getNo_reff() {
		return no_reff;
	}
	public void setNo_reff(String no_reff) {
		this.no_reff = no_reff;
	}
	public Integer getTotal_trx() {
		return total_trx;
	}
	public void setTotal_trx(Integer total_trx) {
		this.total_trx = total_trx;
	}
	public Date getTanggal_bayar() {
		return tanggal_bayar;
	}
	public void setTanggal_bayar(Date tanggal_bayar) {
		this.tanggal_bayar = tanggal_bayar;
	}
	public String getId_cust() {
		return id_cust;
	}
	public void setId_cust(String id_cust) {
		this.id_cust = id_cust;
	}
	public Integer getDenda() {
		return denda;
	}
	public void setDenda(Integer denda) {
		this.denda = denda;
	}
	
	
}
