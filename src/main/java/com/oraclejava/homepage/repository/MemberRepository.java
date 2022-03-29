package com.oraclejava.homepage.repository;

import com.oraclejava.homepage.dto.Member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    
    Member findByLoginIdAndPassword(String loginId, String password);
}
