package com.tutorial.document.excelExport.repository;

import com.tutorial.document.excelExport.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}
