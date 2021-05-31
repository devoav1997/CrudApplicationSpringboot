package com.credit.ACCFinance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.credit.ACCFinance.service.CustomerRestRepository;
import com.credit.ACCFinance.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
public class CustomerRestController {
	@Autowired
	  CustomerRestRepository customerRestRepository;
	  
	  @GetMapping("/api/customer") //mengambil data dari api customer u/ menampilkan semua data customer
	  @ResponseBody
	  public Page<Customer> getAll(Pageable page) {
	        return customerRestRepository.findAll(page);
	  }
	  
	  @GetMapping("/api/customer/{id_cust}") //mengambil data dari api customer berdasarkan id_cust
	  @ResponseBody
	  public List getSalesmanId(@PathVariable String id_cust)  {
		    return customerRestRepository.findCustomerById(id_cust);
	  }
}