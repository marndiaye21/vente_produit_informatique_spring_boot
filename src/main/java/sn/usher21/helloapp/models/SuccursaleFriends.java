package sn.usher21.helloapp.models;

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
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "succursale_friends")
public class SuccursaleFriends extends AbstractEntity {

    @ManyToOne()
    @JoinColumn(name = "friend_id")
    private Succursale friend;

    @ManyToOne()
    @JoinColumn(name = "succursale_id")
    private Succursale succursale;

    private boolean accepted;
}
