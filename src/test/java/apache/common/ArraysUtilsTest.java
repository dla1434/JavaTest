package apache.common;


import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import common.consts.CommonConst;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArraysUtilsTest {
	@Before
	public void init(){
		
	}
	
	@Test
	public void test1_Classic() {
		log.info(CommonConst.title, "test1_Classic");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test2_ApacheCommon_ArrayUtils_StringArr(){
		log.info(CommonConst.title, "test2_ApacheCommon_ArrayUtils_StringArr");
		String[] s1 = new String[] { "a", "b", "c" };
		String[] s2 = new String[] { "d", "e", "f" };

		String[] result = ArrayUtils.addAll(s1, s2);
		System.out.println(Arrays.toString(result));

		log.info(CommonConst.line);
	}
	
	@Test
	public void test3_ApacheCommon_ArrayUtils_IntArr(){
		log.info(CommonConst.title, "test3_ApacheCommon_ArrayUtils_IntArr");
		int[] int1 = new int[] { 1, 2, 3 };
		int[] int2 = new int[] { 4, 5, 6 };
		
		int[] result2 = ArrayUtils.addAll(int1, int2);
		System.out.println(Arrays.toString(result2));
		log.info(CommonConst.line);
	}
	
	@Test
	public void test4_(){
		log.info(CommonConst.title, "test4_");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test5_(){
		log.info(CommonConst.title, "test5_");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test6_(){
		log.info(CommonConst.title, "test6_");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test7_(){
		log.info(CommonConst.title, "test7_");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test8_(){
		log.info(CommonConst.title, "test8_");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test9_(){
		log.info(CommonConst.title, "test9_");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test10_(){
		log.info(CommonConst.title, "test10_");
		log.info(CommonConst.line);
	}
}
