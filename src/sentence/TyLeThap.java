package sentence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import data.CoPhieuData;

public class TyLeThap extends Sentence{
	private File myObj = new File("D://Games//Java//Stock//src//sentence//model//TyLeThap.txt");
	private ArrayList<String> fileString = new ArrayList<String>();
	private CoPhieuData cpdt = new CoPhieuData();

	public TyLeThap() throws IOException {
		ArrayList<String> tempString = new ArrayList<String>();
		
		try {
			BufferedReader in = new BufferedReader(
						   new InputStreamReader(
				                 new FileInputStream(myObj), "UTF8"));
			String s;
				
			while( (s = in.readLine()) != null) {
				tempString.add(s);
			}
				
			int ran = (int) Math.floor(Math.random()*(1-0+1)+0);
			switch (ran) {
			case 0:
				setSentence1(tempString.get(0));
				break;
			case 1:
				setSentence2(tempString.get(1));
				break;
			}
			
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
		str1 = str.replaceAll("<stockCode>", cpdt.getStockID().get(10));
		str1 = str1.replaceAll("<stockVolume>", cpdt.getVolume().get(10).toString());
		str1 = str1.replaceAll("<percentage>", "0.2%");
		fileString.add(str1);
	}
		
	public void setSentence2(String str) {
		String str1;
		str1 = str.replaceAll("<stockCode>", cpdt.getStockID().get(10));
		str1 = str1.replaceAll("<percentage>", "0.2%");
		fileString.add(str1);
	}

}
