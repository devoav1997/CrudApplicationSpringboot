package com.credit.ACCFinance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.credit.ACCFinance.model.Salesman;

public interface SalesmanRestRepository extends PagingAndSortingRepository<Salesman, String>{
	@Query(value="select * from salesman s where s.id_salesman=:ID", nativeQuery=true)
	List findSalesmanById(@Param("ID") String ID);
	List<Salesman> findSalesmanByRegion(String region);
}

// untuk restapi, berdasarkan salesman id dan region.