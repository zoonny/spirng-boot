package com.kt.webservice.domain;

import java.time.LocalDateTime;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass // JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들을 컬럼으로 인식하도록 선언
@EntityListeners(AuditingEntityListener.class)  // Audting 기능을 포함
public abstract class BaseTimeEntity {

  @CreatedDate  // Entity가 생성되어 저장될 때 시간이 자동 저장
  private LocalDateTime createdDate;

  @LastModifiedDate // 조회한 Entity값 변경 시 시간이 자동 저장
  private LocalDateTime modifiedDate;

}
