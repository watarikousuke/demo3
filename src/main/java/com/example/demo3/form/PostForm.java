package com.example.demo3.form;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PostForm {
	@Size(min = 1, max = 50)
	private String title;
	@Size(min = 1, max = 20)
	private String name;	
	@Size(min = 1, max = 1000)
	private String text;

}
