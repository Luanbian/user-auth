package users.usermanagement.data.usecases.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.usermanagement.domain.dtos.RequestProduct;
import users.usermanagement.main.entities.Product;
import users.usermanagement.infra.repository.ProductRepository;

@Service
public class CreateProduct {

    @Autowired
    private ProductRepository repository;

    public Product perform (RequestProduct data) {
        Product product = Product.create(data);
        repository.save(product);
        return product;
    }
}
