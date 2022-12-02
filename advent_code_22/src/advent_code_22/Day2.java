package advent_code_22;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2 {
	
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		String exemple = "A Y\r\n"
				+ "B X\r\n"
				+ "C Z";
		
		List<String> exemple2 = new ArrayList<String>(Arrays.asList(exemple.split("\r\n")));
		System.out.println(score1(exemple2));
		
		List<String> day2 = Utils.URIToArrayString(new URL("https://raw.githubusercontent.com/mmustar/advent_of_code_2022/main/advent_code_22/input/day2"));
		System.out.println(score1(day2));
		
		System.out.println(score2(exemple2));
		System.out.println(score2(day2));
	}

	private static int score1(List<String> source) {
		
		System.out.println(source);
		
		int score = 0;
		
		for(int i=0;i<source.size();i++) {
			int lineScore = 0;
			switch (source.get(i)) {
			case "A X":
				lineScore = 1 + 3;
				break;
			case "A Y":
				lineScore = 2 + 6;
				break;
			case "A Z":
				lineScore = 3 + 0;
				break;
			case "B X":
				lineScore = 1 + 0;
				break;
			case "B Y":
				lineScore = 2 + 3;
				break;
			case "B Z":
				lineScore = 3 + 6;
				break;
			case "C X":
				lineScore = 1 + 6;
				break;
			case "C Y":
				lineScore = 2 + 0;
				break;
			case "C Z":
				lineScore = 3 + 3;
				break;
			default:
				System.out.println("NOT FOUND");
				break;
			}
			score += lineScore;
		}
		return score;
	}
	
private static int score2(List<String> source) {
		
		System.out.println(source);
		
		int score = 0;
		
		for(int i=0;i<source.size();i++) {
			int lineScore = 0;
			switch (source.get(i)) {
			case "A X":
				lineScore = 0 + 3;
				break;
			case "A Y":
				lineScore = 3 + 1;
				break;
			case "A Z":
				lineScore = 6 + 2;
				break;
			case "B X":
				lineScore = 0 + 1;
				break;
			case "B Y":
				lineScore = 3 + 2;
				break;
			case "B Z":
				lineScore = 6 + 3;
				break;
			case "C X":
				lineScore = 0 + 2;
				break;
			case "C Y":
				lineScore = 3 + 3;
				break;
			case "C Z":
				lineScore = 6 + 1;
				break;
			default:
				System.out.println("NOT FOUND");
				break;
			}
			score += lineScore;
		}
		return score;
	}

}
