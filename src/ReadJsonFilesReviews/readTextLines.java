package ReadJsonFilesReviews;

import java.io.*;
import java.util.*;

public class readTextLines {
	
	public ArrayList<String> readLines(String fileName) throws IOException{
		ArrayList<String> lines = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(fileName);
	 
	
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
 
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			lines.add(line);
			}
		br.close();
		return lines;
	}

}
