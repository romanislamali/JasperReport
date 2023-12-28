package com.roman.jasperreport.controller;

import com.roman.jasperreport.model.Products;
import com.roman.jasperreport.serviceImpl.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsServiceImpl productsServiceimpl;

    @PostMapping("/add")
    public void addProduct(@RequestBody Products p){
        productsServiceimpl.addProduct(p);
    }

    @GetMapping("/all")
    public List<Products> productsList(){
        return productsServiceimpl.getAllProducts();
    }

}
