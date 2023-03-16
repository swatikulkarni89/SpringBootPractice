package com.example.test1.domenModel;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name="actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int actor_id;
    private String first_name;
    private String last_name;
    @Transient
    private Integer last_update;




}
