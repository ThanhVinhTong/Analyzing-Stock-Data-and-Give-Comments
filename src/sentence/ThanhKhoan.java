package sentence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import data.CoPhieuData;

public class ThanhKhoan extends Sentence {
	private File myObj = new File("D://Games//Java//Stock//src//sentence//model//ThanhKhoan.txt");
	private ArrayList<String> fileString = new ArrayList<String>();
	private CoPhieuData cpdt = new CoPhieuData();
	
	public ThanhKhoan() throws IOException {
		ArrayList<String> tempString = new ArrayList<String>();
		
		try {
			BufferedReader in = new BufferedReader(
					   	new InputStreamReader(
			                      new FileInputStream(myObj), "UTF8"));
			String s;
			
			while( (s = in.readLine()) != null) {
				tempString.add(s);
			}
			
			int ran = (int) Math.floor(Math.random()*(2-0+1)+0);
			switch (ran) {
			case 0:
				setSentence1(tempString.get(0));
				break;
			case 1:
				setSentence2(tempString.get(1));
				break;
			case 2:
				setSentence3(tempString.get(2));
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
		str1 = str.replaceFirst("<stockCode>", cpdt.getStockID().get(0));
		str1 = str1.replaceFirst("<stockVolume>", cpdt.getVolume().get(0).toString());
		str1 = str1.replaceFirst("<stockCode>", cpdt.getStockID().get(1));
		str1 = str1.replaceFirst("<stockVolume>", cpdt.getVolume().get(1).toString());
		str1 = str1.replaceFirst("<stockCode>", cpdt.getStockID().get(2));
		str1 = str1.replaceFirst("<stockCode>", cpdt.getStockID().get(3));
		str1 = str1.replaceFirst("<stockCode>", cpdt.getStockID().get(4));
		Integer min = cpdt.getVolume().get(2);
		for(int i = 0; i < 2; i++) {
			min = Math.min(min, cpdt.getVolume().get(i + 2));
		}
		str1 = str1.replaceFirst("<stockVolume>", min.toString());
		fileString.add(str1);			
	}
	
	public void setSentence2(String str) {
		String str1;
		str1 = str.replaceFirst("<stockCode>", cpdt.getStockID().get(0));
		str1 = str1.replaceFirst("<stockCode>", cpdt.getStockID().get(1));
		Integer min = Math.min(cpdt.getVolume().get(0), cpdt.getVolume().get(1));
		str1 = str1.replaceFirst("<stockVolume>", min.toString());
		fileString.add(str1);		
	}
	
	public void setSentence3(String str) {
		String str1;
		str1 = str.replaceFirst("<stockCode>", cpdt.getStockID().get(0));
		str1 = str1.replaceFirst("<stockCode>", cpdt.getStockID().get(1));
		Integer min = Math.min(cpdt.getVolume().get(0), cpdt.getVolume().get(1));
		str1 = str1.replaceFirst("<stockVolume>", min.toString());
		fileString.add(str1);		
	}
}