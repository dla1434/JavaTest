package java8.stream.filter;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javaOld.consts.CommonConst;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Filter_FindAny_orElse {
	List<Person> persons = null;

	@Before
	public void init() {
		persons = Arrays.asList(
			new Person("mkyong", 30),
			new Person("jack", 20),
			new Person("lawrence", 40),
			new Person("jack", 50)
		);
	}

	@Test
	public void test1_Classic() {
		log.info(CommonConst.title, "test1_Classic");
		Person result = null;
		for (Person temp : persons) {
			if ("jack".equals(temp.getName())) {
				result = temp;
				break;
			}
		}
		
		System.out.println(result);
		log.info(CommonConst.line);
	}
	
	@Test
	//findAny를 선언하면 조건에 맞는 결과를 찾으면 바로 return 시켜버린다.
	//여러 개의 결과를 반환하는게 아닌 하나의 결과를 반환하기 때문이다.
	public void test2_FilterFound(){
		log.info(CommonConst.title, "test2_FilterFound");
		Person result1 = persons.stream() 					// Convert to steam
			.filter(x -> "jack".equals(x.getName())) 		// we want "jack" only
			.findAny() 										// If 'findAny' then return found
			.orElse(null); 									// If not found, return null

		System.out.println(result1);
		log.info(CommonConst.line);
	}
	
	@Test
	public void test3_FilterNotFound(){
		log.info(CommonConst.title, "test3_FilterNotFound");
		Person result2 = persons.stream()
			.filter(x -> "ahmook".equals(x.getName()))
			.findAny()
			.orElse(null);
		System.out.println(result2);
		log.info(CommonConst.line);
	}
	
	@Test
	public void test4_FilterMultiCondition(){
		log.info(CommonConst.title, "test4FilterMultiCondition");
		Person result1 = persons.stream()
			.filter((p) -> "jack".equals(p.getName()) && 20 == p.getAge())
			.findAny()
			.orElse(null);

		System.out.println("result 1 :" + result1);
		log.info(CommonConst.line);
	}
	
	
	@Test
	//test4_FilterMultiCondition과 동일한 처리인데..-> {로 멀티라인으로 선언한 방식이다.
	public void test5_FilterMultiCondition(){
		log.info(CommonConst.title, "test5_FilterMultiCondition");
		//or like this
		Person result2 = persons.stream().filter(p -> {
			if ("jack".equals(p.getName()) && 20 == p.getAge()) {
				return true;
			}
			return false;
		}).findAny().orElse(null);
		
		System.out.println("result2 :" + result2);
		
		log.info(CommonConst.line);
	}

}
