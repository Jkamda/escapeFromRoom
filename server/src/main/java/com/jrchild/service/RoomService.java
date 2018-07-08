package com.jrchild.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrchild.domain.Room;
import com.jrchild.persistence.RoomRepository;

@Service
public class RoomService {
	
	@Autowired
	RoomRepository roomRepository;
	
	
	public void registerRoomService(Room room) {
		
		roomRepository.save(room);
	}
	
	public List<Room> getRoomListService() {
		List<Room> list = new ArrayList<>();
		Iterable<Room> rooms = roomRepository.findAll();
		rooms.forEach(list::add);
		return list;
	}
}
