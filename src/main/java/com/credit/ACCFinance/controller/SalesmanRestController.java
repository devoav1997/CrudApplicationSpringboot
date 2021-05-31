package com.credit.ACCFinance.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.credit.ACCFinance.model.Salesman;
import com.credit.ACCFinance.service.SalesmanRestRepository;

@RestController
public class SalesmanRestController {
	 
	  @Autowired
	  SalesmanRestRepository salesmanRestRepository;
	  
	  @GetMapping("/api/salesman")
	  @ResponseBody
	  public Page<Salesman> getAll(Pageable page) {
	        return salesmanRestRepository.findAll(page);
	  }
	   
	  @GetMapping("/api/salesman/{id_salesman}")
	  @ResponseBody
	  public List getSalesmanIdBySalesman(@PathVariable String id_salesman)  {
		    return salesmanRestRepository.findSalesmanById(id_salesman);
	  }
	  
	  @GetMapping("/api/salesman/region/")
		public List<Salesman> getSalesmanRegion(@RequestParam(value="region")String region){
			return salesmanRestRepository.findSalesmanByRegion(region);
		}
}

// ini untuk restapi salesman sama region

//http://localhost:8080/api/salesman/region/?region=bandung