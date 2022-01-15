package com.jpa.test;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootjpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaExampleApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
//User user1 = new User();
//user1.setCity("mumbai");
//user1.setName("umar shaikh");
//user1.setStatus("i am a programmer");
//
		User user2 = new User();
		user2.setCity("mumbai");
		user2.setName("umar shaikh");
		user2.setStatus("i am a programmer");
		userRepository.save(user2);

//List<User> list = List.of(user1,user2);
//save multiple objects
// Iterable<User> resultSet = userRepository.saveAll(list);
// resultSet.forEach(user->{
//	 System.out.println(user);
// }
// );
//System.out.println(user1);

//update the user id of 1

//Optional<User> optional =  userRepository.findById(1);
//User user = optional.get();
//user.setName("azhar");
//User result = userRepository.save(user);
//System.out.println(result);

//get the data all data
		/*
		 * Iterable<User> iterable = userRepository.findAll();
		 * iterable.forEach(user->System.out.println(user));
		 */

//to delete a specific use object we can also pass iterable(list of objects) in delete method 
//		userRepository.deleteById(1);
//		System.out.println("deleted");
		
	List<User> userByName = userRepository.getUserByName("umar");
	userByName.forEach(u->{
		System.out.println(u);
	}
	);
	
	System.out.println("_______________________________________");
	
List<User> user =	  userRepository.getUsers();
user.forEach(u ->{System.out.println(u);});

	}

}
