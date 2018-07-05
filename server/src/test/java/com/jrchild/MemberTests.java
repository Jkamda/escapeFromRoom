package com.jrchild;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jrchild.domain.Member;
import com.jrchild.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberTests {

	
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	public void InsertMemberAdmin() {
		Member member=new Member(); //홍대 관리자.
		member.setMemberId("hMaster");
		member.setMemberPw("hMaster");
		member.setMemberRole("admin");
		member.setMemberOfficeCode("B0001"); // Branch
		member.setMemberRoomCode("R0000"); // Room 
		member.setMemberHintRemaining(0);		
		
		memberRepository.save(member);
		
		Member member2=new Member();//범계 관리자.
		member2.setMemberId("bMaster");
		member2.setMemberPw("bMaster");
		member2.setMemberRole("admin");
		member2.setMemberOfficeCode("B0002"); // Branch
		member2.setMemberRoomCode("R0000"); // Room 
		member2.setMemberHintRemaining(0);
		
		memberRepository.save(member2);
	}
	
	@Test
	public void InsertMemberUser() {
		for(int i=1; i<=5; i++) {
			Member member=new Member(); //홍대 유저_룸1.
			
			member.setMemberId("hUser_R"+i);
			member.setMemberPw("hUser_R"+i);
			member.setMemberRole("user");
			member.setMemberOfficeCode("B0001"); // 지점 코드 
			member.setMemberRoomCode("R000"+i); // 방 코드
			member.setMemberHintRemaining(5);		
			memberRepository.save(member);
			
		}

		
		for(int i=1; i<=5; i++) {
			Member member2=new Member();//범계 관리자.
			
			member2.setMemberId("bUser_R"+i);
			member2.setMemberPw("bUser_R"+i);
			member2.setMemberRole("user");
			member2.setMemberOfficeCode("B0002"); // 지점 코드 
			member2.setMemberRoomCode("R000"+i); // 방 코드
			member2.setMemberHintRemaining(5);	
			
			memberRepository.save(member2);
		}
		
	}
	
}
