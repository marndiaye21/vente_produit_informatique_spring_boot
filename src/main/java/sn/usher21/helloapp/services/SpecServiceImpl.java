package sn.usher21.helloapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sn.usher21.helloapp.models.Specification;
import sn.usher21.helloapp.repositories.SpecRepository;

@AllArgsConstructor
@Service
public class SpecServiceImpl implements SpecService {

    SpecRepository specRepository;

    @Override
    public List<Specification> getSpecs() {
        return specRepository.findAll();
    }

    @Override
    public Specification saveSpec(Specification specification) {
        return specRepository.save(specification);
    }
}
