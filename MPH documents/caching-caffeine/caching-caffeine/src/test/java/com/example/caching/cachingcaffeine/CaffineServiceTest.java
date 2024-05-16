package com.example.caching.cachingcaffeine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.caching.cachingcaffeine.entity.Invoice;
import com.example.caching.cachingcaffeine.repository.InvoiceRepository;
import com.example.caching.cachingcaffeine.service.InvoiceServiceImpl;

@SpringBootTest
public class CaffineServiceTest {
	
	@Autowired
	private InvoiceServiceImpl invoiceserviceimpl;
	
	@MockBean
	private InvoiceRepository invoicerepo;
	
	
	@Test
	public void getAllInvoices() {
		Invoice invoice = new Invoice();
		invoice.setInvname("ACT");
		invoice.setInvamt(600);
		invoice.setInvid(1);
		List<Invoice> listinv = new ArrayList<>(); 
		listinv.add(invoice);
		Mockito.when(invoicerepo.findAll()).thenReturn(listinv);
		assertEquals(invoiceserviceimpl.getAllInvoices(), listinv);
	}
	
	@Test
	public void saveInvoice() {
		Invoice invoice1 = new Invoice(1 ,"ACT",600);
		Invoice invoice = new Invoice();
		invoice.setInvname("ACT");
		invoice.setInvamt(600);
		invoice.setInvid(1);
		Mockito.when(invoicerepo.save(invoice)).thenReturn(invoice);
		assertEquals(invoiceserviceimpl.saveInvoice(invoice), invoice1);
	}
	

}
