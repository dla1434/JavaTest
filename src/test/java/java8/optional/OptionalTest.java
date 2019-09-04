package java8.optional;


import java.util.Optional;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javaOld.consts.CommonConst;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OptionalTest {
	@Before
	public void init(){
		
	}
	
	@Test
	public void test1_Classic() {
		log.info(CommonConst.title, "test1_Classic");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test2_Optionalof(){
		log.info(CommonConst.title, "test2_Optionalof");
		Optional<String> gender = Optional.of("MALE");

		System.out.println("Non-Empty Optional:" + gender);
		System.out.println("Non-Empty Optional: Gender value : " + gender.get());

		// java.lang.NullPointerException
		String answer2 = null;
		System.out.println("ofNullable on Non-Empty Optional: " + Optional.of(answer2));
		log.info(CommonConst.line);
	}
	
	@Test
	public void test3_OptionalofNullable(){
		log.info(CommonConst.title, "test3_OptionalofNullable");
		String answer1 = "Yes";
		String answer2 = null;
		
		System.out.println("Empty Optional: " + Optional.empty());
		System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
		System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2));

		log.info(CommonConst.line);
	}
	
	@Test
	public void test4_Optional_Map_flatMap(){
		log.info(CommonConst.title, "test4_");
		Optional<String> nonEmptyGender = Optional.of("male");
		Optional<String> emptyGender = Optional.empty();

		System.out.println("Non-Empty Optional:: " + nonEmptyGender.map(String::toUpperCase));
		System.out.println("Empty Optional    :: " + emptyGender.map(String::toUpperCase));

		Optional<Optional<String>> nonEmptyOtionalGender = Optional.of(Optional.of("male"));
		System.out.println("Optional value   :: " + nonEmptyOtionalGender);
		System.out.println("Optional.map     :: " + nonEmptyOtionalGender.map(gender -> gender.map(String::toUpperCase)));
		System.out.println("Optional.flatMap :: " + nonEmptyOtionalGender.flatMap(gender -> gender.map(String::toUpperCase)));
		log.info(CommonConst.line);
	}
	
	@Test
	public void test5_OptionalFilter(){
		log.info(CommonConst.title, "test5_OptionalFilter");
		// Filter on Optional
		Optional<String> gender = Optional.of("MALE");
		System.out.println(gender.filter(g -> g.equals("male")));				// Optional.empty
		System.out.println(gender.filter(g -> g.equalsIgnoreCase("MALE")));		// Optional[MALE]
		
		// Optional.empty
		Optional<String> emptyGender = Optional.empty();
		System.out.println(emptyGender.filter(g -> g.equalsIgnoreCase("MALE")));
		log.info(CommonConst.line);
	}
	
	@Test
	public void test6_OptionalisPresent(){
		log.info(CommonConst.title, "test6_OptionalisPresent");
		Optional<String> gender = Optional.of("MALE");
		if (gender.isPresent()) {
			System.out.println("Value available.");
		} else {
			System.out.println("Value not available.");
		}
		log.info(CommonConst.line);
	}
	
	@Test
	public void test7_OptionalifPresent(){
		log.info(CommonConst.title, "test7_OptionalifPresent");
		Optional<String> gender = Optional.of("MALE");
		gender.ifPresent(g -> System.out.println("In gender Option, value available."));

		// condition failed, no output print
		Optional<String> emptyGender = Optional.empty();
		emptyGender.ifPresent(g -> System.out.println("In emptyGender Option, value available."));
		log.info(CommonConst.line);
	}
	
	@Test
	public void test8_OptionalorElse(){
		log.info(CommonConst.title, "test8_OptionalorElse");
		Optional<String> gender = Optional.of("MALE");
		Optional<String> emptyGender = Optional.empty();

		System.out.println(gender.orElse("<N/A>"));					// MALE
		System.out.println(emptyGender.orElse("<N/A>"));			// <N/A>

		log.info(CommonConst.line);
	}
	
	@Test
	public void test9_OptionalorElseGet(){
		log.info(CommonConst.title, "test9_OptionalorElseGet");
		Optional<String> gender = Optional.of("MALE");
		Optional<String> emptyGender = Optional.empty();
		
		System.out.println(gender.orElseGet(() -> "<N/A>"));		// MALE
		System.out.println(emptyGender.orElseGet(() -> "<N/A>"));	// <N/A>
		log.info(CommonConst.line);
	}
	
	@Test
	public void test10_OptionalifPresent(){
		log.info(CommonConst.title, "test7_OptionalifPresent");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test11_OptionalifPresent(){
		log.info(CommonConst.title, "test7_OptionalifPresent");
		log.info(CommonConst.line);
	}
}
