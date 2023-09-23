package sn.usher21.helloapp.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sn.usher21.helloapp.models.Unit;
import sn.usher21.helloapp.services.UnitServiceImpl;

@RestController
@RequestMapping(path = "/api/units")
@AllArgsConstructor
public class UnitController {
    
    private UnitServiceImpl unitServiceImpl;

    @GetMapping("")
    public List<Unit> allUnits() {
        return unitServiceImpl.getUnits();
    }

    @PostMapping("")
    public Unit addUnit(@RequestBody Unit unit) {
        return unitServiceImpl.saveUnit(unit);
    }
}
