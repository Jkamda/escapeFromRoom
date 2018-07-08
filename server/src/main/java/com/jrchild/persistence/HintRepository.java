package com.jrchild.persistence;

import org.springframework.data.repository.CrudRepository;

import com.jrchild.domain.Hint;

public interface HintRepository extends CrudRepository<Hint, String> {

}