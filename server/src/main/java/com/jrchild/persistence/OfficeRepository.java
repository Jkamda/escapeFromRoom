package com.jrchild.persistence;

import org.springframework.data.repository.CrudRepository;

import com.jrchild.domain.OfficeCode;

public interface OfficeRepository extends CrudRepository<OfficeCode, String> {

}
