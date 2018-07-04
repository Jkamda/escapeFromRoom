package com.jrchild.persistence;

import org.springframework.data.repository.CrudRepository;

import com.jrchild.domain.RoomCode;

public interface RoomRepository extends CrudRepository<RoomCode, String> {

}
