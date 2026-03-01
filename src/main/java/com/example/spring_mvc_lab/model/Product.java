package com.example.spring_mvc_lab.model;

public class Product {
    private Long id;
    private String name;
    private String category;
    private Double price;
    private Integer stock; // 1. Tambahkan variabel stock

    // 2. Tambahkan stock ke dalam Constructor
    public Product(Long id, String name, String category, Double price, Integer stock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public Double getPrice() { return price; }

    // 3. Tambahkan Getter untuk stock
    public Integer getStock() { return stock; }
}