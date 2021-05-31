package com.credit.ACCFinance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credit.ACCFinance.model.HistoriCicilan;

@Service
public class HistoriCicilanServiceForNameCustomer {
	@Autowired
	private HistoriCicilanSearchByCustomerNameRepository repo;

	public List<HistoriCicilan> listAllByNameCustomer(String keyword){
		if(keyword != null) {
			return repo.searchByNamaCustomer(keyword);
		}
		return repo.findAll();
		
	}

}

//2. ini buat dipanggil di historicicilancontroller untuk search by name customer. kalau kita input gaada namanya tablenya jadi kosonh