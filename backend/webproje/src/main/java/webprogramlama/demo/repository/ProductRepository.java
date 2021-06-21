/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webprogramlama.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import webprogramlama.demo.entity.product.Product;

/**
 *
 * @author kaan
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Burada getBy ile başlayan metodlar spring tarafından tanınır
    // ve sonrasında gelen değere göre filtreleme yapacağını anlar
    // yani query anotasyonuyla yazmamıza gerek kalmaz
    List<Product> getByCustomer_Id(int customerId);

    Product getById(int productId);

    List<Product> getByNameContains(String productName);

    // Query anotasyonunu da kullan DTO yazılabilir (!)
}
