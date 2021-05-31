package com.credit.ACCFinance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.credit.ACCFinance.service.ProdukRestRepository;
import com.credit.ACCFinance.model.Produk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
public class ProdukRestController {
	
	  
	  @Autowired
	  ProdukRestRepository produkRestRepository;
	  
	  @GetMapping("/api/produk")
	  @ResponseBody
	  public Page<Produk> getAll(Pageable page) {
	        return produkRestRepository.findAll(page);
	  }
	   
	  @GetMapping("/api/produk/prodlastid")
		@ResponseBody
		public Produk getByProd_Id() {
			return produkRestRepository.findByMax();
		}
}