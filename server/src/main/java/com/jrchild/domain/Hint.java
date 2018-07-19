package com.jrchild.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name="HINT")
@ToString
public class Hint {

	@Id
	@Column(name="HINT_CODE")
	private String hintCode;
	
	@Column(name="HINT_EXPLAIN_TEXT")
	private String hintExplainText;
	
	@Lob
	@Column(name="HINT_EXPLAIN_IMG")
	private String hintExplainImg;
	
	@Column(name="HINT_CREATE_TIMESTAMP")
	@CreationTimestamp
	private Timestamp hintCreateTimestamp;
	
	@Column(name="HINT_UPDATE_TIMESTAMP")
	@UpdateTimestamp
	private Timestamp hintUpdateTimestamp;
	
	@Column(name="HINT_OFFICE_CODE")
	private String hintOfficeCode;
	
	@Column(name="HINT_ROOM_CODE")
	private String hintRoomCode;
	
	@Column(name="HINT_CREATOR")
	private String hintCreator;
	
	
}