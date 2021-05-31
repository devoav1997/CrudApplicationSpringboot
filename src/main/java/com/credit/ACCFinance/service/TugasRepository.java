package com.credit.ACCFinance.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



import com.credit.ACCFinance.model.Tugas;

public interface TugasRepository extends CrudRepository<Tugas, String>{
	@Query("select t from Tugas t where t.id_salesman='1'")
	 List<Tugas> findByName(String chars);
	

}

// ini query untuk memanggil tugas di controller