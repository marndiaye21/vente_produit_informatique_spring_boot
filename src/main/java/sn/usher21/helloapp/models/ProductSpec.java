package sn.usher21.helloapp.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "product_specs")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProductSpec extends AbstractEntity {

    @Column(length = 1000)
    private String value;
    private String description;

    @ManyToOne()
    @JoinColumn(name = "spec_id")
    @JsonIgnore
    private Specification specification;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    @ManyToOne
    @JoinColumn(name = "unit_id", nullable = true)
    private Unit unit;

    public ProductSpec(
            LocalDateTime createdAt, LocalDateTime updatedAt,
            String value, String description,
            Specification specification, Product product, Unit unit) {
        super(null, createdAt, updatedAt);
        this.value = value;
        this.description = description;
        this.specification = specification;
        this.product = product;
        this.unit = unit;
    }
}
