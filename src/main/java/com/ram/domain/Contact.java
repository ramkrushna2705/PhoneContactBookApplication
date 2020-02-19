package com.ram.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Contact {

	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long contactNumber;
	private String activeSwitch;
	private Date createDate;
	private Date updateDate;

}
