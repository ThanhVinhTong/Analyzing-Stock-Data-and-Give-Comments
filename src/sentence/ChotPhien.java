package sentence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import data.CoPhieuData;

public class ChotPhien extends Sentence{
	private File myObj = new File("D://Games//Java//Stock//src//sentence//model//ChotPhien.txt");
	private ArrayList<String> fileString = new ArrayList<String>();
	private CoPhieuData cpdt = new CoPhieuData();
	
	public ChotPhien() throws IOException {
		ArrayList<String> tempString = new ArrayList<String>();
		
		try {
			BufferedReader in = new BufferedReader(
					   new InputStreamReader(
			                      new FileInputStream(myObj), "UTF8"));
			String s;
			
			while( (s = in.readLine()) != null) {
				tempString.add(s);
			}
			
			setSentence1(tempString.get(0));
			in.close();
		} catch (FileNotFoundException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}

	public ArrayList<String> getFileString() {
		return fileString;
	}
	
	public void setSentence1(String str) {
		String str1;
		for (int i = 0;i<cpdt.getVolume().size();i++) {
				str1 = str.replaceAll("<stockCode>", cpdt.getStockID().get(i));
				str1 = str1.replaceAll("<date>", cpdt.getDate());
				str1 = str1.replaceAll("<close>", cpdt.getClose().get(i).toString() + " nghìn");
				fileString.add(str1);
		}
	}
}