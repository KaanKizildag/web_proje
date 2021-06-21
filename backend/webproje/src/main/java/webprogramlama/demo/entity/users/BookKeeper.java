/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webprogramlama.demo.entity.users;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author kaan
 */
// Muhasebeci
@Entity
@Data
@PrimaryKeyJoinColumn(name = "id") // User tablosunun id kolonu
public class BookKeeper extends User{
    
    @NotNull
    private String name;

    @NotNull
    private float salary;
    
    @NotNull
    private String employeeNumber;
}
