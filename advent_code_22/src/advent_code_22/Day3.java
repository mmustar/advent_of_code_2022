package advent_code_22;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day3 {
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		String exemple = "vJrwpWtwJgWrhcsFMMfFFhFp\r\n"
				+ "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\r\n"
				+ "PmmdzqPrVvPwwTWBwg\r\n"
				+ "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\r\n"
				+ "ttgJtRGJQctTZtZT\r\n"
				+ "CrZsJsPPZsGzwwsLwLmpwMDw";
		
		List<String> exemple2 = new ArrayList<String>(Arrays.asList(exemple.split("\r\n")));
		System.out.println(findItemsInBothRucksack(exemple2));
		System.out.println(findBadges(exemple2));
		
		
		List<String> day2 = Utils.URIToArrayString(new URL("https://raw.githubusercontent.com/mmustar/advent_of_code_2022/main/advent_code_22/input/day3.txt"));
		System.out.println(findItemsInBothRucksack(day2));
		System.out.println(findBadges(day2));

	}

	private static int findItemsInBothRucksack(List<String> source) {
		
		List<String> commonItems = new ArrayList<>();
		int sum = 0;
		
		for(int i=0;i<source.size();i++) {
			String line = source.get(i);
			String first = line.substring(0, line.length() / 2);
			String end = line.substring(line.length() / 2, line.length()); 
			
			for (int j = 0; j < first.length() || j < end.length(); j++) {

				if (first.contains(Character.toString(end.charAt(j)))) {
					char c = end.charAt(j);
					commonItems.add(Character.toString(c));
					
					if((int)c > 95)
						sum += ((int)c - 96);
					else
						sum += ((int) c - 38);
					break;
				}
			}
		}
		return sum;
	}
	
private static int findBadges(List<String> source) {
		
		int sum = 0;
		
		for(int i=0;i<source.size();i = i + 3) {
			
			List<Character> one = source.get(i).chars()
				    .mapToObj(e->(char)e).collect(Collectors.toList());
			
			one.retainAll(source.get(i+1).chars()
				    .mapToObj(e->(char)e).collect(Collectors.toList()));
			
			one.retainAll(source.get(i+2).chars()
				    .mapToObj(e->(char)e).collect(Collectors.toList()));
			
			System.out.println(one);
			
			if((int)one.get(0) > 95)
				sum += ((int)one.get(0) - 96);
			else
				sum += ((int) one.get(0) - 38);
		}
		return sum;
	}

}
