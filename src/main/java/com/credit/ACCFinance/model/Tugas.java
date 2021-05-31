package com.credit.ACCFinance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tugas")

public class Tugas implements Serializable {
	@Id
	private String id_salesman;
	private String nama_salesman;
	private String tugas_harian;
	
	//@Temporal(TemporalType.TIMESTAMP)
	//@UpdateTimestamp
	private String tanggal_tugas;
	private String supervisor;
	public String getId_salesman() {
		return id_salesman;
	}
	public void setId_salesman(String id_salesman) {
		this.id_salesman = id_salesman;
	}
	public String getNama_salesman() {
		return nama_salesman;
	}
	public void setNama_salesman(String nama_salesman) {
		this.nama_salesman = nama_salesman;
	}
	public String getTugas_harian() {
		return tugas_harian;
	}
	public void setTugas_harian(String tugas_harian) {
		this.tugas_harian = tugas_harian;
	}
	public String getTanggal_tugas() {
		return tanggal_tugas;
	}
	public void setTanggal_tugas(String tanggal_tugas) {
		this.tanggal_tugas = tanggal_tugas;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	
	
}
