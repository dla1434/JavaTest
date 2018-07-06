package com.java.test.algorithm.gita;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class room_1475 {
	public static void main(String[] args) throws Exception {
		int i, max = 0;
		int set[] = new int[10];
		
		String readNum = new BufferedReader(new InputStreamReader(System.in)).readLine();
		readNum = readNum.replace('9', '6');
		
		for(i=0;i<readNum.length();i++){
			System.out.println("readNum.charAt(i) : " + readNum.charAt(i));
//			System.out.println("readNum.charAt(i)-48 : " + (readNum.charAt(i)-48) );
//			set[readNum.charAt(i)-48]++;
			
			set[readNum.charAt(i)-48]++;
			
			int arrayNum = readNum.charAt(i)-48;
			System.out.println("set[readNum.charAt(" + arrayNum + ")] : " + set[arrayNum] );
		}
		
		//6,9는 같이 쓸 수 있으므로 2로 나누자
		//ex) 3이라면 3/2=1는 1세트 --> 나머지가 있으므로 하나의 세트가 더 필요 --> 총 2세트
		set[6] = set[6] /2 + set[6] % 2;
			
		for(i=0;i<9;i++){ 
			if(max < set[i]){
				max = set[i];
			}
		}
		System.out.println(max);
	}
}
