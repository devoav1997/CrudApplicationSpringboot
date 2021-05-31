package com.credit.ACCFinance.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.credit.ACCFinance.model.Customer;
import com.credit.ACCFinance.model.Kredit;

public interface KreditRepository extends CrudRepository<Kredit, String>{
	@Query("select k from Kredit k where k.kredit_id='1'")
	 List<Kredit> findByNameEndsWith(String chars);

}
