package com.jrchild.persistence;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrchild.domain.Office;

public interface OfficeRepository extends CrudRepository<Office, String> {
	
	@Query(value = "SELECT * FROM office", nativeQuery = true)
	public List<Object[]> getSelectOfficeCode();
	
}
