package com.example.test1.domenModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import com.example.test1.domenModel.Customer;
import javax.persistence.*;
import java.io.Serializable;


@Entity

@Data
@Table(name="address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer address_id;
    private String address;
    private String address2;
    private Integer city_id;
    private String postal_code;
    private String phone;

    //@OneToOne(cascade=CascadeType.ALL, mappedBy="address")

    //private Customer customer;

}
