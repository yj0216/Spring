package com.example.helloworld.repository;

import com.example.helloworld.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Spliterator;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>,MemberRepository {


    //JPQL select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);//규칙에 맞는 이름을 지을 시 자동으로 메서드를 만들어줌(findBy + ...)


}
