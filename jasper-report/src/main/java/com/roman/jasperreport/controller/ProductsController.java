package com.roman.jasperreport.controller;

import com.roman.jasperreport.model.Products;
import com.roman.jasperreport.service.ReportService;
import com.roman.jasperreport.serviceImpl.ProductsServiceImpl;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsServiceImpl productsServiceimpl;

    @Autowired
    private ReportService reportService;

    @PostMapping("/add")
    public void addProduct(@RequestBody Products p){
        productsServiceimpl.addProduct(p);
    }

    @GetMapping("/all")
    public List<Products> productsList(){
        return productsServiceimpl.getAllProducts();
    }

    @GetMapping("/report/{format}")
    public String createReport(@PathVariable String format) throws JRException, FileNotFoundException {
        return reportService.exportReport(format);
    }

}
