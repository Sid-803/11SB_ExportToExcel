package com.tutorial.document.excelExport.ExcelUtil;

import com.tutorial.document.excelExport.entity.Invoice;
import com.tutorial.document.excelExport.service.InvoiceService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import java.util.List;
import java.util.Map;

public class InvoiceExcelDataExport extends AbstractXlsxView {

    @Autowired
    private InvoiceService invoiceService;

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      Workbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        //define excel file to be exported
        response.addHeader("Content-Disposition","attachment;filename=InvoiceData.xlsx");

        //read data all invoices
        List<Invoice> list = (List<Invoice>) model.get("list");

        //Create worksheet object
        Sheet sh = workbook.createSheet("Invoice");

        //Header row
        Row row = sh.createRow(0);
        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("NAME");
        row.createCell(2).setCellValue("LOCATION");
        row.createCell(3).setCellValue("AMOUNT");

        //create row1 onwards from List<T>
        Integer rowNumber = 1;
        for(Invoice inv:list){
            Row rowNew = sh.createRow(rowNumber++);
            rowNew.createCell(0).setCellValue(inv.getId());
            rowNew.createCell(1).setCellValue(inv.getName());
            rowNew.createCell(2).setCellValue(inv.getLocation());
            rowNew.createCell(3).setCellValue(inv.getAmount());
        }
    }
}
