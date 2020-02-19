package com.ram.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ram.domain.Contact;
import com.ram.entity.ContactDetailsEntity;

@Repository
@Transactional
public interface MyJpaRepository
		extends JpaRepository<ContactDetailsEntity, Serializable>, JpaSpecificationExecutor<Contact> {

	@Modifying
	@Query(value = "UPDATE ContactDetailsEntity set activeSwitch=:activeSwitch where contactId=:contactId")
	public void updateByContactIdNative(String activeSwitch, Integer contactId);

	@Query
	public List<ContactDetailsEntity> findByActiveSwitch(String activeSwitch);

}
