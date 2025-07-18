package com.oscar.productsmicroservice.mapper;

import com.oscar.productsmicroservice.dto.ProductDTO;
import com.oscar.productsmicroservice.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDto(Product product);

    List<ProductDTO> toDtoList(List<Product> products);

    Product toEntity(ProductDTO productDTO);

}
