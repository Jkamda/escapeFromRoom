package com.jrchild;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jrchild.domain.OfficeCode;
import com.jrchild.domain.RoomCode;
import com.jrchild.persistence.OfficeRepository;
import com.jrchild.persistence.RoomRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OfficeAndRoomTests {

	@Autowired
	OfficeRepository officeRepository;
	
	@Autowired
	RoomRepository roomRepository;
	
	
	
	@Test
	public void InsertOfficeCode() {
		
		OfficeCode office1=new OfficeCode();
		office1.setOfficeCode("B0001");
		office1.setOfficeName("홍대점");
		officeRepository.save(office1);
		
		OfficeCode office2=new OfficeCode();
		office2.setOfficeCode("B0002");
		office2.setOfficeName("범계점");
		officeRepository.save(office2);
		
	}
	
	
	@Test
	public void InsertRoomCode() {
		
		OfficeCode officeCode=new OfficeCode();
		officeCode.setOfficeCode("B0001");
		
		OfficeCode officeCode2=new OfficeCode();
		officeCode2.setOfficeCode("B0002");
		for(int i=0; i<10; i++) {
			RoomCode room=new RoomCode();
			String roomCodeNum = String.format("%04d", i); 
			room.setRoomCode("R"+roomCodeNum);
			room.setRoomName("룸_"+roomCodeNum);
			room.setOfficeCode(officeCode);
			roomRepository.save(room);
		}
		
		for(int i=0; i<10; i++) {
			RoomCode room=new RoomCode();
			String roomCodeNum = String.format("%04d", i); 
			room.setRoomCode("R"+roomCodeNum);
			room.setRoomName("룸_"+roomCodeNum);
			room.setOfficeCode(officeCode2);
			roomRepository.save(room);
		}

	}
	
}
