package ru.itis.kpfu.hateoasrest.supermarket.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Basket {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(
            mappedBy = "basket"
    )
    private List<Product> products;
    @ManyToOne
    @JoinColumn(
            name = "supermarket_id"
    )
    private Supermarket supermarket;
    @ManyToOne
    @JoinColumn(
            name = "buyer_id"
    )
    private Buyer buyer;

}

