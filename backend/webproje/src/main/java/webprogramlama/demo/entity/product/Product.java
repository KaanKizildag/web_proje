/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webprogramlama.demo.entity.product;

import webprogramlama.demo.entity.users.Customer;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;


/**
 *
 * @author kaan
 */
@Entity
@Data // lombok kullanarak getter ve setter yazmaktan kurtuluyorum.
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "price")
    private double price;
    
    @ManyToOne
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    
}
