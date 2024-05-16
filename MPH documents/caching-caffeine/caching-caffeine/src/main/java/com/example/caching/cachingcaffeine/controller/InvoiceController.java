package com.example.caching.cachingcaffeine.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.caching.cachingcaffeine.entity.Invoice;
import com.example.caching.cachingcaffeine.service.InvoiceServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/invoice")
@Slf4j
public class InvoiceController {
	
	@Autowired
	private InvoiceServiceImpl invoiceservice;
	
	@PostMapping("/save")
	public ResponseEntity<Invoice> saveInvoice(@RequestBody Invoice invoice){
		//log.info(invoice.getInvname()+" "+invoice.getInvamt());
		log.info("data is save");
	   return new ResponseEntity<>(invoiceservice.saveInvoice(invoice),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Invoice> updateInvoice(@PathVariable("id") int id ,@RequestBody Invoice invoice ){
		log.info("data is updated");
        return new ResponseEntity<>(invoiceservice.updateInvoice(id ,invoice),HttpStatus.OK);
	}
	
	@GetMapping("/Allinvoices")
	public ResponseEntity<List<Invoice>> getAllInvoices(){
		 return new ResponseEntity<>(invoiceservice.getAllInvoices(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteInvoice(@PathVariable("id") int id){
		log.info("data is updated");
		invoiceservice.deleteInvoice(id);
        return "Invoice with id: "+id+ " Deleted !";
	}
	
	@GetMapping("/cachenames")
    public Collection<String> getCacheNames(){
		return invoiceservice.getCacheNames();
	}
	
}
