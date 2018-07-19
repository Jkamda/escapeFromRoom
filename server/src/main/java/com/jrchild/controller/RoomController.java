package com.jrchild.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jrchild.domain.Hint;
import com.jrchild.domain.Office;
import com.jrchild.domain.Room;
import com.jrchild.service.RoomService;

@RestController
public class RoomController {
	@Autowired
	RoomService roomService;
	
	@PostMapping(value="/api/v1/room/register")
	public void registerRoom(@RequestBody Object data) {
		
		HashMap<String, String> map = (HashMap<String, String>) data;
		
		String officeCode=map.get("officeCode");
		Office office=new Office();
		office.setOfficeCode(officeCode);
				
		String roomCode=map.get("roomCode");
		String roomName=map.get("roomName");
		Room room=new Room();
		room.setRoomCode(roomCode);
		room.setRoomName(roomName);
		room.setOffice(office);

		roomService.registerRoomService(room);
	}
	
	@GetMapping(value="/api/v1/room")
	public List<Room> getRoomList() {
		return  roomService.getRoomListService();
	}
	
	@GetMapping(value="/api/v1/room/{officeCode}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Room> findByOfficeCode(@PathVariable String officeCode) {		
		return  roomService.findByOfficeCode(officeCode);
	}
	

}
