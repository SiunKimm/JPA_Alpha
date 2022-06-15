package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import com.example.demo.entity.Member;

@org.springframework.stereotype.Service
public class Service {
	@PersistenceUnit
	EntityManagerFactory emf;

	@PersistenceContext
	EntityManager em;
	
	public void typedQuery() {

		String jpql = "SELECT m FROM Member m";
		TypedQuery<Member> query = em.createQuery(jpql, Member.class);

		List<Member> memberList = query.getResultList();
		for (Member member : memberList) {
			System.out.println(member.getFrndSeq());
			System.out.println(member.getFrndNm());
			System.out.println(member.getCreatedDateString());
			System.out.println(member.getModifiedDateString());
		}
	}

}
