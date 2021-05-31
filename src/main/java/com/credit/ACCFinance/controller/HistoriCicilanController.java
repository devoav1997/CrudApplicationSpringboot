package com.credit.ACCFinance.controller;

import java.security.Provider.Service;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
import com.credit.ACCFinance.model.Produk;
import com.credit.ACCFinance.service.CustomerRepository;
import com.credit.ACCFinance.service.DisplayNameProdukRepository;
import com.credit.ACCFinance.service.HistoriCicilanRepository;
import com.credit.ACCFinance.service.HistoriCicilanServiceForNamaProduk;
import com.credit.ACCFinance.service.HistoriCicilanServiceForNameCustomer;
import com.credit.ACCFinance.service.KreditRepository;
import com.credit.ACCFinance.service.ProdukRepository;
import com.credit.ACCFinance.service.produkRepositoryForSearch;


@Controller
public class HistoriCicilanController {
	
	
	private HistoriCicilanRepository historiRepository;
		
	//ini buat date
	Date date = new Date();  

	//create random number
	String alphabet = "1234567890";

	//create random string builder
	StringBuilder sb = new StringBuilder();

	//create an object of Random class
	Random r = new Random();

	//specify length of random string
	//no reff
	int length = 7;
		
		@Autowired
		public void setHistoriCicilanRepository(HistoriCicilanRepository historiRepository) {
			this.historiRepository = historiRepository;
		}
		
		//halaman histori cicilan
		@RequestMapping("/histori")
		public String showHistoriCicilan(Model model) {
	    model.addAttribute("diambilhis", historiRepository.findAll());
	        return "historicicilan";
		}
		
		//ini jalan pas submit nominal pembayaran, requestparam analoginya buat nerima paket dari view(html) yg 
		//ngirim paket (sesuain namanya sama yang di html)
		//menyimpan data hasil dari pembayaran baru
		@PostMapping("/histori/simpan")
	    public String tambahHistoriCicilan(HistoriCicilan histori,
	    		@RequestParam String nama_customer,
	    		@RequestParam int total_pelunasan, 
	    		@RequestParam int sisa_pelunasan,
	    		@RequestParam String id_customer, 
	    		@RequestParam int total_bayar, 
	    		@RequestParam String nama_produk,
	    		@RequestParam String kredit_id, 
	    		BindingResult result, Model model, RedirectAttributes redirectAttributes) {
			if (result.hasErrors()) {
				return "erorr";
				}		

				//ini buat generate random number
				
				 for(int i = 0; i < length; i++) {

					 	//histori.setNo_reff(null);
					 	
				        // generate random index number
				        int index = r.nextInt(alphabet.length());

				        // get character specified by index
				        // from the string
				        char randomChar = alphabet.charAt(index);

				        // append the character to string builder
				        sb.append(randomChar);
				      }

				  String no_reff = sb.toString();
				  
				  //nyoba genenerate number
				  //generateId(str,num) {
			            //let uniqueId = ""
			            //let chars = "ABCDEFGHIJKLMNOPQRSTUVWYXZ"
			            
			            //for( let i=0; i < str; i++ ) {
			                //uniqueId += chars.charAt(Math.floor(Math.random() * chars.length))
			            //}
			            //for (let i=0; i < num; i++) {
			                //uniqueId+= Math.floor(Math.random() * 10);
			            //}
						//return uniqueId
					//}
			    
			 //   }
				  
				  //ini buat set nilai nilainya yg nanti di simpen di table histori
			      histori.setNo_reff(no_reff);
			      histori.setTotal_trx(total_bayar);
			      histori.setTanggal_bayar(date);
			      histori.setId_cust(id_customer);
			      histori.setDenda(0);

			      //ini buat save yang udah di set diatas (insert .... to ....)
			      //menyimpan histori pembayaran ke database
			      historiRepository.save(histori); 
			    

			    //ini buat mengirim data, analoginya kebalikan yang di atas, ini buat ngirim paket ke halaman invoice
				redirectAttributes.addAttribute("kredit_id", kredit_id); 
				redirectAttributes.addAttribute("total_bayar", total_bayar);
				redirectAttributes.addAttribute("nama_customer", nama_customer);
				redirectAttributes.addAttribute("nama_produk", nama_produk);
				redirectAttributes.addAttribute("sisa_pelunasan", sisa_pelunasan);
				redirectAttributes.addAttribute("total_pelunasan", total_pelunasan);
				
			return "redirect:/Invoice";
			}
		
		
		@Autowired
		private HistoriCicilanServiceForNameCustomer serviceNameCustomer;
		
		@Autowired
		private HistoriCicilanServiceForNamaProduk ServiceNamaProduk;
		
		@Autowired
		private DisplayNameProdukRepository displayNameProdukRepository;
		
		CustomerRepository customerrepository;
		
		@Autowired
		public void setCustomerRepository(CustomerRepository customerRepository) {
			this.customerrepository = customerRepository;
		}
		
		produkRepositoryForSearch produkrepositoryForSearch;
		
		@Autowired
		public void setProdukRepository(produkRepositoryForSearch  produkRepositoryForSearch) {
			this.produkrepositoryForSearch = produkRepositoryForSearch;
		}
		
		KreditRepository kreditrepository;
		

		@Autowired
		public void setKreditRepository(KreditRepository kreditRepository) {
			this.kreditrepository = kreditRepository;
		}
		
		
	    
	    
	  @GetMapping("/printhistori/{no_reff}")
	  public String showPrintHistori(@PathVariable("no_reff") String id, Model model) {
	  	  List<Produk> listDataHasilJoin = displayNameProdukRepository.findprint(id);
	      System.out.println("BERHASIL");
	      model.addAttribute("listDataHasilJoin", listDataHasilJoin);
	      
	      return "printhistori";
	  	}
	  
		@RequestMapping("/histori/search/namacustomer")
		public String SearchByNameCustomer(Model model, @Param("keyword") String keyword) {
	        List<HistoriCicilan> listhistori = serviceNameCustomer.listAllByNameCustomer(keyword);
	        model.addAttribute("listcustomer", customerrepository.findAll());
	        model.addAttribute("listproduk", displayNameProdukRepository.findAll());
	        model.addAttribute("listhistori", listhistori);
	        model.addAttribute("keyword", keyword);
	        return "HistoriSearchByNameCustomer";
	    }
		
		@RequestMapping("/histori/search/namaproduk")
		public String SearchByNameProduk(Model model, @Param("keyword") String keyword) {
	        List<HistoriCicilan> listhistori = ServiceNamaProduk.listAllByNameProduk(keyword);
	        model.addAttribute("listcustomer", customerrepository.findAll());
	        model.addAttribute("listproduk", produkrepositoryForSearch.findAll());
	        model.addAttribute("listhistori", listhistori);
	        model.addAttribute("keyword", keyword);
	        return "HistoriSearchByNameProduk";
	    }
	
	
	  		
}
