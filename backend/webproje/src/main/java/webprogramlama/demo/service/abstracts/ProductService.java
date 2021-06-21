/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webprogramlama.demo.service.abstracts;

import java.util.List;
import webprogramlama.demo.entity.product.Product;

/**
 *
 * @author kaan
 */

public interface ProductService {
    
    List<Product> getAll();
    
    List<Product> getByCustomer_Id(int customerId);

    Product getById(int productId);

    List<Product> getByProductNameContains(String productName);
    
    void insert(Product product);
    
    void delete(Product product);
}
