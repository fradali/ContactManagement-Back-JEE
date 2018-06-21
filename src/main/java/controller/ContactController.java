package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dao.ContactRepository;
import entities.Contact;

@RestController
@CrossOrigin("*")
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public List<Contact> getContacts() {
		return contactRepository.findAll();
	}

	@RequestMapping(value = "/contacts/{id}", method = RequestMethod.GET)
	public Contact getContact(@PathVariable Long id) {
		return contactRepository.findOne(id);
	}

	@RequestMapping(value = "/contacts", method = RequestMethod.POST)
	public Contact saveContact(@RequestBody Contact contact) {
		return contactRepository.save(contact);
	}

	@RequestMapping(value = "/contacts/{id}", method = RequestMethod.DELETE)
	public void deleteContact(@PathVariable Long id) {
		contactRepository.delete(id);
	}

	@RequestMapping(value = "/contacts/{id}", method = RequestMethod.PUT)
	public Contact updateContact(@PathVariable Long id, @RequestBody Contact contact) {
		contact.setId(id);
		return contactRepository.save(contact);
	}

	@RequestMapping(value = "/searchContacts", method = RequestMethod.GET)
	public Page<Contact> searchContact(@RequestParam(name = "keywords", defaultValue = "") String keywords,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {

		System.out.println(keywords);
		return contactRepository.searchContact("%" + keywords + "%", new PageRequest(page, size));
	}

}
