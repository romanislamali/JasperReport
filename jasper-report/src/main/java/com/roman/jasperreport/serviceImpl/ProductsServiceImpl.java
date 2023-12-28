package com.roman.jasperreport.serviceImpl;

import com.roman.jasperreport.model.Products;
import com.roman.jasperreport.repository.ProductsRepo;
import com.roman.jasperreport.service.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductsServiceImpl implements ProductsService {

    private ProductsRepo productsRepo;

    @Override
    public void addProduct(Products p) {
        productsRepo.save(p);
    }

    @Override
    public List<Products> getAllProducts() {
        return productsRepo.findAll();
    }

}
