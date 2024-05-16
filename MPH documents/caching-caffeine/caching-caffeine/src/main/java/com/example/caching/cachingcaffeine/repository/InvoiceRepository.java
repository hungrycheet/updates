package com.example.caching.cachingcaffeine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.caching.cachingcaffeine.entity.Invoice;

@Repository
public interface InvoiceRepository  extends JpaRepository<Invoice, Integer>{

}
