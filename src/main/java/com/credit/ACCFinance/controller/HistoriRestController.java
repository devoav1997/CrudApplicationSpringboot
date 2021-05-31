package com.credit.ACCFinance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.credit.ACCFinance.service.CustomerRestRepository;
import com.credit.ACCFinance.service.HistoriRestRepository;
import com.credit.ACCFinance.model.Customer;
import com.credit.ACCFinance.model.HistoriCicilan;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
public class HistoriRestController {
	@Autowired
	  HistoriRestRepository historiRestRepository;
	  
	  @GetMapping("/api/histori")
	  @ResponseBody
	  public Page<HistoriCicilan> getAll(Pageable page) {
	        return historiRestRepository.findAll(page);
	  }
	  
	@GetMapping("/api/histori/{id_cust}")
	@ResponseBody
	public List getHistoryCicilanCustomerbyCustomerId(@PathVariable String id_cust)  {
		    return historiRestRepository.findhistoryNoReff(id_cust);
	}
}