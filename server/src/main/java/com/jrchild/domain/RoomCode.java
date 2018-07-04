package com.jrchild.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@ToString
public class RoomCode {
	
	@Id
	@Column(name="ROOM_CODE")
	private String roomCode;
	
	@Column(name="ROOM_NAME")
	private String roomName;
	
	@ManyToOne
	private OfficeCode officeCode;
	
}
