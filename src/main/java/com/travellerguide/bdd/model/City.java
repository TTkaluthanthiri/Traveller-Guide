package com.travellerguide.bdd.model;



import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "city")
@EntityListeners(AuditingEntityListener.class)
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="cityName", nullable = false)
    private String cityName;

    @Column(name="countryName", nullable = false)
    private String countryName;

    @Column(name="pictureURL")
    private String pictureURL;

    @OneToMany(mappedBy = "city")
    Set<Activity> listActivity = new TreeSet<>();


    public City() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public Set<Activity> getListActivity() {
        return listActivity;
    }

    public void setListActivity(Set<Activity> listActivity) {
        this.listActivity = listActivity;
    }


}
