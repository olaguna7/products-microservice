package com.oscar.productsmicroservice.service;

import com.oscar.productsmicroservice.dto.ProductDTO;
import com.oscar.productsmicroservice.entity.Product;
import com.oscar.productsmicroservice.mapper.ProductMapper;
import com.oscar.productsmicroservice.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Product createProduct(ProductDTO productDTO) {
        return productRepository.save(productMapper.toEntity(productDTO));
    }

    public List<ProductDTO> findAll() {
        return productMapper.toDtoList(productRepository.findAll());
    }

    public ProductDTO findById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(EntityNotFoundException::new);
        return productMapper.toDto(product);
    }

    public Product modifyProduct(Long productId, ProductDTO productDTO) {
        Product product = productRepository.findById(productId).orElseThrow(EntityNotFoundException::new);
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        return productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

}
