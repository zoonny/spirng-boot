package com.kt.webservice.web;

import com.kt.webservice.domain.PostsRepository;
import com.kt.webservice.dto.posts.PostsSaveRequestDto;
import com.kt.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController
@AllArgsConstructor // 모든 아규먼트에 대한 생성사를 자동 생성
public class WebRestController {

  // @Autowired 가 없음
  // Spring Bean 주입 방식 : @Autowired, setter, 생성자 - 이중 생성자 권장
//  private PostsRepository postsRepository;

//  @AllArgsConstructor에서 아래 코드 자동 생성
//  public WebRestController(PostsRepository postsRepository) {
//    this.postsRepository = postsRepository;
//  }

  private PostsService postsService;

  @PostMapping("/posts")
  public void savePosts(@RequestBody PostsSaveRequestDto dto) {
//    postsRepository.save(dto.toEntity());
    postsService.save(dto);
  }

}
