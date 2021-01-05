package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="WEIGHTS")
public class Weights {
	@Id
	private int id;
	@Column(name="WEIGHT", nullable = false, unique = true)
	private float weight;
	@Column(name="DATE", nullable = false, unique = true)
	private Date noteddate;
	@ManyToOne
	@JsonIgnore
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public Date getNoteddate() {
		return noteddate;
	}
	public void setNoteddate(Date noteddate) {
		this.noteddate = noteddate;
	}
	public Weights(int id, float weight, Date noteddate) {
		super();
		this.id = id;
		this.weight = weight;
		this.noteddate = noteddate;
	}
	public Weights(int id, float weight, Date noteddate,User user) {
		super();
		this.id = id;
		this.weight = weight;
		this.noteddate = noteddate;
		this.user = user;
	}
	public Weights() {
		super();
	}
	
	
	
}
