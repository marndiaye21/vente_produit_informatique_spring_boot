package sn.usher21.helloapp.services;

import java.util.List;

import sn.usher21.helloapp.models.Succursale;

public interface SuccursaleService {
    public List<Succursale> getSuccursales();
    public Succursale saveSuccursale(Succursale succursale);
}
