package com.credit.ACCFinance.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.credit.ACCFinance.model.HistoriCicilan;

public interface HistoriCicilanSearchByCustomerNameRepository  extends JpaRepository<HistoriCicilan, String>{
	@Query(value = "SELECT * FROM histori h, customer c, produk p, kredit k WHERE c.id_cust = h.id_cust and p.id_prod = k.id_prod and c.id_kredit=k.kredit_id AND c.nama_cust like %:namacustomer%", nativeQuery=true)
    public List<HistoriCicilan> searchByNamaCustomer(String namacustomer);

}
//1. disini kita menggabungkan table histori, customer, produk, dan kredit.  like %:namacustomer%= ini untuk mencari nama customer.