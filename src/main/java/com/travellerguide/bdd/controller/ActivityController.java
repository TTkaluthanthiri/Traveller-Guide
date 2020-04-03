package com.travellerguide.bdd.controller;

import com.travellerguide.bdd.dao.IActivityDao;
import com.travellerguide.bdd.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
public class ActivityController {

    IActivityDao iactivitydao;

    @Autowired
    public ActivityController(IActivityDao iactivitydao) {
        this.iactivitydao = iactivitydao;
    }

    @GetMapping("/activites")
    public List<Activity> getActivities() {
        return iactivitydao.findAll();
    }
}
