package sn.usher21.helloapp.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sn.usher21.helloapp.models.Succursale;
import sn.usher21.helloapp.services.SuccursaleServiceImpl;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/succursales")
public class SuccursaleController {
    
    SuccursaleServiceImpl succursaleServiceImpl;

    @GetMapping("")
    public List<Succursale> allSuccursales() {
        List<Succursale> succursales = this.succursaleServiceImpl.getSuccursales();
        succursales.stream().forEach(succursale -> System.out.println(succursale.getFriendships()));
        return succursales;
    }

    @PostMapping("")
    public Succursale addSuccursale(@RequestBody Succursale succursale) {
        return this.succursaleServiceImpl.saveSuccursale(succursale);
    }
}
