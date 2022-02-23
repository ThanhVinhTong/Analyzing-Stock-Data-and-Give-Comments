package sentence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import data.CoPhieuData;

public class TangTran extends Sentence{
	private File myObj = new File("D://Games//Java//Stock//src//sentence//model//TangTran.txt");
	private ArrayList<String> fileString = new ArrayList<String>();
	private CoPhieuData cpdt = new CoPhieuData();
	
	public TangTran() throws IOException {
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
		String str1 = str;
		for(int i = 1; i < 4; i++)
		{
			str1 = str1.replaceFirst("<stockCode>", cpdt.getStockID().get(i));
		}	
		str1 = str1.replaceFirst("<stockCode>", cpdt.getStockID().get(0));
		str1 = str1.replaceAll("<stockVolume>",cpdt.getVolume().get(0).toString());	
		fileString.add(str1);			
	}
	
	public void setSentence2(String str) {
		String str1 = str;
		for(int i = 0; i < 3; i++)
		{
			str1 = str1.replaceFirst("<stockCode>", cpdt.getStockID().get(i));
		}	
		Integer max = Math.max(cpdt.getVolume().get(5), cpdt.getVolume().get(6));
		str1 = str1.replaceFirst("<stockVolume>", max.toString());
		fileString.add(str1);			
	}
	
	public void setSentence3(String str) {	
		for (int i = 0;i < 6;i++) {
			String str1 = str;
			str1 = str1.replaceAll("<stockVolume>",cpdt.getVolume().get(i).toString());	
			str1 = str1.replaceFirst("<stockCode>", cpdt.getStockID().get(i));
			str1 = str1.replaceFirst("<stockCode>", cpdt.getStockID().get(i + 1));
			fileString.add(str1);
		}
	}
}
