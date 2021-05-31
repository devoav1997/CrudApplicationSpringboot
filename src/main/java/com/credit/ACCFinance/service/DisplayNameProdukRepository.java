package com.credit.ACCFinance.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.credit.ACCFinance.model.Produk;


public interface DisplayNameProdukRepository extends CrudRepository<Produk, String>{
	
@Query(value="select h.no_reff, h.total_trx, h.tanggal_bayar, h.denda, p.nama_prod, c.nama_cust, c.id_cust from customer c, kredit k, produk p, histori h where c.id_cust=:ID and c.id_kredit = k.kredit_id and k.id_prod=p.id_prod and h.id_cust=c.id_cust", nativeQuery=true)
	
	List findprint(@Param("ID") String ID);


 }

// ini query untuk print histori cicilan