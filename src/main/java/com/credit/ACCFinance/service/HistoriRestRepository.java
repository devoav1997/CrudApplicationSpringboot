package com.credit.ACCFinance.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.credit.ACCFinance.model.HistoriCicilan;

public interface HistoriRestRepository extends PagingAndSortingRepository<HistoriCicilan, String>{
	@Query(value="select * from histori h where h.id_cust=:ID", nativeQuery=true)
	List findhistoryNoReff(@Param("ID") String ID);

}
