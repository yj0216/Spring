package com.example.helloworld.service;

import com.example.helloworld.domain.Member;
import com.example.helloworld.repository.MemberRepository;
import com.example.helloworld.repository.MemoryMemberRepository;
import java.util.List;
import java.util.Optional;


public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    //회원가입
    public Long join(Member member){
        validateDuplicateMember(member);//중복 회원 검색
        memberRepository.save(member);
        return member.getId();
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
