package com.jrchild;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jrchild.domain.Hint;
import com.jrchild.persistence.HintRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HintTests {

	
	@Autowired
	HintRepository hintCodeRepository;
	
	@Test
	public void InsertDummyHintCode() {

		for(int i=1; i<=100; i++) {
			Hint hintCode=new Hint();
			String codeNum = String.format("%04d", i); 
			hintCode.setHintCode("H"+codeNum);
			String currentDate   = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
			hintCode.setHintCreateTimestamp(currentDate);
			hintCode.setHintCreator("amdin");
			hintCode.setHintExplainText("힌트는  "+i+"ㅎㅎㅎㅎ");
			if(i<50) {
				hintCode.setHintOfficeCode("B0001");
			}else {
				hintCode.setHintOfficeCode("B0002");
			}
			hintCode.setHintUpdateTimestamp(currentDate);
			String roomNum = String.format("%04d", i); 
			hintCode.setHintRoomCode("R"+roomNum);	
			hintCodeRepository.save(hintCode);
		}
		
	
	}
}
