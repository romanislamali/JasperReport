package com.roman.jasperreport.service;

import com.roman.jasperreport.model.Products;
import com.roman.jasperreport.repository.ProductsRepo;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private ProductsRepo productsRepo;
    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {

        String path = "E:\\Roman\\GitHub\\New folder\\Generated Report";
        List<Products> products = productsRepo.findAll();

        // Load file
        File file = ResourceUtils.getFile("classpath:reports/products.jrxml");

        // Compile file
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        // Connection jasper with datasource
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(products);

        // Create parameters
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Roman Islam");

        // Create printing environment
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        // Report format define for html or pdf
        if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path+"\\products.html");
        }
        if(reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\products.pdf");
        }
        return "Report generated in "+ path;
    }
}
