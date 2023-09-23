package sn.usher21.helloapp.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import sn.usher21.helloapp.models.Product;
import sn.usher21.helloapp.models.ProductSpec;
import sn.usher21.helloapp.models.Specification;
import sn.usher21.helloapp.models.Unit;

@Data
@Builder
public class ProductSpecDto {

    private Long id;
    private String value;
    private String description;

    @JsonIgnore
    private Specification specification;
    @JsonIgnore
    private Product product;
    @JsonIgnore
    private Unit unit;

    public static ProductSpecDto fromProductSpec(ProductSpec productSpec) {
        return ProductSpecDto.builder()
                .id(productSpec.getId())
                .value(productSpec.getValue())
                .description(productSpec.getDescription())
                .build();
    }

    public static ProductSpec toProductSpec(ProductSpecDto productSpecDto) {
        return ProductSpec.builder()
                .id(productSpecDto.getId())
                .value(productSpecDto.getValue())
                .description(productSpecDto.getDescription())
                .build();
    }
}
