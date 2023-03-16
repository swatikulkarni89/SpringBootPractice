package com.example.test1.domenModel;

import lombok.*;

import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor

@Data
@Builder
@AllArgsConstructor
public class CustomerAddress {
    private String first_name;
    private String last_name;
    private int active;
    private String email;
    private int address_id;
    private String address;
    private String address2;
    private Integer city_id;
    private String postal_code;

}
