package com.latilt.webservice.service;

import java.util.List;
import java.util.stream.Collectors;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.latilt.webservice.domain.posts.PostsRepository;
import com.latilt.webservice.dto.posts.PostsMainResponseDto;
import com.latilt.webservice.dto.posts.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
	private PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}
	
	@Transactional(readOnly = true)
	public List<PostsMainResponseDto> findAllDesc() {
		return postsRepository.findAllDesc()
				.map(PostsMainResponseDto::new)
				.collect(Collectors.toList());
	}
}
