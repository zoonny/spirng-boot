package com.kt.webservice.dto.posts;

import com.kt.webservice.domain.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Entity 클래스와 Controller에서 쓸 DTO는 분리해서 사용

@Getter
@Setter // 외부데이터를 받는 경우 기본생성자 + set메소드를 통해서만 값이 할당
@NoArgsConstructor
public class PostsSaveRequestDto {

  private String title;

  private String content;

  private String author;

  @Builder
  public PostsSaveRequestDto(String title, String content, String author) {
    this.title = title;
    this.content = content;
    this.author = author;
  }

  public Posts toEntity() {
    return Posts.builder()
        .title(title)
        .content(content)
        .author(author)
        .build();
  }

}
