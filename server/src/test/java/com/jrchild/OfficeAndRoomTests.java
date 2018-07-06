package com.jrchild;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.jrchild.domain.Office;
import com.jrchild.domain.Room;
import com.jrchild.persistence.OfficeRepository;
import com.jrchild.persistence.RoomRepository;

import lombok.extern.java.Log;



@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class OfficeAndRoomTests {

	@Autowired
	OfficeRepository officeRepository;
	
	@Autowired
	RoomRepository roomRepository;

	//@Test
	public void InsertOfficeCode() {
		
		Office office1=new Office();
		office1.setOfficeCode("B0001");
		office1.setOfficeName("홍대점");
		
				
		Office office2=new Office();
		office2.setOfficeCode("B0002");
		office2.setOfficeName("범계점");
		
		officeRepository.save(office1);
		officeRepository.save(office2);
		
	}
	
	
	//@Test
	public void InsertRoomCode() {
		
		Office office=new Office();
		office.setOfficeCode("B0001");
		
		Room room = new Room();
		room.setRoomCode("R0001");
		room.setRoomName("비밀의 방");
		room.setOffice(office);
		
		roomRepository.save(room);
		
		Office office2=new Office();
		office2.setOfficeCode("B0002");
		
		Room room2 = new Room();
		room2.setRoomCode("R0002");
		room2.setRoomName("지옥의 방");
		room2.setOffice(office);
		
		roomRepository.save(room2);


	}
	
	
	
}
