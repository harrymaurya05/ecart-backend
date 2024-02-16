package github.io.iamhariommaurya.ecart.reviewService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private float price;

    public long getId() {
        return id;
    }

    public Review setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Review setName(String name) {
        this.name = name;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public Review setPrice(float price) {
        this.price = price;
        return this;
    }
}
