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
@Table(name = "succursales")
@Data @NoArgsConstructor @AllArgsConstructor
@SuperBuilder
public class Succursale extends AbstractEntity {
    
    private int reduction;

    @Column(unique = true)
    private String phone;
    private String address;

    @OneToMany(mappedBy = "succursale")
    private List<SuccursaleFriends> friendships;

    @OneToMany(mappedBy = "friend")
    private List<SuccursaleFriends> friendOf;

    @ManyToMany(mappedBy = "succursales")
    @JsonIgnore
    private List<Product> products;

    @OneToMany(mappedBy = "succursale")
    private List<ProductSuccursale> productSuccursale;

    public Succursale(
        LocalDateTime createdAt, LocalDateTime updatedAt,
        int reduction, String phone, String address,
        List<SuccursaleFriends> friendships, List<SuccursaleFriends> friendOf, List<Product> products
    ) {
        super(null, createdAt, updatedAt);
        this.reduction = reduction;
        this.phone = phone;
        this.address = address;
        this.friendships = friendships;
        this.friendOf = friendOf;
        this.products = products;
    }
}
