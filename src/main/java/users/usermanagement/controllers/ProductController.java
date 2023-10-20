package users.usermanagement.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import users.usermanagement.data.usecases.CreateProduct;
import users.usermanagement.data.usecases.GetProducts;
import users.usermanagement.domain.dtos.RequestProduct;
import users.usermanagement.entities.Product;

import java.util.List;

@RestController()
@RequestMapping("api/product")
public class ProductController {

    private final CreateProduct createProduct;
    private final GetProducts getProducts;

    @Autowired
    public ProductController (
            CreateProduct createProduct,
            GetProducts getProducts
    ) {
        this.createProduct = createProduct;
        this.getProducts = getProducts;
    }

    @PostMapping
    public ResponseEntity createProduct (@RequestBody @Valid RequestProduct data) {
        Product newProduct = createProduct.perform(data);
        return ResponseEntity.ok(newProduct);
    }

    @GetMapping
    public ResponseEntity getProducts () {
        List<Product> products = getProducts.perform();
        return ResponseEntity.ok(products);
    }
}
