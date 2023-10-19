package users.usermanagement.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("api/product")
public class ProductController {
    @GetMapping
    public ResponseEntity getProducts () {
        return ResponseEntity.ok("Deu cert");
    }
}
