package com.roman.jasperreport.service;

import com.roman.jasperreport.model.Products;

import java.util.List;


public interface ProductsService {
    void addProduct(Products p);
    List<Products> getAllProducts();
}
