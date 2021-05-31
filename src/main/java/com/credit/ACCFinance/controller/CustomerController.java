package com.credit.ACCFinance.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.context.Context;

import com.credit.ACCFinance.service.CustomerRepository;
import com.credit.ACCFinance.model.Customer;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;



@Controller
public class CustomerController {
	
	private CustomerRepository customerRepository;
	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	//Ini jalan pas yang search id di submit
	//navbar/insert ID Customer --> halaman Input form pembayaran (pembayaran.html) 
	@GetMapping("/InsertPembayaranValue")	
	public String tambahHistori(@RequestParam String idCust, Model model) {
	
		
		//ini list isinya hasil query join yang querynya ada di kelas custome repository
		List<Object[]> listDataHasilJoin = customerRepository.findCustomerkreditinfo(idCust);
		
		//Jika ID Cust tidak ditemukan --> kembali ke index
		if(listDataHasilJoin.size() < 1) {
			
			System.out.println("ID CUSTOMER TIDAK DITEMUKAN"); //console
			
			return "dashboard1";
			
			
		}
		
		//Jika ID Cust ditemukan --> halaman Input form pembayaran (pembayaran.html) 
		model.addAttribute("listDataHasilJoin", listDataHasilJoin);
		return "Pembayaran";
		}

	// Ini yg buat nginputin ID cust
	@GetMapping("/InputIdCust")
    public String SearchCust() {
        return "index";
    }
	
	//halaman form add customer
	@GetMapping("/signupcustomer")
    public String showSignUpForm(Customer customer) {
        return "addcustomer";
    }
	
	
	//halaman data customer
	@RequestMapping("/customer")
	public String showCustomer(Model model) {
    model.addAttribute("diambilcust", customerRepository.findAll());
        return "customer";
    }
    
	//menyimpann data customer baru setelah berhasil disubmit
    @PostMapping("/addcustomer")
    public String addCustomer(Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addcustomer";
        }
        customerRepository.save(customer);
        model.addAttribute("diambilcust", customerRepository.findAll());
        return "customer";
    }
    
    //halaman edit data customer
    @GetMapping("/editcustomer/{id_cust}")
	public String showUpdateForm(@PathVariable("id_cust") String id, Model model) {
	    Customer customer = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    System.out.println("BERHASIL");
	    model.addAttribute("customer", customer);
	    
	    return "updatecustomer";
	}
    
    @RequestMapping("/dashboard")
	public String dashboard () {
		return "dashboard1";
    }
 

    
    //menyimpan data customer yang telah diedit
    @PostMapping("/updatecustomer/{id_cust}")
	public String updateUser(@PathVariable("id_cust") String id, Customer customer, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	customer.setId_cust(id);
	        return "updatecustomer";
	    }
	        
	    customerRepository.save(customer);
	    model.addAttribute("diambilcust", customerRepository.findAll());
	    return "customer";
	}
	
    //halaman delete data customer
	@GetMapping("/deletecustomer/{id_cust}")
	public String deleteUser(@PathVariable("id_cust") String id, Model model) {
		Customer customer = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		customerRepository.delete(customer);
	    model.addAttribute("diambilcust", customerRepository.findAll());
	    return "customer";
	}
	
}