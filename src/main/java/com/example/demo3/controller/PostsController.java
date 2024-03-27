package com.example.demo3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import追加
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo3.data.entity.Posts;
import com.example.demo3.data.repository.PostsRepository;

@Controller
public class PostsController {
	
	@Autowired PostsRepository postsRepository;
	
	// アノテーション付きのメソッド追加
	@GetMapping("/posts")
	public String getPosts(Model model) {
		// ユーザーリスト取得処理を追加
		List<Posts> posts = postsRepository.findAll();
		// テンプレートは src/main/resources/templates/posts.html とします。
		model.addAttribute("posts", posts);
		return "posts";
	}
}
