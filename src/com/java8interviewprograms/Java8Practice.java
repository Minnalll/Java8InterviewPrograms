package com.java8interviewprograms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Practice {
	

	public static void main(String[] args) {
//		non-repeating alphabet from aabbeeefhi	
		String str = "aabbeeefhi";
		List<String> collect = Arrays.stream(str.split("")).collect(Collectors
				.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet()
		.stream()
		.filter(x->x.getValue()==1)
		.map(Map.Entry::getKey)
		.collect(Collectors.toList());		
		System.out.println(collect);
		
//		Write java8 code to find sum of square of even no. from following 222,25,46,17,28,33,70		
		Integer [] arr = {222,25,46,17,28,33,70};
		
		List<Integer> li = Arrays.stream(arr).filter(x-> x%2==0).collect(Collectors.toList());
		Integer summ = li.stream().collect(Collectors.summingInt(Integer::intValue));
		System.out.println(summ);
		
//		input = {u1d2a3y4a5} output ={udaya12345}
		String input = "u1d2a3y4a5";
        String output = input.chars()
                .filter(c -> !Character.isDigit(c))
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        
        String output1 = input.chars()
                .filter(c -> Character.isDigit(c))
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
  
            System.out.println(output+output1);				
		
//		To find the list of elements starting with 1
		List<Integer> li1 = Arrays.asList(11, 18, 20, 24, 85, 66, 13); 
		List<String> collect1 = li1.stream().map(e->e+"")
		.filter(e->e.startsWith("1"))
		.collect(Collectors.toList());
		System.out.println(collect1);
		
	
//  	find first non repeat element from a string
		String str2 = "aabbeeefhi";
		String key = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(x->x.getValue()==1).findFirst().get().getKey();
		System.out.println(key);
		
//	  	Second highest number
		int [] num = {5,9,11,2,8,21,1};
		Integer integer = Arrays.stream(num).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList())
				.stream().skip(1).findFirst().get();
		System.out.println(integer);
		
//      to find longest string from given array
		String [] str1 = {"java","techie","springboot","microservices"};		
		String string = Arrays.stream(str1).reduce((word1,word2)->word1.length() >word2.length()?word1:word2).get();
		System.out.println(string);
		
//		create a simple list filter all expect 1 or 2
		List<String> city = Arrays.asList("Chennai", "Bombay", "Bangalore", "Delhi");	    		
    		List<String> collect2 = city.stream()
    				.filter(x->(!x.equals("Chennai"))&&(!x.equals("Bombay")))
    				.collect(Collectors.toList());	
    		System.out.println(collect2);
    		
//    	to find duplicate elements in a given integers list in java using Stream functions
    		 List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
             Set<Integer> set = new HashSet();
             myList.stream()
                   .filter(n -> !set.add(n))
                   .forEach(System.out::print);
             
//       to find the total number of elements present in the list using Stream functions
             List<Integer> myList1 = Arrays.asList(10,15,8,49,25,98,98,32,15);
             long count =  myList.stream().count();
             System.out.println(count); 
             
//       to the maximum value element present in it using Stream functions
             List<Integer> myList2 = Arrays.asList(10,15,8,49,25,98,98,32,15);
             Integer integer2 = myList2.stream().sorted().skip(1).limit(2).findFirst().get();
             System.out.println("Find First : " + integer2);
             
//         to find the first non-repeated character in it using Stream functions
             String input1 = "Java Hungry Blog Alive is Awesome";
             input1.chars().map(x->Character.toLowerCase(x)).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    		
	}
}
