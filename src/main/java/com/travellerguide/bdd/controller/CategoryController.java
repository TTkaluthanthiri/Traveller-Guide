package com.travellerguide.bdd.controller;

import com.travellerguide.bdd.dao.ICategoryDao;
import com.travellerguide.bdd.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CategoryController {

    ICategoryDao icategorydao;

    @Autowired
    public CategoryController(ICategoryDao icategorydao) {
        this.icategorydao = icategorydao;
    }

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return icategorydao.findAll();
    }
}
