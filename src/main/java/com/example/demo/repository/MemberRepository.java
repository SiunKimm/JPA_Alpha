package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BaseTimeEntity;
import com.example.demo.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

	List<Member> findById(long frndSeq);

	List<Member> findByFrndNm(String frndNm);

	List<BaseTimeEntity> findByCreatedDate(LocalDateTime createdDate);

	List<BaseTimeEntity> findByModifiedDate(LocalDateTime modifiedDate);
	
	// frndNm 필드에 매개변수 frndNm 의 값이 포함되어 있는 엔티티를 조회하는 메서드
	Page<Member> findByFrndNmContainsIgnoreCase(String frndNm, PageRequest pageRequest);

}
