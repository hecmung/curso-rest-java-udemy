package com.curso.rest.repositoy;

import com.curso.rest.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoy {

    private List<Product> products = new ArrayList<>();

    public void createProducts() {
        products = List.of(
                new Product(1L, "Product 01", 11, 101),
                new Product(2L, "Product 02", 12, 102),
                new Product(3L, "Product 03", 13, 103),
                new Product(4L, "Product 04", 14, 104),
                new Product(5L, "Product 05", 15, 105),
                new Product(6L, "Product 06", 16, 106),
                new Product(7L, "Product 07", 17, 107),
                new Product(8L, "Product 08", 18, 108),
                new Product(9L, "Product 09", 19, 109)
        );
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product findById(Long id) {
        return (Product) products.stream().filter(x -> x.getId() == id);
    }

    public Product save(Product product) {
        Product product1 = new Product();
        product1.setId(product.getId());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setAmount(product.getAmount());

        products.add(product1);

        return product1;
    }

    public String delete(Long id) {
        products.removeIf(x -> x.getId() == id);

        return null;
    }

    public Product update(Product product) {
        Long id = 0L;
        Product oldProduct = null;
        Product updatedProduct = new Product();
        int i;
        
        for (i = 0; i < products.size(); i++) {
            if(product.getId() == products.get(i).getId()) {
                oldProduct = product;
            }
        }

        if(oldProduct != null) {
            updatedProduct.setId(oldProduct.getId());
            updatedProduct.setName(oldProduct.getName());
            updatedProduct.setAmount(oldProduct.getAmount());
            updatedProduct.setPrice(oldProduct.getPrice());

            products.add(i, updatedProduct);
        }

        return oldProduct;
    }
}
