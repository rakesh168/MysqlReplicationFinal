package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//import lombok.Data;
//import lombok.EqualsAndHashCode;

@Entity
//@Data
//@EqualsAndHashCode
//@Table(name = "User")
public class User implements Serializable {
	private static final long serialVersionUID = 4424065644449355414L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true) 
	private String name;

	@Column(nullable = false)
	private String password;

	public User() {
    }
	
	public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
    public String toString() {
        return "User{id" + id  +
                ", name='" + name + '\'' +
                ", password=" + password +
                '}';
    }
}
