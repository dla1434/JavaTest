

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.java.test.consts.CommonConst;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Template {
	@Before
	public void init(){
		
	}
	
	@Test
	public void test1_Classic() {
		log.info(CommonConst.title, "testClassic");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test2_(){
		log.info(CommonConst.title, "test1");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test3_(){
		log.info(CommonConst.title, "test2");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test4_(){
		log.info(CommonConst.title, "test3");
		log.info(CommonConst.line);
	}
}
