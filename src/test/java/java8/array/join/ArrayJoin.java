package java8.array.join;


import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import common.consts.CommonConst;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArrayJoin {
	@Before
	public void init(){

	}

	@Test
	public void test1_Classic() {
		log.info(CommonConst.title, "test1_Classic");
		log.info(CommonConst.line);
	}

	@Test
	public void test1_IntArrays_To_Array(){
		log.info(CommonConst.title, "test1_");
		int[] int1 = new int[] { 1, 2, 3 };
		int[] int2 = new int[] { 4, 5, 6 };
		int[] int3 = new int[] { 7, 8, 9 };

		// join 2 primitive type array
		int[] result2 = IntStream.concat(Arrays.stream(int1), Arrays.stream(int2)).toArray();

		// join 3 primitive type array, any better idea?
		int[] result3 = IntStream.concat(Arrays.stream(int1), IntStream.concat(Arrays.stream(int2), Arrays.stream(int3)))
				.toArray();

		System.out.println(Arrays.toString(result2));
		//[1, 2, 3, 4, 5, 6]

		System.out.println(Arrays.toString(result3));
		//[1, 2, 3, 4, 5, 6, 7, 8, 9]
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
