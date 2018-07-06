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
@Table(name="OFFICE")
@ToString
public class Office{

	@Id
	@Column(name="OFFICE_CODE")
	private String officeCode;
	
	@Column(name="OFFICE_NAME")
	private String officeName;


}

