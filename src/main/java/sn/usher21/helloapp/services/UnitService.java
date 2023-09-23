package sn.usher21.helloapp.services;

import java.util.List;

import sn.usher21.helloapp.models.Unit;

public interface UnitService {
    public List<Unit> getUnits();
    public Unit saveUnit(Unit unit);
}
