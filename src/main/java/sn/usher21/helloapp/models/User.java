package sn.usher21.helloapp.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Table(name = "users")
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@SuperBuilder
public class User extends AbstractEntity {

    private String fullname;

    @Column(unique = true)
    private String phone;

    private String address;

    @Column(unique = true)
    private String login;

    private String password;

    public User(LocalDateTime createdAt, LocalDateTime updatedAt, String fullname, String phone,
        String address, String login, String password) {
        super(null, createdAt, updatedAt);
        this.fullname = fullname;
        this.phone = phone;
        this.address = address;
        this.login = login;
        this.password = password;
    }
}
