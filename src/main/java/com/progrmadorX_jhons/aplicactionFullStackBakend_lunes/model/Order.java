package com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User customer;

    @JsonIgnore
    @ManyToOne
    private Restaurant restaurant;

    private Long totalAmount; // total monto

    private String orderStatus; //orden de cadena

    private Date createdAt; //fecha de creacion

    @ManyToOne
    private Address deliviryAddress;

    @OneToMany //muchos articulos tienes el mismo orden
    private List<OrderItem> items;

    //esto es metodo del pago despue slo activaremos
    //private Payment payment
    private int totalItem;

    private Long totalPrice;
}
