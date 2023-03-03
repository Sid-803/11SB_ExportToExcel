package com.tutorial.document.excelExport.service;

import com.tutorial.document.excelExport.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceService {

    List<Invoice> getInvoices();
}
