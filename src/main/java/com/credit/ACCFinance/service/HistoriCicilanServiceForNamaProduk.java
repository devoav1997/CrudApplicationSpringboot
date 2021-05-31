package com.credit.ACCFinance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credit.ACCFinance.model.HistoriCicilan;

@Service
public class HistoriCicilanServiceForNamaProduk {
	
	@Autowired
	private HistoriCicilanSearchByProdukNameRepository repo;

	public List<HistoriCicilan> listAllByNameProduk(String keyword){
		if(keyword != null) {
			return repo.searchByNamaProduk(keyword);
		}
		return repo.findAll();
		
	}
}

//4. ini buat dipanggil di historicicilancontroller untuk search by name_prod.