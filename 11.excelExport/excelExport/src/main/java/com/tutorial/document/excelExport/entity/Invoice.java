package com.tutorial.document.excelExport.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="invoice_id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="location")
    private String location;

    @Column(name="amount")
    private Double amount;

}
