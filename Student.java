package com.nt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Students_INFO")
public class Student {
	@Id
	private Integer stid;
	@Column(length=30)
	private String name;
	@Column(length=30)
	private String contactdetails;
	@Column(length=30)
	private String addrs;
	@Column(length=40)
	private String pincode;

}
