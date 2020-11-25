package com.springReact.serverproductmanagement.model;

import lombok.Data;

import javax.persistence.*;

@Data // for getter, setter, equals  ...
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "explanation")
    private String explanation;
}
