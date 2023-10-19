package users.usermanagement.entities;

import jakarta.persistence.*;
import lombok.*;
import users.usermanagement.domain.dtos.RequestProduct;

@Entity(name = "product")
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Integer price_in_cents;

    private Product (RequestProduct requestProduct) {
        this.name = requestProduct.name();
        this.price_in_cents = requestProduct.price_in_cents();
    }

    public static Product create (RequestProduct requestProduct) {
        return new Product(requestProduct);
    }
}
