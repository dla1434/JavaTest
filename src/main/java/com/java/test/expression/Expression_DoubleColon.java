package com.java.test.expression;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.java.test.expression.domain.Guest;

public class Expression_DoubleColon {
	public static void main(String[] args) {
		Guest guest1 = new Guest();
		guest1.setCompany("Company1");
		guest1.setGrade(76);
		guest1.setName("Name1");
		
		Guest guest2 = new Guest();
		guest2.setCompany("Company2");
		guest2.setGrade(80);
		guest2.setName("Name2");
		
		List<Guest> guests = new ArrayList<>();
		guests.add(guest1);
		guests.add(guest2);
		
		List<String> lists = null; 
		//축약형 : .map(Guest::getName)
		lists = findGuestNamesByCompanyType1(guests, "Company1");
		System.out.println(lists);
		
		System.out.println("-------------------------------------------------------");
		
		//미축약형 : 
		lists = findGuestNamesByCompanyType2(guests, "Company1");
		System.out.println(lists);
	}
	
	public static List<String> findGuestNamesByCompanyType1(List<Guest> guests, String company) {
		return guests.stream()
			.filter(g -> company.equals(g.getCompany()))
			.sorted(Comparator.comparing(Guest::getGrade))
			.map(Guest::getName)
			.collect(Collectors.toList());
	}
	
	public static List<String> findGuestNamesByCompanyType2(List<Guest> guests, String company) {
		return guests.stream()
			.filter(g -> company.equals(g.getCompany()))
			.sorted(Comparator.comparing(Guest::getGrade))
			.map(g -> g.getName())
			.collect(Collectors.toList());
	}
}
