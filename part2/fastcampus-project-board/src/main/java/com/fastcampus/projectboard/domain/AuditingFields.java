package com.fastcampus.projectboard.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Setter 를 넣지 않는 이유?
 * 해당 필드들은 자동으로 설정되는 값들이기 때문이다!!
 */
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class) // EntityListener 도 BaseEntity 에 공통으로 빼서 사용할 수 있다.
@MappedSuperclass
public class AuditingFields {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt; // 생성일

    @CreatedBy
    @Column(nullable = false, updatable = false, length = 100)
    private String createdBy; // 생성자

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifiedAt; // 수정일

    @LastModifiedBy
    @Column(nullable = false, length = 100)
    private String modifiedBy; // 수정자
}
