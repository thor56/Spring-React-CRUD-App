package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
//	create
	public User create(String firstName, String lastName, int age) {
		return userRepository.save(new User(firstName, lastName, age));
	}
	
//	Retrieve
	public List<User> getAll(){
		return userRepository.findAll();
	}
	public User getByFirstName(String firstName) {
		return userRepository.findByFirstName(firstName);
	}
//	update
	public User update(String firstName, String lastName, int age) {
		User u = userRepository.findByFirstName(firstName);
		u.setLastName(lastName);
		u.setAge(age);
		return userRepository.save(u);
	}
//	delete
	public void deleteAll() {
		userRepository.deleteAll();
	}
	public void delete(String firstName) {
		User u = userRepository.findByFirstName(firstName);
		userRepository.delete(u);
	}
}
