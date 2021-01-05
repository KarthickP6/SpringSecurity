package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UsersService;


@RequestMapping
@RestController
public class UserController {
	
	@Autowired
	UsersService usersService;
	
	@PostMapping("/register")
	public ResponseEntity<String> addUser(@RequestBody User user){
		usersService.addUser(user); 
		return new ResponseEntity<String>("User registered successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/all/users")
	public List<User> getAllUser(){
		return usersService.getAllUser();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id){
		 User user = usersService.getUser(id);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	

	
}


