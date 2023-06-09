package com.curso.rest.service;

import com.curso.rest.model.Product;
import com.curso.rest.repositoy.ProductRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepositoy productRepositoy;

    public Product save(Product product) {
        return productRepositoy.save(product);
    }

    public List<Product> getAllProducts() {
        productRepositoy.createProducts();
        return productRepositoy.getAllProducts();
    }

    public Product findById(Long id) {
        productRepositoy.createProducts();
        return productRepositoy.findById(id);
    }

    public String delete(Long id) {
        return productRepositoy.delete(id);
    }

    public Product update(Product product) {
        return productRepositoy.update(product);
    }

}
