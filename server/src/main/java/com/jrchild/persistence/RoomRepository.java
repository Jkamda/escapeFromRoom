package com.jrchild.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jrchild.domain.Room;

public interface RoomRepository extends CrudRepository<Room, String> {

	public List<Room> findRoomByOfficeOfficeCode(String officeCode);
}
