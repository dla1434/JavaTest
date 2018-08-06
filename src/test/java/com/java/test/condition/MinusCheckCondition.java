package com.java.test.condition;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MinusCheckCondition {
	@Test
	public void testMinusCondition() {
		int days = -2;
		
		if( days >= -7 && days <= -3 ){
			System.out.println("OK");
		}
		else{
			System.out.println("NOK");
		}
	} 
}
