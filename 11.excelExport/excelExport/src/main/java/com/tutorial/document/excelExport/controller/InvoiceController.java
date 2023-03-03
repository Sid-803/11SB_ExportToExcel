package com.tutorial.document.excelExport.controller;

import com.tutorial.document.excelExport.ExcelUtil.InvoiceExcelDataExport;
import com.tutorial.document.excelExport.entity.Invoice;
import com.tutorial.document.excelExport.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/invoices")
    public ResponseEntity<List<Invoice>> getInvoices(){
        return ResponseEntity.ok(invoiceService.getInvoices());
    }

    /***
     * Export data to excel file
     */
    @GetMapping("/excelExport")
    public ModelAndView exportToExcel() {
        ModelAndView mav = new ModelAndView();
        //set the view Java class
        mav.setView(new InvoiceExcelDataExport());
        //read data from DB which is to be populated in out view as "list"
        List<Invoice> list= invoiceService.getInvoices();
        //send to excelImpl class
        mav.addObject("list", list);
        return mav;
    }
}
