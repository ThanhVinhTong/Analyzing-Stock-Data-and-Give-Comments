package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CoPhieuData {
	private ArrayList<String> StockID = new ArrayList<String>();
	private String date = "29/04/2021";
	private ArrayList<Float> Open = new ArrayList<Float>();
	private ArrayList<Float> High = new ArrayList<Float>();
	private ArrayList<Float> Low = new ArrayList<Float>();
	private ArrayList<Float> Close = new ArrayList<Float>();
	private ArrayList<Integer> Volume = new ArrayList<Integer>();
	private ArrayList<Float> totalTrade = new ArrayList<Float>();
	private File myObj = new File("D://Games//Java//Stock//src//data//data.txt");
	
	public String getDate() {
		return date;
	}
	
	public ArrayList<Float> getTotalTrade() {
		return totalTrade;
	}
	
	public ArrayList<String> getStockID() {
		return StockID;
	}
	
	public ArrayList<Float> getOpen() {
		return Open;
	}
	
	public ArrayList<Float> getHigh() {
		return High;
	}
	
	public ArrayList<Float> getLow() {
		return Low;
	}
	
	public ArrayList<Float> getClose() {
		return Close;
	}
	
	public ArrayList<Integer> getVolume() {
		return Volume;
	}
	
	public CoPhieuData() {
		try {

			Scanner myReader = new Scanner(myObj);
			myReader.nextLine();
			
		    while (myReader.hasNextLine()) {
		    	String Line = myReader.nextLine();
		    	String[] tempString = Line.split(" ",8);
		    	
		    	StockID.add(tempString[0]);
		    	Open.add(Float.parseFloat(tempString[2]));
		    	High.add(Float.parseFloat(tempString[3]));
		    	Low.add(Float.parseFloat(tempString[4]));
		    	Close.add(Float.parseFloat(tempString[5]));
		    	Volume.add(Integer.parseInt(tempString[6]));
		    	totalTrade.add(Float.parseFloat(tempString[7]));
		    }
		    
		    myReader.close();
		    
		} catch (FileNotFoundException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}
}
