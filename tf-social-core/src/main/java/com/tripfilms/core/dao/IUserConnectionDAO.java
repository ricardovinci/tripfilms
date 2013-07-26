package com.tripfilms.core.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tripfilms.core.be.UserConnection;

public interface IUserConnectionDAO extends CrudRepository<UserConnection,Long> {
	  @Query("FROM UserConnection p where p.mProviderUserId = :pProviderUserId")
	  UserConnection findBymUserId(@Param("pProviderUserId") String pUserId);
}
