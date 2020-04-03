package com.travellerguide.bdd.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
@EntityListeners(AuditingEntityListener.class)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="type", nullable = false)
    private String type;

    @ManyToMany(/*fetch = FetchType.EAGER,*/ cascade = CascadeType.ALL)
    @JoinTable(
            name = "activity_category",
            joinColumns = @JoinColumn(name = "id_activity", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_category", nullable = false)
            )
    private Set<Activity> listActivities;

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Activity> getListActivities() {
        return listActivities;
    }

    public void setListActivities(Set<Activity> listActivities) {
        this.listActivities = listActivities;
    }

}
