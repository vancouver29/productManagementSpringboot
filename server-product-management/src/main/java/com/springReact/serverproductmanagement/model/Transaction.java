package com.springReact.serverproductmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data // for setter, getter, equals
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;
}
