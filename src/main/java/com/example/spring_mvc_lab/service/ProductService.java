package com.example.spring_mvc_lab.service;

import com.example.spring_mvc_lab.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final List<Product> products = List.of(
            // Ditambahkan angka stok (contoh: 15, 50, 5, dll) di paling belakang
            new Product(1L, "Laptop", "Elektronik", 15000000.0, 15),
            new Product(2L, "Mouse", "Elektronik", 250000.0, 50),
            new Product(3L, "Meja Belajar", "Furniture", 800000.0, 5),
            new Product(4L, "Kursi Gaming", "Furniture", 2000000.0, 12),
            new Product(5L, "Buku Java", "Buku", 150000.0, 100)
    );

    public List<Product> findAll() {
        return products;
    }

    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public List<Product> findByCategory(String category) {
        return products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<Product> search(String keyword) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<String> getAllCategories() {
        return products.stream()
                .map(Product::getCategory)
                .distinct()
                .collect(Collectors.toList());
    }

    public Long countByCategory(String category) {
        return products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .count();
    }

    public Product findMostExpensive() {
        return products.stream()
                .max((a, b) -> Double.compare(a.getPrice(), b.getPrice()))
                .orElse(null);
    }

    public Product findCheapest() {
        return products.stream()
                .min((a, b) -> Double.compare(a.getPrice(), b.getPrice()))
                .orElse(null);
    }

    public Double getAveragePrice() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);
    }


    public Long countLowStock() {
        return products.stream()
                .filter(p -> p.getStock() < 10)
                .count();
    }
}