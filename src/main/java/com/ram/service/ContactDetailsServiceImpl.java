package com.ram.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.domain.Contact;
import com.ram.entity.ContactDetailsEntity;
import com.ram.repository.MyJpaRepository;

@Service
public class ContactDetailsServiceImpl implements ContactDetailsService {

	@Autowired
	private MyJpaRepository repository;

	@Override
	public boolean saveContact(Contact contact) {
		ContactDetailsEntity entity = new ContactDetailsEntity();
		BeanUtils.copyProperties(contact, entity);
		entity.setActiveSwitch("Y");
		ContactDetailsEntity save = repository.save(entity);
		return save.getContactId() != null;
	}

	@Override
	public Iterable<Contact> getAllContact() {
		List<ContactDetailsEntity> findByActiveSwitch = repository.findByActiveSwitch("Y");
		List<Contact> list = new ArrayList<>();
		for (ContactDetailsEntity contactEntity : findByActiveSwitch) {
			Contact con = new Contact();
			BeanUtils.copyProperties(contactEntity, con);
			list.add(con);
		}
		return list;
	}

	@Override
	public Contact getContactById(Integer contactID) {
		ContactDetailsEntity contactDetailsEntity = null;
		Optional<ContactDetailsEntity> findById = repository.findById(contactID);
		if (findById.isPresent()) {
			contactDetailsEntity = findById.get();
		}
		Contact contact = new Contact();
		BeanUtils.copyProperties(contactDetailsEntity, contact);
		return contact;
	}

	@Override
	public boolean updateContact(Contact contact) {
		ContactDetailsEntity entity = new ContactDetailsEntity();
		BeanUtils.copyProperties(contact, entity);
		ContactDetailsEntity save = repository.save(entity);
		return save != null;
	}

	@Override
	public boolean deleteContact(Integer contactId) {
		System.out.println("ContactId :: " + contactId);
		repository.updateByContactIdNative("N", contactId);
		return true;
	}
}
