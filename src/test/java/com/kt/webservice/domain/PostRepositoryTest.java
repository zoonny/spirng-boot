package com.kt.webservice.domain;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

  @Autowired
  PostsRepository postsRepository;

  @After
  public void cleanup() {
    // 이후 테스트 코드에 영향을 끼치지 않기 위해 테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
    postsRepository.deleteAll();
  }

  @Test
  public void 게시글저장_불러오기() {
    // given, when, then : BDD(Behaviour-Driven Development), Groovy 기반 Spock 주로 사용

    // given : 테스트 기반을 구축
    postsRepository.save(Posts.builder()
        .title("테스트 게시글")
        .content("테스트 본문")
        .author("test@kt.com")
        .build());

    // when : 테스트 행위 선언
    List<Posts> postsList = postsRepository.findAll();

    // then : 테스트 결과 검증
    Posts posts = postsList.get(0);
    assertThat(posts.getTitle(), is("테스트 게시글"));
    assertThat(posts.getContent(), is("테스트 본문"));
  }

  @Test
  public void BaseTimeEntity_등록() {
    // given
    LocalDateTime now = LocalDateTime.now();
    postsRepository.save(Posts.builder()
        .title("테스트 게시글")
        .content("테스트 본문")
        .author("test@kt.com")
        .build());

    // when
    List<Posts> postsList = postsRepository.findAll();

    // then
    Posts posts = postsList.get(0);
    assertTrue(posts.getCreatedDate().isAfter(now));
    assertTrue(posts.getModifiedDate().isAfter(now));
  }

}
