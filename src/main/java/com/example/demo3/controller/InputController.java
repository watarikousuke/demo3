package com.example.demo3.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo3.data.entity.Posts;
import com.example.demo3.data.repository.PostsRepository;
import com.example.demo3.form.PostForm;

@Controller
public class InputController {
	
	@Autowired PostsRepository postsRepository;	
	
	@GetMapping("/input")
	public String getNewPost(Model model) {
		// Modelに空のPostFormを追加
		PostForm postForm = new PostForm();
		model.addAttribute("postForm", postForm);
		return "input";
	}
	
	@PostMapping("/posts")
	public String registerPost(@Validated PostForm postForm, BindingResult bindingResult)  {
		if (bindingResult.hasErrors()) {
			// エラーがある場合は投稿画面を返す
			return "input";
		}
		//DBへの投稿内容登録処理
		Posts post = new Posts();
		post.setTitle(postForm.getTitle());
		post.setName(postForm.getName());
		post.setText(postForm.getText());
		post.setDate(LocalDateTime.now());
		System.out.println(post.getTitle());
		System.out.println(post.getName());
		System.out.println(post.getText());
		System.out.println(post.getDate());
		
		postsRepository.save(post);
		
		return "redirect:/posts";
	}
}
