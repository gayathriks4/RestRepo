package com.example.Resttemplate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Resttemplate.pojo.User;

@Service
public class RestImplementation {

	@Autowired
	User ul;
	
	public List<User> modifyStatus(List<User> user){
		List<User> returnModify=new ArrayList<User>();
		for (User us : user) {
			String status = us.getStatus();
			if(status.equalsIgnoreCase("inactive")) {
				us.setStatus("InProgress");
			}
			ul.setId(us.getId());
			ul.setName(us.getName());
			ul.setEmail(us.getEmail());
			ul.setGender(us.getGender());
			returnModify.add(ul);
		}
		
		
		
		return returnModify;
	}
}
