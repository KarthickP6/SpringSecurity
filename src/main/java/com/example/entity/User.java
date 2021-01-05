package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import java.util.List;


@Entity
@Table(name="USER")
public class User {

	@Id	
	private int id;
	
	@Column(name="USERNAME", unique = true)
	private String username;
	@Column(name="EMAIL")
	private String userEmail;
	@Column(name="PASSWORD")
	private String password;
	
	@OneToMany (mappedBy = "user")
	private List<Weights> weights;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public List<Weights> getWeights() {
		return weights;
	}

	public void setWeights(List<Weights> weights) {
		this.weights = weights;
	}

	public User() {
		super();
		
	}

	public User(int id, String username, String userEmail, String password, List<Weights> weights) {
		super();
		this.id = id;
		this.username = username;
		this.userEmail = userEmail;
		this.password = password;
		this.weights = weights;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", Username=" + username + ", userEmail=" + userEmail + ", password=" + password
				+ ", notes=" + weights + "]";
	}

	

}

