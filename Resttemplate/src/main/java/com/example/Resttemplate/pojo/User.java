package com.example.Resttemplate.pojo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Component
public class User {
	private int id;
	private String name;
	private String email;
	private String gender;
	private String status;
	

}
