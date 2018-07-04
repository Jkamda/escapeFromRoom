package com.jrchild.persistence;

import org.springframework.data.repository.CrudRepository;

import com.jrchild.domain.HintCode;

public interface HintCodeRepository extends CrudRepository<HintCode, String> {

}
