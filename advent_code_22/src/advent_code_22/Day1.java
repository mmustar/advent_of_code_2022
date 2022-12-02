package advent_code_22;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day1 {
	
	private static int mostCarriedCalories(List<String> source) {
		int bestSum = 0;
		int sum2 = 0;
		
		for(int i=1;i<source.size();i++) {
			if(source.get(i).isEmpty() || i == source.size()-1) {
				if(sum2 > bestSum) {
					bestSum = sum2;
				}
				sum2 = 0;
			} else {
				sum2 += Integer.parseInt(source.get(i));
			}
		}
		
		System.out.println(source);
		return bestSum;
	}
	
	private static int top3Calories(List<String> source) {
		int sum = 0;
		List<Integer> list = new ArrayList<>();
		
		for(int i=1;i<source.size();i++) {
			if(!source.get(i).isEmpty()) {
				sum += Integer.parseInt(source.get(i));
			} else {
				list.add(sum);
				sum = 0;
			}	
		}
		//for last elf
		list.add(sum);
		sum = 0;
		
		Collections.sort(list);
		List<Integer> top3 = new ArrayList<Integer>(list.subList(list.size() -3, list.size()));
		
		System.out.println(top3);
		
		return top3.get(0) + top3.get(1) + top3.get(2);
	}
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		String exemple = "1000\r\n"
				+ "2000\r\n"
				+ "3000\r\n"
				+ "\r\n"
				+ "4000\r\n"
				+ "\r\n"
				+ "5000\r\n"
				+ "6000\r\n"
				+ "\r\n"
				+ "7000\r\n"
				+ "8000\r\n"
				+ "9000\r\n"
				+ "\r\n"
				+ "10000";
		
		List<String> exemple2 = new ArrayList<String>(Arrays.asList(exemple.split("\r\n")));
		System.out.println(mostCarriedCalories(exemple2));
		
		List<String> part1 = Utils.URIToArrayString(new URL("https://raw.githubusercontent.com/mmustar/advent_of_code_2022/main/advent_code_22/input/day1_part1"));
		System.out.println(mostCarriedCalories(part1));
		
		System.out.println(top3Calories(exemple2));
		
		System.out.println(top3Calories(part1));
	}

	

}
