package advent_code_22;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4 {
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		String exemple = "2-4,6-8\r\n"
				+ "2-3,4-5\r\n"
				+ "5-7,7-9\r\n"
				+ "2-8,3-7\r\n"
				+ "6-6,4-6\r\n"
				+ "2-6,4-8";
		
		List<String> exemple2 = new ArrayList<String>(Arrays.asList(exemple.split("\r\n")));
		System.out.println(findPairsContained(exemple2));
		System.out.println(findPairsOverlap(exemple2));

		
		
		List<String> day4 = Utils.URIToArrayString(new URL("https://raw.githubusercontent.com/mmustar/advent_of_code_2022/main/advent_code_22/input/day4.txt"));
		System.out.println(findPairsContained(day4));
		System.out.println(findPairsOverlap(day4));
	}

	private static int findPairsContained(List<String> source) {
		String line;
		int sum = 0;
		for(int i=0;i<source.size();i++) {
			line = source.get(i);
			String[] pairs = line.split(",");
			if(isContainedPairs(pairs))
				sum++;
			
		}
		return sum;
	}
	
	private static int findPairsOverlap(List<String> source) {
		String line;
		int sum = 0;
		for(int i=0;i<source.size();i++) {
			line = source.get(i);
			String[] pairs = line.split(",");
			if(isOverlapPairs(pairs)) {
				sum++;
			}
			
		}
		return sum;
	}

	private static boolean isContainedPairs(String[] pairs) {
		String[] pair1 = pairs[0].split("-");
		String[] pair2 = pairs[1].split("-");
		
		return isBetween(pair1, pair2) || isBetween(pair2, pair1);
	}
	
	private static boolean isOverlapPairs(String[] pairs) {
		String[] pair1 = pairs[0].split("-");
		String[] pair2 = pairs[1].split("-");
		
		return isOverlap(pair1, pair2) || isBetween(pair2, pair1);
	}


	/**
	 * Takes 2 String[] of int and check whether an interval pair1 is contained in interval 2
	 * @param pair1 Interval 1 to be checked if in interval 2
	 * @param pair2 Interval 2 as reference
	 * @return true if pair 1 is fully contained in pair 2
	 */
	private static boolean isBetween(String[] pair1, String[] pair2) {
		int a = Integer.parseInt(pair1[0]);
		int b = Integer.parseInt(pair1[1]);
		int c = Integer.parseInt(pair2[0]);
		int d = Integer.parseInt(pair2[1]);
		
		return (a >= c && b <= d);
	}
	
	/**
	 * Takes 2 String[] of int and check whether there is an overlap of interval pair1 in interval 2
	 * @param pair1 Interval 1 to be checked if overlap with interval 2
	 * @param pair2 Interval 2 as reference
	 * @return true if pair 1 has overlap with pair 2
	 */
	private static boolean isOverlap(String[] pair1, String[] pair2) {
		int a = Integer.parseInt(pair1[0]);
		int b = Integer.parseInt(pair1[1]);
		int c = Integer.parseInt(pair2[0]);
		int d = Integer.parseInt(pair2[1]);
		
		return ((a >= c && a <= d) || (b >= c && b <= d));
	}

}
