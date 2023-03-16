package com.example.test1.domenModel;
import com.example.test1.domenModel.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customer_id;
    private int store_id;
    private String first_name;
    private String last_name;
    private String email;

  /*@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id",referencedColumnName = "address_id",nullable=false,unique=true)  */
    //private Address address;

    private int address_id;
    private int active;

}
