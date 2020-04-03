package com.travellerguide.bdd.controller;

import com.travellerguide.bdd.dao.IUserDao;
import com.travellerguide.bdd.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //déclaration d'un controlleur de type web service (renvoie un JSON)
@CrossOrigin //permet le cross origin
public class UserController {

    /*****************************
     * Link DAO & Controller     *
     * (injection dependence     *
     * ou inversion de contrôle) *
     *****************************/

    IUserDao iuserdao; //dao en attribut


    //constructeur avec le dao en param
    @Autowired
    public UserController(IUserDao iuserdao) {
        this.iuserdao = iuserdao;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return iuserdao.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        return iuserdao.findById(id).orElse(null);
    }
}
