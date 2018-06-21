package dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

	@Query("select c  from Contact c where c.firstName like :x")
	public Page<Contact> searchContact(@Param("x") String keywords, Pageable pageable);
}
