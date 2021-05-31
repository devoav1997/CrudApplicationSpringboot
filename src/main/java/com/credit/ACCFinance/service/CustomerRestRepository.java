package com.credit.ACCFinance.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.credit.ACCFinance.model.Customer;

public interface CustomerRestRepository extends PagingAndSortingRepository<Customer, String>{
	@Query(value="select c.nama_cust, k.sisa_pelunasan, k.sisa_tenor, p.nama_prod from customer c, kredit k, produk p where c.id_cust=:ID and c.id_kredit=k.kredit_id and k.id_prod=p.id_prod", nativeQuery=true)
	List findCustomerById(@Param("ID") String ID);
}
