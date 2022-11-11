package com.example.helloworld;


import com.example.helloworld.repository.MemberRepository;
import com.example.helloworld.repository.MemoryMemberRepository;
import com.example.helloworld.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
