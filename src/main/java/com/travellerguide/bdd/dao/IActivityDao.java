package com.travellerguide.bdd.dao;

import com.travellerguide.bdd.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActivityDao extends JpaRepository<Activity, Integer> {
}
