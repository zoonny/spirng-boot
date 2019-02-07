package com.kt.webservice.service;

import com.kt.webservice.domain.PostsRepository;
import com.kt.webservice.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log
@AllArgsConstructor
@Service
public class PostsService {

  private PostsRepository postsRepository;

  @Transactional
  public Long save(PostsSaveRequestDto dto) {
    return postsRepository.save(dto.toEntity()).getId();
  }

}
