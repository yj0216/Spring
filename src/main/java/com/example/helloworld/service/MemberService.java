package com.example.helloworld.service;

import com.example.helloworld.domain.Member;
import com.example.helloworld.repository.MemberRepository;
import com.example.helloworld.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service//스프링이 찾을 수 있도록 만듬
@Transactional
public class  MemberService {

    private final MemberRepository memberRepository;

    //@Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    //회원가입
    public Long join(Member member){
//        long start = System.currentTimeMillis();
//
//        try {
            validateDuplicateMember(member);//중복 회원 검색
            memberRepository.save(member);
            return member.getId();
//        } finally {
//            long finish = System.currentTimeMillis();
//            long timeMs = finish - start;

//            System.out.println("join = " + timeMs + "ms");

//        }

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent((m ->{
                             throw new IllegalStateException("이미 존재하는 회원입니다.");
                        }));
    }

    public List<Member> findMembers(){
            return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return  memberRepository.findById(memberId);

    }
}
