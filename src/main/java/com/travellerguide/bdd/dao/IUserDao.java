package com.travellerguide.bdd.dao;

import com.travellerguide.bdd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JpaRepostiry<Model,Type_of_primary_key>
@Repository //injection de dépendance, cf Bansept PDF.
public interface IUserDao extends JpaRepository<User, Integer> {
}
