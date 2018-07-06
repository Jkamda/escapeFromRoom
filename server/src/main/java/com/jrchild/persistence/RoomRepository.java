package com.jrchild.persistence;

import org.springframework.data.repository.CrudRepository;

import com.jrchild.domain.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {

}
