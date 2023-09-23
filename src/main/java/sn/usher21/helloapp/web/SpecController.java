package sn.usher21.helloapp.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sn.usher21.helloapp.models.Specification;
import sn.usher21.helloapp.services.SpecServiceImpl;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/specs")
public class SpecController {
    
    SpecServiceImpl specServiceImpl;

    @GetMapping("")
    public List<Specification> getSpecifications() {
        return this.specServiceImpl.getSpecs();
    }

    @PostMapping("")
    public Specification saveSpecification(@RequestBody Specification specification) {
        return this.specServiceImpl.saveSpec(specification);
    }
}
