package sn.usher21.helloapp.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import sn.usher21.helloapp.models.Product;
import sn.usher21.helloapp.models.Succursale;

@Data
@Builder
public class SuccursaleDto {

    private Long id;
    private int reduction;
    private String phone;
    private String address;
    @JsonIgnore
    private List<SuccursaleDto> friends;
    @JsonIgnore
    private List<Product> products;

    public static SuccursaleDto fromSuccursale(Succursale succursale) {
        return SuccursaleDto.builder()
                .id(succursale.getId())
                .reduction(succursale.getReduction())
                .phone(succursale.getPhone())
                .address(succursale.getAddress())
                .build();
    }

    public static Succursale toSuccursale(SuccursaleDto succursaleDto) {
        return Succursale.builder()
                .id(succursaleDto.getId())
                .reduction(succursaleDto.getReduction())
                .phone(succursaleDto.getPhone())
                .address(succursaleDto.getAddress())
                .build();
    }
}
