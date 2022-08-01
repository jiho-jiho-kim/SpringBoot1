package com.simple.basic.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.simple.basic.command.BuilderVo;
import com.simple.basic.command.BuilderVo2;

@SpringBootTest
public class TestCode02 {
	
	@Test
	public void test01() {
		//Builder b = BuilderVo.builder();
		//BuilderVo vo = b.name("홍길동").age(10).build();
		
		BuilderVo vo = BuilderVo.builder().name("홍길동").age(10).build();
		
		System.out.println(vo.toString());
	
	
	//lombok의 @Builder 어노테이션
	BuilderVo2 vo2 = BuilderVo2.builder().name("이순신").age(46).build();
	
	System.out.println(vo2.toString());
	
	}
}	  
