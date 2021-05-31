package com.credit.ACCFinance.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.credit.ACCFinance.model.Produk;

public interface produkRepositoryForSearch extends CrudRepository<Produk, String>{
	@Query(value="select c.nama_cust, k.total_pelunasan, k.sisa_pelunasan, p.nama_prod, c.id_cust, k.kredit_id  from customer c, kredit k, produk p where c.id_cust=:ID and c.id_kredit=k.kredit_id and k.id_prod=p.id_prod", nativeQuery=true)
	
	List findCustomerkreditinfo(@Param("ID") String ID);
}
