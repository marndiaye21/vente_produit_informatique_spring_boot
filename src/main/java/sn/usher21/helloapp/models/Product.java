package sn.usher21.helloapp.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "products")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Product extends AbstractEntity {
    
    @Column(unique = true)
    private String label;

    private String marque;

    @Column(unique = true)
    private String code;

    private String description;

    @ManyToMany()
    @JoinTable(
        name = "products_succursale",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "succursale_id")
    )
    private List<Succursale> succursales;

    @ManyToMany()
    @JoinTable(
        name = "product_specs",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "spec_id")
    )
    private List<Specification> specifications;

    public Product(
        LocalDateTime createdAt, LocalDateTime updatedAt,
        String label, String code, String description,
        List<Succursale> succursales, List<Specification> specifications
    ) {
        super(null, createdAt, updatedAt);
        this.label = label;
        this.code = code;
        this.description = description;
        this.succursales = succursales;
        this.specifications = specifications;
    }
}
