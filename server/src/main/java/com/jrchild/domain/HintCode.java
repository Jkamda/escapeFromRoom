package com.jrchild.domain;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name="HINT_CODE")
@ToString
public class HintCode {

	@Id
	@Column(name="HINT_CODE")
	private String hintCode;
	
	@Column(name="HINT_EXPLAIN_TEXT")
	private String hintExplainText;
	
	@Lob
	@Column(name="HINT_EXPLAIN_IMG")
	private Blob hintExplainImg;
	
	@Column(name="HINT_CREATE_TIMESTAMP")
	private String hintCreateTimestamp;
	
	@Column(name="HINT_UPDATE_TIMESTAMP")
	private String hintUpdateTimestamp;
	
	@Column(name="HINT_OFFICE_CODE")
	private String hintOfficeCode;
	
	@Column(name="HINT_ROOM_CODE")
	private String hintRoomCode;
	
	@Column(name="HINT_CREATOR")
	private String hintCreator;
	
	@ManyToOne
	private Member member;
	
	
	
}
