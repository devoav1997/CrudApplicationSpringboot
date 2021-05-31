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

import com.credit.ACCFinance.model.Customer;
import com.credit.ACCFinance.model.HistoriCicilan;
import com.credit.ACCFinance.model.Kredit;

import com.credit.ACCFinance.service.HistoriCicilanRepository;
import com.credit.ACCFinance.service.KreditRepository;
import java.util.Random;
import java.text.SimpleDateFormat;  
import java.util.Date;  

@Controller
public class KreditController {
private KreditRepository kreditRepository;
private HistoriCicilanRepository historiRepository;

//inisialisasi tenor dan sisa pelunasan
int sisa_tenor_going_for_update ;
int sisa_pelunasan_going_for_update;

//ini buat date 
Date date = new Date();  

	@Autowired
	public void setKreditRepository(KreditRepository kreditRepository) {
		this.kreditRepository = kreditRepository;
	}
	
	@Autowired
	public void setHistoriCicilanRepository(HistoriCicilanRepository historiRepository) {
		this.historiRepository = historiRepository;
	}
	
	//halaman data kredit
	@RequestMapping("/kredit")
	public String showKredit(Model model) {
    model.addAttribute("diambilkre", kreditRepository.findAll());
        return "kredit";
    }
	
	//halaman form add kredit
	@GetMapping("/signupkredit")
    public String showSignUpForm(Kredit kredit) {
        return "addkredit";
    }
    
	//menambahkan kredit baru
    @PostMapping("/addkredit")
    public String addKredit(Kredit kredit, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addkredit";
        }
        
        kreditRepository.findByNameEndsWith("test");
        kreditRepository.save(kredit);
        model.addAttribute("diambilkre", kreditRepository.findAll());
        return "kredit";
    }	
   
    //halaman untuk mengedit data kredit berdasarkan kredit id
    @GetMapping("/editkredit/{kredit_id}")
	public String showUpdateForm(@PathVariable("kredit_id") String id, Model model) {
	    Kredit kredit = kreditRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    System.out.println("BERHASIL");
	    model.addAttribute("kredit", kredit);
	    
	    return "updatekredit";
	}
    
    //setelah data kredit berhasil di edit --> data kredit terupdate
    @PostMapping("/updatekredit/{kredit_id}")
	public String updateUser(@PathVariable("kredit_id") String id, Kredit kredit, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	kredit.setId_prod(id);
	        return "updatekredit";
	    }
	        
	    kreditRepository.save(kredit);
	    model.addAttribute("diambilkre", kreditRepository.findAll());
	    return "kredit";
	}
    
    //delete data kredit
	@GetMapping("/deletekredit/{kredit_id}")
	public String deleteUser(@PathVariable("kredit_id") String id, Model model) {
		Kredit kredit = kreditRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		kreditRepository.delete(kredit);
	    model.addAttribute("diambilkre", kreditRepository.findAll());
	    return "kredit";
	}
    
    //ini jalan abis di redirect dari histori, itu variabel di parameter buat nerima paket yang dikirim dari //histori tadi
	//setelah menginput pembayaran baru --> hasil akhirnya ditampilkan di Invoice
    @GetMapping("/Invoice")
    public String showInvoice(String kredit_id, 
    		int total_bayar,
    		String nama_customer,
    		int sisa_pelunasan,
    		int total_pelunasan,
    		String nama_kredit,
    		String nama_produk,
    		Model model) {
    	
        //ini sama aja kaya select...from... where id = ..., yg di pake kredit_id, disimpan di kredit
    	Kredit kredit = kreditRepository.findById(kredit_id).orElseThrow(() -> new IllegalArgumentException("Invalid kredit Id:" + kredit_id));
    	
    	int sisa_pelunasan_before_update = kredit.getSisa_pelunasan();
    	int tenor_before_update = Integer.parseInt(kredit.getSisa_tenor());
    	int pelunasan_total = kredit.getTotal_pelunasan();
    	int tenor = Integer.parseInt(kredit.getTenor());
    	
    	//perhitungan untuk memasukkan pelunasan, jika tenor sebelum di update =  jumlah tenor 
    	//maka sisa tenor - 1 = sisa tenor terbaru
    	if (tenor_before_update == tenor) {
    		
    		sisa_tenor_going_for_update = tenor_before_update - 1;
        	sisa_pelunasan_going_for_update = pelunasan_total - total_bayar;
        	
        	kredit.setSisa_pelunasan(sisa_pelunasan_going_for_update);
        	kredit.setSisa_tenor(Integer.toString(sisa_tenor_going_for_update));
        	kreditRepository.save(kredit);
    		
    	//perhitungan jika tenor sudah di update lebih kecil dari jumlah tenor yang ada
        //maka sisa tenor - 1 
    	}else if(tenor_before_update < tenor) {
    		
    		sisa_tenor_going_for_update = tenor_before_update - 1;
        	sisa_pelunasan_going_for_update = sisa_pelunasan_before_update - total_bayar;
        	
        	kredit.setSisa_pelunasan(sisa_pelunasan_going_for_update);
        	kredit.setSisa_tenor(Integer.toString(sisa_tenor_going_for_update));
        	kreditRepository.save(kredit);
    		
    	}
    	
    	
    	//data yang ditampilkan di Invoice
    	model.addAttribute("nama_customer",nama_customer);
    	model.addAttribute("nama_produk", nama_produk);
    	model.addAttribute("total_pelunasan",total_pelunasan);
    	model.addAttribute("nama_kredit",nama_kredit);
    	model.addAttribute("sisa_pelunasan",sisa_pelunasan_going_for_update);
    	model.addAttribute("bayar_bulan_ini",total_bayar);
    	model.addAttribute("sisa_tenor",sisa_tenor_going_for_update);
    	
        return "Invoice";
    }
    
	
	
  
}