package com.example.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import com.example.entity.User;
import com.example.entity.Weights;
import com.example.repository.UserRepository;
import com.example.repository.WeightsRepository;

import net.bytebuddy.asm.Advice.Return;



@Service
public class UsersService {
	
	@Autowired
	WeightsRepository weightsRepository;
	
	@Autowired
	UserRepository userRepository;
	public void addUser(User user) {
		
		userRepository.save(user);
	}
	
	public List<User> getAllUser(){
		List<User> list = new ArrayList<User>();
		userRepository.findAll().forEach(list::add);
		return list;
	}
	
	
	public User getUser( int id){
		return userRepository.findById(id).get();
	}

	public void addWeight(Weights weights) {
		weightsRepository.save(weights);
		
	}

	public List<Weights> getAllWeight() {
		List<Weights> list = new ArrayList<Weights>();
		weightsRepository.findAll().forEach(list::add);
		
		return list;
	}

	public void deleteWeight(int id) {
		
		try {
			weightsRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			 throw new ResponseStatusException(
			          HttpStatus.BAD_GATEWAY, "Actor Not Found", e);
		}
			
			
	
			
	}

	
}

