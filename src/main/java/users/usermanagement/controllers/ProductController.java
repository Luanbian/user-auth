package users.usermanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import users.usermanagement.data.usecases.CreateProduct;

@RestController()
@RequestMapping("api/product")
public class ProductController {

    private final CreateProduct createProduct;

    @Autowired
    public ProductController (CreateProduct createProduct) {
        this.createProduct = createProduct;
    }

    @GetMapping
    public ResponseEntity getProducts () {
        String usecase = createProduct.perform();
        return ResponseEntity.ok(usecase);
    }
}
