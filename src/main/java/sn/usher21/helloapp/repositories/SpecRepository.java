package sn.usher21.helloapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.usher21.helloapp.models.Specification;

public interface SpecRepository extends JpaRepository<Specification, Long> {
    Specification findByLabel(String label);
}
