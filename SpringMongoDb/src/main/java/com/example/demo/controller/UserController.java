package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/create")
	public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
		User u = userService.create(firstName, lastName, age);
		return u.toString();
	}
	
	@RequestMapping("/get")
	public User getUser(@RequestParam String firstName) {
		return userService.getByFirstName(firstName);
	}
	
	@RequestMapping("/getAll")
	public List<User> getAll() {
		return userService.getAll();
	}
	@RequestMapping("/update")
	public String update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
		User u = userService.update(firstName, lastName, age);
		return u.toString();
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam String firstName) {
		userService.delete(firstName);
		return firstName + "deleted@";
	}
	@RequestMapping("/deleteAll")
	public String deleteAll() {
		userService.deleteAll();
		return "Deleted all!";
	}
	
}
