package sn.usher21.helloapp.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import sn.usher21.helloapp.models.Product;
import sn.usher21.helloapp.models.Specification;
import sn.usher21.helloapp.models.Succursale;

@Data
@Builder
public class ProductDto {

    private Long id;
    private String label;
    private String code;
    private String description;

    @JsonIgnore
    private List<Succursale> succursales;
    @JsonIgnore
    private List<Specification> specifications;

    public static ProductDto fromProduct(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .label(product.getLabel())
                .code(product.getCode())
                .description(product.getDescription())
                .build();
    }

    public static Product toProduct(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .label(productDto.getLabel())
                .code(productDto.getCode())
                .description(productDto.getDescription())
                .build();
    }
}
