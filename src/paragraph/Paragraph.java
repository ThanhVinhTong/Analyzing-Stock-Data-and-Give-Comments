package paragraph;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Paragraph {

	public Paragraph() throws IOException {
		SpawnParagraph sp = new SpawnParagraph();
		sp.filterTag();
		
		File myObj = new File("D://Games//Java//Stock//src//data//paragraph.txt");
		try {
			BufferedWriter out = new BufferedWriter(
					   new OutputStreamWriter(
			                      new FileOutputStream(myObj), "UTF8"));
			
			for (String i:sp.getSentence()) {
				if (sp.getSentence().indexOf(i)<10) {
					out.append(i);
				}
			}
			
			out.close();
		} catch (FileNotFoundException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}
}