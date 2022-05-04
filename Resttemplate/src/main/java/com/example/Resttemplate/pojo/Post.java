package com.example.Resttemplate.pojo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Component
@NoArgsConstructor
public class Post {
private int userid;
private int id;
private String title;
private String body;
}
