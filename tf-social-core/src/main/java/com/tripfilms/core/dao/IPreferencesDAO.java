package com.tripfilms.core.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tripfilms.core.be.Preferences;
import com.tripfilms.core.be.UserConnection;

public interface IPreferencesDAO extends CrudRepository<Preferences,Long> {
	@Query("FROM Preferences p WHERE p.mUserConnection = :pUserConnection")
	Preferences findByUserConnection(@Param("pUserConnection") UserConnection pUserConnection); 
}


