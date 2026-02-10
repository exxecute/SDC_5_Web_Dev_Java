package com.webdev.sdc.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bank")
public class BankEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private List<CurrencyEntity> currencies = new ArrayList<>();

    public BankEntity() {}

    public BankEntity(String name) {
        this.name = name;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<CurrencyEntity> getCurrencies() { return currencies; }
    public void setCurrencies(List<CurrencyEntity> currencies) { this.currencies = currencies; }

    public void setId(Long id) {this.id = id;}
}
