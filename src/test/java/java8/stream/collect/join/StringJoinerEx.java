package java8.stream.collect.join;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import common.consts.CommonConst;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StringJoinerEx {
	@Before
	public void init(){
		
	}
	
	@Test
	public void test1_Classic() {
		log.info(CommonConst.title, "test1_Classic");
		log.info(CommonConst.line);
	}
	
	@Test
	public void test2_StringJoiner(){
		List<Game> list = Arrays.asList(
			new Game("Dragon Blaze", 5),
			new Game("Angry Bird", 5),
			new Game("Candy Crush", 5)
		);

		//{Dragon Blaze, Angry Bird, Candy Crush}
		String result = list.stream()
			.map(x -> x.getName())
			.collect(Collectors.joining(", ", "{", "}"));
		
		System.out.println(result);
	}
	
	class Game {
		String name;
		int ranking;

		public Game(String name, int ranking) {
			this.name = name;
			this.ranking = ranking;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getRanking() {
			return ranking;
		}

		public void setRanking(int ranking) {
			this.ranking = ranking;
		}
	}
}
