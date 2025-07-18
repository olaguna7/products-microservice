package com.oscar.productsmicroservice.controller;

import com.oscar.productsmicroservice.dto.ProductDTO;
import com.oscar.productsmicroservice.entity.Product;
import com.oscar.productsmicroservice.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Tag(name = "create")
    @Tag(name = "post-product")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true)
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO) {
        Product product = productService.createProduct(productDTO);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @Tag(name = "find")
    @Tag(name = "get-all-products")
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.findAll();
    }

    @Tag(name = "find")
    @Tag(name = "get-product")
    @GetMapping("/{productId}")
    public ProductDTO getProductById(@PathVariable Long productId) {
        return productService.findById(productId);
    }

    @Tag(name = "delete")
    @Tag(name = "delete-product")
    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

    @Tag(name = "update")
    @Tag(name = "put-product")
    @PutMapping("/{productId}")
    public Product modifyProduct(@PathVariable Long productId, @RequestBody ProductDTO productDTO) {
        return productService.modifyProduct(productId, productDTO);
    }

}
