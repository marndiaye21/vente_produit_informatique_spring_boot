package sn.usher21.helloapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sn.usher21.helloapp.models.Succursale;
import sn.usher21.helloapp.repositories.SuccursaleRepository;

@Service
@AllArgsConstructor
public class SuccursaleServiceImpl implements SuccursaleService {

    SuccursaleRepository succursaleRepository;

    @Override
    public List<Succursale> getSuccursales() {
        return this.succursaleRepository.findAll();
    }

    @Override
    public Succursale saveSuccursale(Succursale succursale) {
        return this.succursaleRepository.save(succursale);
    }
}
