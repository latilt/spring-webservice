package com.latilt.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.latilt.webservice.domain.posts.PostsRepository;
import com.latilt.webservice.dto.posts.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {
	
	private PostsRepository postsRepository;
	
	@GetMapping("/hello")
	public String hello() {
		return "HelloWorld2";
	}
	
	@PostMapping("/posts")
	public void savePosts(@RequestBody PostsSaveRequestDto dto) {
		postsRepository.save(dto.toEntity());
	}
}