package java8.converter;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import common.consts.CommonConst;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConvertListToMap {
	List<Hosting> list;

	@Before
	public void init(){
		list = new ArrayList<>();
		list.add(new Hosting(1, "liquidweb.com", 80000));
		list.add(new Hosting(2, "linode.com", 90000));
		list.add(new Hosting(3, "digitalocean.com", 120000));
		list.add(new Hosting(4, "aws.amazon.com", 200000));
		list.add(new Hosting(5, "mkyong.com", 1));
	}
	
	@Test
	public void test1_Classic() {
		log.info(CommonConst.title, "test1_Classic");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test2_ListObjectToMap(){
		log.info(CommonConst.title, "test2_ListObjectToMap");
		// key = id, value - websites
		Map<Integer, String> result1 = list.stream()
			.collect(Collectors.toMap(Hosting::getId, Hosting::getName));
		System.out.println("Result 1 : " + result1);
		
		// key = name, value - websites
		Map<String, Long> result2 = list.stream()
			.collect( Collectors.toMap(Hosting::getName, Hosting::getWebsites));
		System.out.println("Result 2 : " + result2);

		// Same with result1, just different syntax
		// key = id, value = name
		Map<Integer, String> result3 = list.stream()
			.collect( Collectors.toMap(x -> x.getId(), x -> x.getName()));
		System.out.println("Result 3 : " + result3);
		log.info(CommonConst.line);
	}
	
	@Test
	//Run below code, and duplicated key errors will be thrown!
	public void test3_Error_ListObjectToMap_DuplicatedKey(){
		log.info(CommonConst.title, "test3_ListObjectToMap_DuplicatedKey");
		list.add(new Hosting(6, "linode.com", 100000)); // new line
		// key = name, value - websites , but the key 'linode' is duplicated!?
		Map<String, Long> result1 = list.stream()
			.collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites));
		System.out.println("Result 1 : " + result1);
		log.info(CommonConst.line);
	}
	
	@Test
	//duplicated key errors 처리 방법
	//(oldValue, newValue) -> oldValue 추가 : 중복된 키가 있다면 기존키를 유지하겠다.
	public void test4_Suc_ListObjectToMap_DuplicatedKey(){
		log.info(CommonConst.title, "test4_");
		list.add(new Hosting(6, "linode.com", 100000));
		Map<String, Long> result1 = list.stream()
			.collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites,
					(oldValue, newValue) -> oldValue)
		);
		System.out.println("Result 1 : " + result1);
		log.info(CommonConst.line);
	}
	
	@Test
	//duplicated key errors 처리 방법
	//(oldValue, newValue) -> oldValue 추가 : 중복된 키가 있다면 신규키로 덥어쓰겠다.
	public void test5_Suc_ListObjectToMap_DuplicatedKey(){
		log.info(CommonConst.title, "test5_");
		list.add(new Hosting(6, "linode.com", 100000));
		Map<String, Long> result1 = list.stream()
			.collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites,
					(oldValue, newValue) -> newValue)
		);
		System.out.println("Result 1 : " + result1);
		log.info(CommonConst.line);
	}
	
	
	@Test
	public void test6_ListObjectSort_Collect_ReturnLinkedHashMap(){
		log.info(CommonConst.title, "test6_ListObjectSort_Collect_ReturnLinkedHashMap");
		Map result1 = list.stream()
			.sorted(Comparator.comparingLong(Hosting::getWebsites).reversed())
			.collect(
				Collectors.toMap(
					Hosting::getName, Hosting::getWebsites,		// key = name, value = websites
					(oldValue, newValue) -> oldValue,			// if same key, take the old key
					LinkedHashMap::new							// returns a LinkedHashMap, keep order
		));
		System.out.println("Result 1 : " + result1);
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
