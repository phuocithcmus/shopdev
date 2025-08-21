package com.phuocnd.shopdev.entities.order;

import java.util.List;

import com.phuocnd.shopdev.entities.product.ProductEntity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int userId;

    @ManyToMany(mappedBy = "orders")
    @ToString.Exclude // Exclude products from toString to avoid infinite recursion
    private List<ProductEntity> products;
}
