package users.usermanagement.data.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.usermanagement.entities.Product;
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
