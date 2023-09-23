package sn.usher21.helloapp.services;

import java.util.List;

import sn.usher21.helloapp.models.Specification;

public interface SpecService {
    public List<Specification> getSpecs();
    public Specification saveSpec(Specification specification);
}
