package sn.usher21.helloapp.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "units")
public class Unit extends AbstractEntity {
    
    @Column(unique = true)
    private String label;

    public Unit(LocalDateTime createdAt, LocalDateTime updatedAt, String label) {
        super(null, createdAt, updatedAt);
        this.label = label;
    }
}
