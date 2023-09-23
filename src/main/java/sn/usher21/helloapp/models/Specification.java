package sn.usher21.helloapp.models;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "specs")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Specification extends AbstractEntity {
    
    @Column(unique = true)
    private String label;

    @ManyToMany(mappedBy = "specifications")
    @JsonIgnore
    private List<Product> products;

    @OneToMany(mappedBy = "specification")
    private List<ProductSpec> productSpecs;

    public Specification(
        LocalDateTime createdAt, LocalDateTime updatedAt,
        String label, List<Product> products
    ) {
        super(null, createdAt, updatedAt);
        this.label = label;
        this.products = products;
    }
}
