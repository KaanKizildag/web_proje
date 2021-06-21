/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webprogramlama.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import webprogramlama.demo.entity.product.Product;
import webprogramlama.demo.service.abstracts.ProductService;

/**
 *
 * @author kaan
 */
@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/getByNameConstains")
    public List<Product> getByNameContains(@RequestParam String name) {
        return service.getByProductNameContains(name);
    }

    @PostMapping("/add")
    public void add(@RequestBody Product product) {
        service.insert(product);
    }

    @GetMapping("/getById")
    public Product getById(@RequestParam int id) {
        return service.getById(id);
    }
    
    @GetMapping("/getByCustomer_Id")
    public List<Product> getByCustomer_Id(@RequestParam int customerId){
        return service.getByCustomer_Id(customerId);
    }
}
