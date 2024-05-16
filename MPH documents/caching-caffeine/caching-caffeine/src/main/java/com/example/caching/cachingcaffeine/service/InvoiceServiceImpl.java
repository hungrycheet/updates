package com.example.caching.cachingcaffeine.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.caching.cachingcaffeine.entity.Invoice;
import com.example.caching.cachingcaffeine.repository.InvoiceRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@CacheConfig(cacheNames = {"invoices"})
public class InvoiceServiceImpl {

	@Autowired
	private InvoiceRepository invoicerepo;
	
	@Autowired
	private CacheManager cachemanager;


	public Invoice saveInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		return invoicerepo.save(invoice);
	}
	
	//@CacheEvict(allEntries = true) 
	@CachePut(key="#id")
	public Invoice updateInvoice(int id, Invoice invoice) {
		// TODO Auto-generated method stub
		   Invoice invoice1 = invoicerepo.findById(id).get();
	       invoice1.setInvamt(invoice.getInvamt());
	       invoice1.setInvname(invoice.getInvname());
	       return invoicerepo.save(invoice1);
	}
	
	 @CacheEvict(key="#id")
	    // @CacheEvict(value="Invoice", allEntries=true) //in case there are multiple records to delete
	 public void deleteInvoice(int id) {
	       Invoice invoice = invoicerepo.findById(id).get();
	       invoicerepo.delete(invoice);
	   }

	@Cacheable
	public List<Invoice> getAllInvoices() {
		// TODO Auto-generated method stub
		List<Invoice> list=invoicerepo.findAll();
		System.out.println("service getting data from db"+list);
		try {
			Thread.sleep(1000 * 2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@CacheEvict(allEntries = true)
	@Scheduled(cron = "0 */5 * ? * *")
	public void clearCache() {
		
			log.info("clering cache"+ new Date());
	}
	
	public Collection<String> getCacheNames(){	
		return cachemanager.getCacheNames();
	}


	
}
