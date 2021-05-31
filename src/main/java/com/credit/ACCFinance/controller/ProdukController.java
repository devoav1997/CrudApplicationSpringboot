package com.credit.ACCFinance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.credit.ACCFinance.model.Produk;
import com.credit.ACCFinance.model.Kredit;
import com.credit.ACCFinance.model.HistoriCicilan;
import com.credit.ACCFinance.service.ProdukRepository;
import com.credit.ACCFinance.service.KreditRepository;
import com.credit.ACCFinance.service.HistoriCicilanRepository;

import java.util.Random;

@Controller
public class ProdukController {

	private ProdukRepository produkRepository;
	
	@Autowired
	public void setProdukRepository(ProdukRepository produkRepository) {
		this.produkRepository = produkRepository;
	}
	
	//halaman data produk
	@RequestMapping("/produk")
    public String showProduk(Model model) {
    model.addAttribute("diambilpro", produkRepository.findAll());
        return "produk";
    }
	
	//halaman form add produk
	@GetMapping("/signupproduk")
    public String showSignUpForm(Produk produk) {
        return "addproduk";
    }
    
	//menyimpann data produk baru setelah berhasil disubmit
    @PostMapping("/addproduk")
    public String addProduk(Produk produk, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addproduk";
        }
        
        produkRepository.findByNameEndsWith("test");
        produkRepository.save(produk);
        model.addAttribute("diambilpro", produkRepository.findAll());
        return "produk";
    }
    
  //halaman edit data produk
    @GetMapping("/editproduk/{id_prod}")
	public String showUpdateForm(@PathVariable("id_prod") String id, Model model) {
	    Produk produk = produkRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Bukti terpanggil!!!!!!!!!!!!");
	    model.addAttribute("produk", produk);
	    
	    return "updateproduk";
	}
    
    //menyimpan data produk yang telah diedit
    @PostMapping("/updateproduk/{id_prod}")
	public String updateUser(@PathVariable("id_prod") String id, Produk produk, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	produk.setId_prod(id);
	        return "updateproduk";
	    }
	        
	    produkRepository.save(produk);
	    model.addAttribute("diambilpro", produkRepository.findAll());
	    return "produk";
	}
	 
    //halaman delete data produk
	@GetMapping("/deleteproduk/{id_prod}")
	public String deleteUser(@PathVariable("id_prod") String id, Model model) {
		Produk produk = produkRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		produkRepository.delete(produk);
	    model.addAttribute("diambilpro", produkRepository.findAll());
	    return "produk";
	}
}