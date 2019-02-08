package com.kt.webservice.service;

import com.kt.webservice.domain.PostsRepository;
import com.kt.webservice.dto.posts.PostsMainResponseDto;
import com.kt.webservice.dto.posts.PostsSaveRequestDto;
import java.util.List;
import java.util.stream.Collectors;
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

  // 옵션(readOnly = true)을 주면 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도가 개선
  @Transactional(readOnly = true)
  public List<PostsMainResponseDto> findAllDesc() {
    return postsRepository.findAllDesc()
        .map(PostsMainResponseDto::new) // = .map(posts -> new PostsMainResponseDto(posts))
        .collect(Collectors.toList());
  }

}
