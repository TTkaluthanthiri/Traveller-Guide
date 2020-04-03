package com.travellerguide.bdd.model;


import com.travellerguide.bdd.model.Enums.Budget;
import com.travellerguide.bdd.model.Enums.TimePeriod;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "activity")
@EntityListeners(AuditingEntityListener.class)
public class Activity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Enumerated
    @Column(columnDefinition = "ENUM('MORNING', 'MIDDAY', 'AFTERNOON', 'EVENING', 'NIGHT')")
    private TimePeriod timeperiod;

    @Enumerated
    @Column(columnDefinition = "ENUM('€', '€€', '€€€')")
    private Budget budget;

    @Column(name = "openingTimes")
    private String openingTimes;

    @Column(name = "pictureURL")
    private String pictureURL;

    @ManyToOne
    @JoinColumn(name ="id_city", nullable = false)
    private City city;

    @ManyToMany(/*fetch = FetchType.EAGER,*/ mappedBy = "listActivities", cascade = CascadeType.ALL)
    private Set<Category> listCategories;

    public Activity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public TimePeriod getTimeperiod() {
        return timeperiod;
    }

    public void setTimeperiod(TimePeriod timeperiod) {
        this.timeperiod = timeperiod;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public String getOpeningTimes() {
        return openingTimes;
    }

    public void setOpeningTimes(String openingTimes) {
        this.openingTimes = openingTimes;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Category> getListCategories() {
        return listCategories;
    }

    public void setListCategories(Set<Category> listCategories) {
        this.listCategories = listCategories;
    }
}
