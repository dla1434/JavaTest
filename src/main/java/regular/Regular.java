package regular;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular {
	private static Logger logger = LoggerFactory.getLogger(Regular.class);

	public static void main(String[] args) {
		String text = "112.172.131.91 - - [08/Jun/2017:16:25:12] POST /searchTreeMgt/executeMetaSearch.do HTTP/1.1 200 432";
		
//		String pattern1 = "(.+)- - \[(.+)\] POST \/searchTreeMgt\/executeMetaSearch.do HTTP\/1.1 200 432";
		String pattern1 = "(.+)- - \\[(.+)\\] POST \\/searchTreeMgt\\/executeMetaSearch.do HTTP\\/1.1 200 432";
		 String pattern2 = "(.+?)((\\.tar)?\\.gz)$";

//		Pattern p = Pattern.compile("(.+)- - \[(.+)\] POST \/searchTreeMgt\/executeMetaSearch.do HTTP\/1.1 200 432");	// s 또는 e 를 찾는 패턴 
		Pattern p = Pattern.compile(pattern1);	// s 또는 e 를 찾는 패턴 
		
		
		Matcher m = p.matcher(text); 			//ext 에서 패턴 검사를 수행한 결과들을 m 에 담는다.
		
		ArrayList<String> listMatches = new ArrayList<String>();
		
		while (m.find()){
			System.out.println("mgroup : " + m.group());	//m의 그룹(결과)을 각각 출력한다.
			
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
