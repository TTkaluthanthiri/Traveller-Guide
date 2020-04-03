package com.travellerguide.bdd.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.travellerguide.bdd.model.Enums.Budget;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

@Entity //déclarer une entité
@Table(name ="user") //lier une entité à une table
@EntityListeners(AuditingEntityListener.class) //permet de créer la table "User"
public class User {

    @Id //clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "login", nullable = false)
    private String login;


    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Enumerated(EnumType.STRING) //déclarer qu'un attribut est du type enumeration et quel type d'enum c'est
    @Column(columnDefinition = "ENUM('€', '€€', '€€€')") //dit à la colonne dans la BDD que le champ est de type enum
    private Budget budget;

    //@JsonView({MyJsonView.User.class, MyJsonCView.Category.class})
    //@Fetch(FetchMode.SUBSELECT)
    @ManyToMany(/*fetch = FetchType.EAGER,*/ cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_category",
            joinColumns = @JoinColumn(name = "id_user", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_category", nullable = false)
    )
    Set<Category> listCategories;

    public User() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public Set<Category> getListCategories() {
        return listCategories;
    }

    public void setListCategories(Set<Category> listCategories) {
        this.listCategories = listCategories;
    }
}
