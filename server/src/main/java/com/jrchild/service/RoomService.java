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
		list = (List<Room>) roomRepository.findAll();
		return list;
	}
	
	public List<Room> findByOfficeCode(String officeCode) {
		List<Room> list = new ArrayList<>();
		list = (List<Room>)roomRepository.findRoomByOfficeOfficeCode(officeCode);
		
		return list;
	}
}
