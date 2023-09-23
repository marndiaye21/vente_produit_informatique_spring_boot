package sn.usher21.helloapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.usher21.helloapp.models.ProductSuccursale;

public interface ProductSuccursaleRepository extends JpaRepository<ProductSuccursale, Long> {
    
}
