package javaOld.pattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Ignore;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PatternMacherTest {
	@Test
	public void gramIndextest() {
//		Pattern p = Pattern.compile("\\{yyyy-mm-dd\\}");
		Pattern p = Pattern.compile("\\$\\{.*\\}");
		Matcher matcher = p.matcher("gram-prod-${yyyy-MM-dd}");
		
		boolean match = matcher.matches();
		log.info("Anything is matching : {}", match);
		
		boolean findResult = matcher.find();
		log.info("findResult : {}", findResult);
		if( findResult ){
			String rollingFormat = matcher.group().replaceAll("\\$\\{","").replaceAll("\\}", "");
			log.info("rollingFormat : {}", findResult, rollingFormat);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(rollingFormat);
			String rolling = LocalDateTime.now().format(formatter);
			
			String indexName = matcher.replaceFirst(rolling);
			log.info("indexName : {}", indexName);
		}
		
		String repalce = matcher.replaceAll("Test");
		log.info("repalce : {}", repalce);
		
		
		log.info(matcher.start() + " " + matcher.group());
	}
	
	@Test
	@Ignore
	public void test() {
		Pattern p = Pattern.compile("BAB");
		Matcher m = p.matcher("ABCABABABCCCAA");

		boolean a = false;
		while(a = m.find()){
			log.info(m.start() + " " + m.group());
		}
	}
}
