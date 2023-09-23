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
@Table(name = "products_succursale")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
public class ProductSuccursale extends AbstractEntity {
    
    private int quantity;

    @Column(name = "unit_price")
    private int unitPrice; // prix détail

    @Column(name =  "whole_sale_price")
    private int wholeSalePrice; // prix en gros

    @ManyToOne
    @JoinColumn(name = "succursale_id")
    @JsonIgnore
    private Succursale succursale;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    public ProductSuccursale(
        LocalDateTime createdAt, LocalDateTime updatedAt,
        int quantity, int unitPrice, int wholeSalePrice,
        Succursale succursale, Product product
    ) {
        super(null, createdAt, updatedAt);
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.wholeSalePrice = wholeSalePrice;
        this.succursale = succursale;
        this.product = product;
    }
}
