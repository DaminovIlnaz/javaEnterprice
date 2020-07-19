package ru.itis.kpfu.hateoasrest.supermarket.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Supermarket {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    @OneToMany(
            mappedBy = "supermarket"
    )
    private List<Product> products;
    @OneToMany(
            mappedBy = "supermarket"
    )
    private List<Basket> baskets;
    @OneToOne
    private Seller seller;
    private String state;

    public void publish() {
        if (this.state.equals("Draft")) {
            this.state = "Open";
        } else if (this.state.equals("Closed")) {
            throw new IllegalStateException();
        }

    }

}

