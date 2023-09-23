package sn.usher21.helloapp.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import sn.usher21.helloapp.models.Product;
import sn.usher21.helloapp.models.Specification;

@Data
@Builder
public class SpecDto {

    private Long id;
    private String label;

    @JsonIgnore
    private List<Product> products;

    public static SpecDto fromSpecification(Specification specification) {
        return SpecDto.builder()
                .id(specification.getId())
                .label(specification.getLabel())
                .build();
    }

    public static Specification toSpecification(SpecDto specDto) {
        return Specification.builder()
                .id(specDto.id)
                .label(specDto.getLabel())
                .build();
    }
}
