package com.jrchild.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name="ROOM_CODE")
@ToString(exclude = "officeCode")
public class RoomCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rno;	
	
	@Column(name="ROOM_CODE")
	private String roomCode;
	
	@Column(name="ROOM_NAME")
	private String roomName;
	
	@ManyToOne
	private OfficeCode officeCode;
	
}
