package users.usermanagement.data.usecases;

import org.springframework.stereotype.Service;
import users.usermanagement.domain.dtos.RequestProduct;
import users.usermanagement.entities.Product;

@Service
public class CreateProduct {
    public Product perform (RequestProduct data) {
        Product product = Product.create(data);
        return product;
    }
}
