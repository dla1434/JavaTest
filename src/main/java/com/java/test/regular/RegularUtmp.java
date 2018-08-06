package com.java.test.regular;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularUtmp {
	private static Logger logger = LoggerFactory.getLogger(RegularUtmp.class);

	public static void main(String[] args) {
		String text = "[7] [20293] [ts/2] [flklog  ] [pts/2       ] [112.172.131.142     ] [112.172.131.142] [수  6월 21 08:58:03 2017  ]";
		String pattern1 = "\\[(.+)\\] \\[(.+)\\] \\[(.+)\\] \\[(.+)\\] \\[(.+)\\] \\[(.+)\\] \\[(.+)\\] \\[(.+)\\]";

		Pattern p = Pattern.compile(pattern1);	// s 또는 e 를 찾는 패턴 
		Matcher m = p.matcher(text); 			//ext 에서 패턴 검사를 수행한 결과들을 m 에 담는다.
		
		ArrayList<String> listMatches = new ArrayList<String>();
		
		while (m.find()){
			System.out.println("mgroup : " + m.group());	//m의 그룹(결과)을 각각 출력한다.
			System.out.println("mgroup.length : " + m.groupCount());	//m의 그룹(결과)을 각각 출력한다.
			
			for(int i=0; i < m.groupCount(); i++){
				System.out.println("group parser : " + m.group(i+1));
			}
		}
		
		m.reset();
		
		while (m.find()){
			listMatches.add(m.group());
		}
		
		System.out.println(listMatches);	//listMatches 에 담긴 m 의 그룹들을 출력한다.
	}
}
