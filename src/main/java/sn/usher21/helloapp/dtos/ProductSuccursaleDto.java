package sn.usher21.helloapp.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import sn.usher21.helloapp.models.Product;
import sn.usher21.helloapp.models.ProductSuccursale;
import sn.usher21.helloapp.models.Succursale;

@Data
@Builder
public class ProductSuccursaleDto {
    
    private Long id;
    private int quantity;
    private int unitPrice;
    private int wholeSalePrice;
    @JsonIgnore
    private Succursale succursale;
    @JsonIgnore
    private Product product;

    public static ProductSuccursaleDto fromProductSuccursale(ProductSuccursale productSuccursale) {
        return ProductSuccursaleDto.builder()
                .id(productSuccursale.getId())
                .quantity(productSuccursale.getQuantity())
                .unitPrice(productSuccursale.getUnitPrice())
                .wholeSalePrice(productSuccursale.getWholeSalePrice())
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
