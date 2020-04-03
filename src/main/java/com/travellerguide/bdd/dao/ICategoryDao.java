package com.travellerguide.bdd.dao;

import com.travellerguide.bdd.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryDao extends JpaRepository<Category, Integer> {
}
