package com.kt.webservice.dto.posts;

import com.kt.webservice.domain.Posts;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import lombok.Getter;

@Getter
public class PostsMainResponseDto {

  private Long id;

  private String title;

  private String author;

  private String modifiedDate;

  public PostsMainResponseDto(Posts entity) {
    this.id = entity.getId();
    this.title = entity.getTitle();
    this.author = entity.getAuthor();
    this.modifiedDate = toStringDateTime(entity.getModifiedDate());
  }

  // Java 8
  private String toStringDateTime(LocalDateTime localDateTime) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return Optional.ofNullable(localDateTime)
        .map(formatter::format)
        .orElse("");
  }

  // Java 7
  private String toStringDateTimeByJava7(LocalDateTime localDateTime) {
    if (localDateTime == null) {
      return "";
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return formatter.format(localDateTime);
  }

}
