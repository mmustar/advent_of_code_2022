package advent_code_22;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Utils {
	
	public static List<String> fileToArrayString(String path) throws IOException {	
		BufferedReader abc = new BufferedReader(new FileReader(path));
		List<String> lines = new ArrayList<>();
		
		String line;

		while((line = abc.readLine()) != null) {
		    lines.add(line);
		}
		abc.close();
		
		return lines;
	}
	
	public static List<String> URIToArrayString(URL url) throws IOException {	
		URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    yc.getInputStream()));
        List<String> lines = new ArrayList<>();
		String line;

		while((line = in.readLine()) != null) {
		    lines.add(line);
		}
		in.close();
		
		return lines;
	}
	
	public static List<Integer> fileToArrayInt(String path) throws IOException {
		BufferedReader abc = new BufferedReader(new FileReader(path));
		List<Integer> lines = new ArrayList<>();
		
		String line;

		while((line = abc.readLine()) != null) {
		    lines.add(Integer.valueOf(line));
		}
		abc.close();
		
		return lines;
	}
}
