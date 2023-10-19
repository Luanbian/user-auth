package users.usermanagement.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import users.usermanagement.data.usecases.CreateProduct;
import users.usermanagement.domain.dtos.RequestProduct;
import users.usermanagement.entities.Product;

@RestController()
@RequestMapping("api/product")
public class ProductController {

    private final CreateProduct createProduct;

    @Autowired
    public ProductController (CreateProduct createProduct) {
        this.createProduct = createProduct;
    }

    @PostMapping
    public ResponseEntity createProduct (@RequestBody @Valid RequestProduct data) {
        Product newProduct = createProduct.perform(data);
        return ResponseEntity.ok(newProduct);
    }

    @GetMapping
    public ResponseEntity getProducts () {
        return ResponseEntity.ok("deu certo");
    }
}
