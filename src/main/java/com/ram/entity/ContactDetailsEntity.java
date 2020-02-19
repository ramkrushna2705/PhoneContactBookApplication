package com.ram.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "CONTACT_DETAILS")
public class ContactDetailsEntity {

	@Id
	@GeneratedValue
	@Column(name = "CONTACT_ID")
	private Integer contactId;

	@Column(name = "CONTACT_NAME")
//	@NotBlank(message = "Please enter the name..")
	private String contactName;

	@Column(name = "CONTACT_EMAIL")
//	@NotBlank(message = "Email is mendatory..")
	private String contactEmail;

	@Column(name = "CONTACT_NUMBER")
//	@NotBlank(message = "Number is mendatory..")
	private Long contactNumber;

	@Column(name = "ACTIVE_SWITCH")
	private String activeSwitch;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createDate;

	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Date updateDate;

}
