package ru.vasilev.contactmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.vasilev.contactmanager.model.Contact;
import ru.vasilev.contactmanager.repository.ContactRepository;

@Service
public class ContactService {
	private final ContactRepository contactRepo;

	@Autowired
	public ContactService(ContactRepository contactRepo) {
		this.contactRepo = contactRepo;
	}
	
	public List<Contact> findAll(){
		return contactRepo.findAll();
	}
	
	public Optional<Contact> findById(Long id){
		return contactRepo.findById(id);
	}
	
	public Optional<Contact> findByEmail(String email){
		return contactRepo.findByEmail(email);
	}
	
	public Contact create(Contact contact) {
		return contactRepo.save(contact);
	}
	
	public Optional<Contact> update(Long id, Contact contact){
		return contactRepo.findById(id).map(c -> {
			c.setName(contact.getName());
			c.setEmail(contact.getEmail());
			c.setPhone(contact.getPhone());
			return c;
		});
	}
	
	public void delete(Long id){
		contactRepo.deleteById(id);
	}
}