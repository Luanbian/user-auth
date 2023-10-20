package users.usermanagement.data.usecases.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.usermanagement.main.entities.Product;
import users.usermanagement.infra.repository.ProductRepository;

import java.util.List;
@Service
public class GetProducts {
    @Autowired
    private ProductRepository repository;

    public List<Product> perform () {
        List<Product> products = repository.findAll();
        return products;
    }
}
