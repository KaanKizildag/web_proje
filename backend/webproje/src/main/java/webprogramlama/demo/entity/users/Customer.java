/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webprogramlama.demo.entity.users;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;
import lombok.Data;
import webprogramlama.demo.entity.product.Product;

/**
 *
 * @author kaan
 */
@Entity
@Data
@PrimaryKeyJoinColumn(name = "id")
public class Customer extends User{

    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "address")
    private String address;

    @Column(name = "debt")
    private float debt;

    @OneToMany(mappedBy = "customer")
    @Column(name = "products")
    List<Product> products = new ArrayList<Product>();

}
