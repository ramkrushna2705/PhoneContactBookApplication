package com.ram.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ram.domain.Contact;
import com.ram.service.ContactDetailsService;

@Controller
public class PhoneBookController {

	private static final String LOGICAL_VIEW_NAME="contact";
	private static final String LOG_MESSAGE_START="Method executation started";
	private static final String LOG_MESSAGE_ENDED="Method executation ended";
	
	/**
	 * org.slf4j.Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(PhoneBookController.class);

	@Autowired
	private ContactDetailsService service;

	/**
	 * contact page load
	 * 
	 * @param model
	 * @return string
	 */
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String loadFrom(Model model) {
		logger.debug(LOG_MESSAGE_START);
		model.addAttribute(LOGICAL_VIEW_NAME, new Contact());
		logger.debug(LOG_MESSAGE_ENDED);
		return LOGICAL_VIEW_NAME;
	}

	/**
	 * process the contact home page
	 * 
	 * @param contact
	 * @param model
	 * @return string
	 * 
	 */
	@RequestMapping(value = "/processFrom", method = RequestMethod.POST)
	public String handleSubmitReq(@ModelAttribute(LOGICAL_VIEW_NAME) Contact contact,
			RedirectAttributes modelAttributes) {
		logger.debug(LOG_MESSAGE_START);
		boolean saveContact = service.saveContact(contact);
		if (saveContact) {
			modelAttributes.addFlashAttribute("successMsg", "Record stored successfully..!!");
		} else {
			modelAttributes.addFlashAttribute("errorMsg", "Record not stored..!!");
		}
		logger.debug(LOG_MESSAGE_ENDED);
		return "redirect:/processDoublePosting";
	}

	/**
	 * process the double posting problem
	 * 
	 * @return string
	 */
	@RequestMapping(value = "/processDoublePosting", method = RequestMethod.GET)
	public String processFormDoublePosting(Model model) {
		logger.debug(LOG_MESSAGE_START);
		model.addAttribute(LOGICAL_VIEW_NAME, new Contact());
		logger.debug(LOG_MESSAGE_ENDED);
		return LOGICAL_VIEW_NAME;
	}

	/**
	 * process view all page
	 * 
	 * @param model
	 * @return string view all page is display
	 */
	@RequestMapping(value = "/allContact", method = RequestMethod.GET)
	public String viewAllRecord(Model model) {
		logger.debug(LOG_MESSAGE_START);
		Iterable<Contact> allContact = service.getAllContact();
		model.addAttribute("listContacts", allContact);
		logger.debug(LOG_MESSAGE_ENDED);
		return "viewContacts";
	}

	/**
	 * process edit page get primary key from database
	 * using path param to get the value form from
	 * @param id
	 * @param model
	 * @return string
	 */
	@RequestMapping(value = "/edit/{id}")
	public String updateRecord(@PathVariable("id") Integer id, Model model) {
		logger.debug(LOG_MESSAGE_START);
		Contact con = service.getContactById(id);
		model.addAttribute(LOGICAL_VIEW_NAME, con);
		System.out.println(con);
		logger.debug(LOG_MESSAGE_ENDED);
		return LOGICAL_VIEW_NAME;
	}

	/**
	 * process soft delete page
	 * 
	 * @param contactId
	 * @param model
	 * @return string
	 */
	@RequestMapping(value = "/delete")
	public String handleDeleteLink(@RequestParam("contactId") Integer contactId, RedirectAttributes model) {
		logger.debug(LOG_MESSAGE_START);
		boolean deleteContact = service.deleteContact(contactId);
		if (deleteContact) {
			model.addFlashAttribute("successMessage", "Contact Deleted Successfully..!!");
		}
		logger.debug(LOG_MESSAGE_ENDED);
		return "redirect:/allContact";
	}

}
