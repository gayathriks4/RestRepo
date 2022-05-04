package com.example.Resttemplate.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Resttemplate.pojo.Post;
import com.example.Resttemplate.pojo.User;
import com.example.Resttemplate.service.RestImplementation;

@RestController
@RequestMapping("/resttemplate")
public class TestingApi {
	
	@Autowired
	RestTemplate restTemplate;
	
	RestImplementation RI=new RestImplementation();
	@Autowired
	User ul;
	@GetMapping("/listusers")
	public ResponseEntity<String> getUsers(){
		
		String url="https://gorest.co.in/public/v2/posts";
		ResponseEntity<String> result=restTemplate.exchange(url, HttpMethod.GET,null,String.class);
		
		String rep=result.getBody();
		System.out.println("body:"+rep);
		return result;
	}
	@GetMapping("/listusersclass")
	public List<User> getUsersClass(){
		
		String url="https://gorest.co.in/public/v2/users";
		//List<User> rep=restTemplate.exchange(url,HttpMethod.GET,null, new ParameterizedTypeReference<List<User>>());
		ResponseEntity<List<User>> result = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
		});
		/*
		 * restTemplate.getForEntity(url, null, new
		 * ParameterizedTypeReference<List<User>>() { });
		 */
		List<User> rep=result.getBody();
		List<User> returnModify=new ArrayList<User>();
		System.out.println(rep);
		for(int i=0;i<rep.size();i++) {
			User user = rep.get(i);
			System.out.println("check:"+user.getEmail());
		}
		System.out.println(rep.get(0).getEmail());
		for (User us : rep) {
			String status = us.getStatus();
			if(status.equalsIgnoreCase("inactive")) {
				us.setStatus("InProgress");
			}
			/*
			 * ul.setId(us.getId()); ul.setName(us.getName()); ul.setEmail(us.getEmail());
			 * ul.setGender(us.getGender());
			 returnModify.add(ul);
			 */
			
		}
		
		  System.out.println("body:"+returnModify);
		 
		return rep;
	}
	@PostMapping("/createuser")
	public ResponseEntity<Post> createUsers(){
		
		String url="https://jsonplaceholder.typicode.com/posts";
		HttpHeaders header=new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		// set `accept` header
		header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		// request body parameters
		
		Post post = new Post(102, 1, "Spring Boot 101",
                "A powerful tool for building web apps.");

		// build the request
		HttpEntity<Post> request = new HttpEntity<>(post, header);

		// send POST request
		ResponseEntity<Post> response = restTemplate.postForEntity(url, request, Post.class);

		// check response
		if (response.getStatusCode() == HttpStatus.CREATED) {
		    System.out.println("Request Successful");
		    System.out.println(response.getBody());
		} else {
		    System.out.println("Request Failed");
		    System.out.println(response.getStatusCode());
		}
		return response;
	}

}
