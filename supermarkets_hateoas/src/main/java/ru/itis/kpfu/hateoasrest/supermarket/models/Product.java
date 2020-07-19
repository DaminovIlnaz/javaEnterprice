package ru.itis.kpfu.hateoasrest.supermarket.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer price;
    @ManyToOne
    @JoinColumn(
            name = "supermarket_id"
    )
    private Supermarket supermarket;
    @ManyToOne
    @JoinColumn(
            name = "basket_id"
    )
    private Basket basket;


}