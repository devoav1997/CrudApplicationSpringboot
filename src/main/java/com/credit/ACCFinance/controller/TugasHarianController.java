package com.credit.ACCFinance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.credit.ACCFinance.model.Tugas;
import com.credit.ACCFinance.service.TugasRepository;



@Controller
public class TugasHarianController {

	private TugasRepository tugasRepository;
	
	@Autowired
	public void setTugasRepository(TugasRepository tugasRepository) {
		this.tugasRepository = tugasRepository;
	}
	
	//halaman data tugasharian
	@RequestMapping("/tugasharian")
    public String showTugas(Model model) {
    model.addAttribute("diambiltug", tugasRepository.findAll());
        return "tugasharian";
    }
	
	@RequestMapping("/tampilansalesman")
    public String showSalesman(Model model) {
    model.addAttribute("diambiltug", tugasRepository.findAll());
        return "tampilansalesman";
    }
	
	@GetMapping("/printtugas/{id_salesman}")
	public String showPrint(@PathVariable("id_salesman") String id, Model model) {
	    Tugas tugas = tugasRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    System.out.println("BERHASIL");
	    model.addAttribute("tugas", tugas);
	    
	    return "printtugas";
	}
	
	//halaman form add tugasharian untuk spv
	@GetMapping("/signuptask")
    public String showSignUp(Tugas tugas) {
        return "addtugas";
    }
    
	
	
	//menyimpann data tugasharian baru setelah berhasil disubmit
    @PostMapping("/addtugas")
    public String addTugas(Tugas tugas, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addtugas";
        }
        
        tugasRepository.findByName("test");
        tugasRepository.save(tugas);
        model.addAttribute("diambiltug", tugasRepository.findAll());
        return "tugasharian";
    }
    
  //halaman edit data tugasharian
    @GetMapping("/edittugas/{id_salesman}")
	public String showUpdateForm(@PathVariable("id_salesman") String id, Model model) {
	    Tugas tugas = tugasRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Bukti terpanggil!!!!!!!!!!!!");
	    model.addAttribute("tugas",tugas);
	    
	    return "updatetugas";
	}
    
    //menyimpan data tugasharian yang telah diedit
    @PostMapping("/updatetugas/{id_salesman}")
	public String updateUser(@PathVariable("id_salesman") String id, Tugas tugas, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	tugas.setId_salesman(id);
	        return "updatetugas";
	    }
	        
	    tugasRepository.save(tugas);
	    model.addAttribute("diambiltug", tugasRepository.findAll());
	    return "tugasharian";
	}
	 
    //halaman delete data tugasharian
	@GetMapping("/deletetugas/{id_salesman}")
	public String deleteUser(@PathVariable("id_salesman") String id, Model model) {
		Tugas tugas = tugasRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		tugasRepository.delete(tugas);
	    model.addAttribute("diambiltug", tugasRepository.findAll());
	    return "tugasharian";
	}
}