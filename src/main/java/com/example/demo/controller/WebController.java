package com.example.demo.controller;


import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

 
@RestController
public class WebController {
	
	@Autowired
	UserRepository repository;
	
	@ResponseBody
	@RequestMapping(value = "/save", method =  RequestMethod.GET )
	public String process(){
		
		repository.save(Arrays.
				asList(new User("Jack", "123"), 
										new User("Adam", "234")));
		
		return "Done";
	}
	
	
	@RequestMapping(value = "/findall", method =  RequestMethod.GET )
	public String findAll(){
		
		String result = "";
		
		for(User cust : repository.findAll()){
			result += cust + "</br>";
		}
		
		return result;
	}
	
	@RequestMapping(value = "/findbyid", method =  RequestMethod.GET )
	public String findById(@RequestParam("id") long id){
		String result = "";
		result = repository.findOne(id).toString();
		return result;
	}
	
	@RequestMapping(value = "/findbyname", method =  RequestMethod.GET )
	public User fetchDataByLastName(@RequestParam("lastname") String lastName){
		String result = "";
		
		User user =repository.findByName(lastName);
			
		
		return user;
	}
}