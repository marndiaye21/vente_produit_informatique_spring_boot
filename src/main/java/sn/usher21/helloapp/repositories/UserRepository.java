package sn.usher21.helloapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.usher21.helloapp.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
