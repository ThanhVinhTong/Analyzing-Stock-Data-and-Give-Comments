package sentence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NhaDauTuNuocNgoai extends Sentence{
	private File myObj = new File("D://Games//Java//Stock//src//sentence//model//NhaDauTuNuocNgoai.txt");
	private ArrayList<String> fileString = new ArrayList<String>();
	
	public NhaDauTuNuocNgoai() throws IOException {	
		ArrayList<String> tempString = new ArrayList<String>();
		try {
			BufferedReader in = new BufferedReader(
					   new InputStreamReader(
			                      new FileInputStream(myObj), "UTF8"));
			String s;
			
			while( (s = in.readLine()) != null) {
				tempString.add(s);
			}
			
			int ran = (int) Math.floor(Math.random()*(4-0+1)+0);
			setSentence(tempString.get(ran));
			
			in.close();
		} catch (FileNotFoundException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}

	public ArrayList<String> getFileString() {
		return fileString;
	}
	
	public void setSentence(String str) {
		fileString.add(str);
	}
}