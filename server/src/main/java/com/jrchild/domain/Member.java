package com.jrchild.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name="MEMBER")
@ToString
public class Member {

	@Id
	@Column(name="MEMBER_ID")
	private String memberId;
	
	@Column(name="MEMBER_PW")
	private String memberPw;
	
	@Column(name="MEMBER_ROLE")
	private String memberRole;
	
	@Column(name="MEMBER_OFFICE_CODE")
	private String memberOfficeCode;
	
	@Column(name="MEMBER_ROOM_CODE")
	private String memberRoomCode;
	
	@Column(name="MEMBER_HINT_REMAINING")
	private int memberHintRemaining;
	
	
	
	
}
