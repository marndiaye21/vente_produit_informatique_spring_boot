package sn.usher21.helloapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.usher21.helloapp.models.Unit;

public interface UnitRepository extends JpaRepository<Unit, Long> {
    
}
