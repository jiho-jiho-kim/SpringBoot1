package com.simple.basic.command;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@ToString
@Builder
@Data 	//getter, setter, toString
public class BuilderVo2 {
	private String name;
	private int age;
	
}
