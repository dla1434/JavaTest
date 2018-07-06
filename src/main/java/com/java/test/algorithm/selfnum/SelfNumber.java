package com.java.test.algorithm.selfnum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelfNumber {
	private static Logger logger = LoggerFactory.getLogger(SelfNumber.class);
	
	static int d[] = new int [10036];//9999로 생성되는 최댓값이 10035이므로 10036까지 선언
	public static void main(String[] args) {
		//TestLoop i/10 
		for (int i = 1; i <= 20; i++) {
//			//앞자리 숫자 구하기
//			testRoop1(i);
			
			//뒤자리 숫자 구하기
//			testRoop2(i);
		}
		
		for (int i = 1; i <= 20; i++) {
			d[dn(i)] = 1;
			if (d[i]!=1)
				System.out.println(i);
		}
	}
	
	public static void testRoop1(int i){
		System.out.println("testRoop1 i/10 : " + i + " = " + i / 10);
	}
	
	public static void testRoop2(int i){
		System.out.println("testRoop1 i%10 : " + i + " = " + i%10);
	}
	
	static int dn(int i){
		int res = i;
		int restNum = i;
		if (i >= 10000) {
			res += i / 10000;
//			i %= 10000;
			restNum = i % 10000; 
		}
		if (i >= 1000) {
			res += i / 1000;
//			i %= 1000;
			restNum = i % 1000; 
		}
		if (i >= 100) {
			res += i / 100;
//			i %= 100;
			restNum = i % 100; 
		}
		if (i >= 10) {
			res += i / 10; 
			restNum = i % 10; 
//			System.out.println("res : " + res + ", res i : " + i);
		}
		
		int orgPlusFirst = res;
		
		res += restNum;
		System.out.println(i + " = org+firstNum : " + orgPlusFirst + ", restNum + " + restNum + " ----> " + res);
		return res;
	}
}
