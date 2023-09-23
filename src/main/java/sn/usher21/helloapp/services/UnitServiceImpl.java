package sn.usher21.helloapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sn.usher21.helloapp.models.Unit;
import sn.usher21.helloapp.repositories.UnitRepository;

@AllArgsConstructor
@Service
public class UnitServiceImpl implements UnitService {

    private UnitRepository unitRepository;

    @Override
    public List<Unit> getUnits() {
        return this.unitRepository.findAll();
    }

    @Override
    public Unit saveUnit(Unit unit) {
        return this.unitRepository.save(unit);
    }
}
