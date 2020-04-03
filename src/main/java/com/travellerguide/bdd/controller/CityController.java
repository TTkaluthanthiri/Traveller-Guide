package com.travellerguide.bdd.controller;

import com.travellerguide.bdd.dao.ICityDao;
import com.travellerguide.bdd.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CityController {

    ICityDao icitydao;

    @Autowired
    public CityController(ICityDao icitydao) {
        this.icitydao = icitydao;
    }

    @GetMapping("/cities")
    public List<City> getCities() {
        return icitydao.findAll();
    }
}
