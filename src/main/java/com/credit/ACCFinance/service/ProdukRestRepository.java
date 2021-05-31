package com.credit.ACCFinance.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.credit.ACCFinance.model.Produk;

public interface ProdukRestRepository extends PagingAndSortingRepository<Produk, String>{
	@Query("select s from Produk s where s.id_prod in(select max(c.id_prod) from Produk c)")
	Produk findByMax();

}