package com.oraclejava.homepage.service;


import com.oraclejava.homepage.dto.Member;
import com.oraclejava.homepage.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    
    @Autowired
    MemberRepository memberRepository;
    
    public Member login(String loginId, String password) {

        return memberRepository.findByLoginIdAndPassword(loginId, password);
    }
}
