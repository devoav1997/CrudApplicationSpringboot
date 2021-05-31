package com.credit.ACCFinance.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.credit.ACCFinance.model.Produk;


public interface ProdukRepository extends CrudRepository<Produk, String>{
	@Query("select p from Produk p where p.id_prod='1'")
	 List<Produk> findByNameEndsWith(String chars);
	
}
