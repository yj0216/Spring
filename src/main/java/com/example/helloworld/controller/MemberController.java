package com.example.helloworld.controller;

import com.example.helloworld.repository.MemberRepository;
import com.example.helloworld.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller//스프링컨테이너가 관리를 함
public class MemberController {
    private final MemberService memberService;

    @Autowired//스프링에 등록된 멤버서비스가 있는 곳으로 연결시켜줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
