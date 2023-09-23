package sn.usher21.helloapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.usher21.helloapp.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
