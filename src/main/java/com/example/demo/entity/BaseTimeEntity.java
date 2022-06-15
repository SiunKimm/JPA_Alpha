package com.example.demo.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
public class BaseTimeEntity {
	
	// 생성 시간
	@CreatedDate
	private LocalDateTime createdDate;
	
	// 마지막 수정 시간
	@LastModifiedDate
	private LocalDateTime modifiedDate;

	protected BaseTimeEntity() {
	}

	public BaseTimeEntity(LocalDateTime createdDate, LocalDateTime modifiedDate) {
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}
	
	// 시간 포멧에 항상 T 문자가 붙어서 T 를 삭제 시키는 포멧팅 메서드 ex) 2022-06-07 T 12:00:12
	public String getCreatedDateString() {
		if (createdDate != null) {
			return createdDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		}
		return "";
	}

	// 시간 포멧에 항상 T 문자가 붙어서 T 를 삭제 시키는 포멧팅 메서드 ex) 2022-06-07 T 12:00:12
	public String getModifiedDateString() {
		if (modifiedDate != null) {
			return modifiedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		}
		return "";
	}
}