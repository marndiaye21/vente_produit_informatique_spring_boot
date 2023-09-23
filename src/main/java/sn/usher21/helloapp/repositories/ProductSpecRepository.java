package sn.usher21.helloapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.usher21.helloapp.models.ProductSpec;

public interface ProductSpecRepository extends JpaRepository<ProductSpec, Long> {
    
}
