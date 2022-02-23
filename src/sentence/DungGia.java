package sentence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import data.CoPhieuData;

public class DungGia extends Sentence{
	private File myObj = new File("D://Games//Java//Stock//src//sentence//model//DungGia.txt");
	private ArrayList<String> fileString = new ArrayList<String>();
	private CoPhieuData cpdt = new CoPhieuData();

	public DungGia() throws IOException {
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
		for (int i = 7;i < 18;i++) {
			String str1 = str;
			str1 = str1.replaceFirst("<stockCode>", cpdt.getStockID().get(i));
			str1 = str1.replaceFirst("<stockCode>", cpdt.getStockID().get(i + 1));
			Integer min = Math.min(cpdt.getVolume().get(i), cpdt.getVolume().get(i + 1));
			str1 = str1.replaceFirst("<stockVolume>", min.toString());
			Integer max = Math.max(cpdt.getVolume().get(i), cpdt.getVolume().get(i + 1));
			str1 = str1.replaceFirst("<stockVolume>", max.toString());
			fileString.add(str1);
		}
	}
	
	public void setSentence2(String str) {
		String str1 = str;
		for(int i = 0; i < 4; i++)
		{
			str1 = str1.replaceFirst("<stockCode>", cpdt.getStockID().get(i));
		}	
		fileString.add(str1);			
	}
	
	public void setSentence3(String str) {
		String str1 = str;
		for(int i = 5; i < 7; i++)
		{
			str1 = str1.replaceFirst("<stockCode>", cpdt.getStockID().get(i));
		}	
		Integer min = Math.min(cpdt.getVolume().get(5), cpdt.getVolume().get(6));
		str1 = str1.replaceFirst("<stockVolume>", min.toString());
		Integer max = Math.max(cpdt.getVolume().get(5), cpdt.getVolume().get(6));
		str1 = str1.replaceFirst("<stockVolume>", max.toString());
		fileString.add(str1);			
	}
}
