package users.usermanagement.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import users.usermanagement.main.entities.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}
