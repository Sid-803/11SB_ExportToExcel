package com.tutorial.document.excelExport.serviceImpl;

import com.tutorial.document.excelExport.entity.Invoice;
import com.tutorial.document.excelExport.repository.InvoiceRepository;
import com.tutorial.document.excelExport.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> getInvoices() {
        return invoiceRepository.findAll();
    }

}
