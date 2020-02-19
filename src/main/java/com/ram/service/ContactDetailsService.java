package com.ram.service;

import com.ram.domain.Contact;

public interface ContactDetailsService {

	public boolean saveContact(Contact contact);

	public Iterable<Contact> getAllContact();

	public Contact getContactById(Integer contactID);

	public boolean updateContact(Contact contact);

	public boolean deleteContact(Integer contactId);
}
