package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.entity.Weights;
import com.example.repository.UserRepository;
import com.example.repository.WeightsRepository;
import com.example.service.UsersService;



@RequestMapping
@RestController
public class WeightController {

	@Autowired
	UsersService usersService;
	
	@PostMapping("/add/weight")
	public ResponseEntity<Object> addWeight(@RequestBody Weights weights) {
		usersService.addWeight(weights);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping("/check/weights")
	public List<Weights> getAllWeight(){
		return usersService.getAllWeight();
	}
	
	@DeleteMapping("/delete/weight/{id}")
	public ResponseEntity<Object> deleteWeight(@PathVariable int id){
		usersService.deleteWeight(id);
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	
	}
}
