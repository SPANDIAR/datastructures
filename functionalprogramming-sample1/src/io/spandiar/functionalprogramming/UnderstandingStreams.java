package io.spandiar.functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UnderstandingStreams {

	public static void main(String[] args) {
		
		List<Integer> mixedList = Arrays.asList(12, 3, 5, 16, 21, 27, 36);
		List<Integer> oddList = new ArrayList<>();
		List<Integer> evenList = new ArrayList<>();
		
		/*
		 * for(Integer mixed: mixedList) {
		 * 
		 * if(mixed % 2 == 0) { evenList.add(mixed); } else { oddList.add(mixed); } }
		 */
		
		evenList = mixedList.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
		oddList = mixedList.stream().filter(num -> num % 2 == 1).collect(Collectors.toList());
		
		System.out.println("Even List is: " + evenList);
		System.out.println("Odd List is: " + oddList);
	}
	
	public static boolean isEven(Integer checkIfEven) {
		return(checkIfEven % 2 == 0);
	}
}
