/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webprogramlama.demo.service.concrete;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webprogramlama.demo.entity.product.Product;
import webprogramlama.demo.repository.ProductRepository;
import webprogramlama.demo.service.abstracts.ProductService;

/**
 *
 * @author kaan
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }
    
    @Override
    public List<Product> getByCustomer_Id(int customerId) {
        return repository.getByCustomer_Id(customerId);
    }
    
    @Override
    public Product getById(int productId) {
        return repository.getById(productId);
    }
    
    @Override
    public List<Product> getByProductNameContains(String productName) {
        return repository.getByNameContains(productName);
    }

    @Override
    public void insert(Product product) {
        repository.save(product);
    }

    @Override
    public void delete(Product product) {
        repository.delete(product);
    }

}
