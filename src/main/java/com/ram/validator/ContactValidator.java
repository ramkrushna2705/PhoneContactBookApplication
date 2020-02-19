package com.ram.validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

public class ContactValidator {

	@Bean
	public ResourceBundleMessageSource getBundle() {
		System.out.println("ContactValidator.getBundle()");
		ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
		rbms.setBasename("messages");
		return rbms;
	}
}
