package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.test.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
//	for using native query we can use @query annotation and also jpql
//	jpql query
	@Query("select u from User u where u.name =:n")
	public List<User> getUserByName(@Param ("n") String name);
	
	
//	native query
	@Query(value="select * from user",nativeQuery=true)
	List<User> getUsers();

}
