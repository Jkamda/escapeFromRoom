package com.jrchild.persistence;

import org.springframework.data.repository.CrudRepository;

import com.jrchild.domain.Member;

public interface MemberRepository extends CrudRepository<Member,  String>{

}
