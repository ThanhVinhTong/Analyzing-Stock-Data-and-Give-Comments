package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import paragraph.Paragraph;

public class MenuController implements UnicodeWritable{
	
	private Parent root;
	private String tagShow = "";
	private ArrayList<String> tags = new ArrayList<String>();
	private String fileNameStockCode = "D://Games//Java//Stock//src//data//inputData.txt";
	private String fileNameStockStatus = "D://Games//Java//Stock//src//data//TagStatus.txt";
	private String fileNameParagraph = "D://Games//Java//Stock//src//data//paragraph.txt";
	
	@FXML
	private TextArea tagRepresent = new TextArea();
	
	@FXML
    private TextArea SentencesRepresent = new TextArea();
    
    @FXML
    public void chooseTag(MouseEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("chooseTag.fxml"));
    	root = (Parent)loader.load();

    	Scene secondScene = new Scene(root);
    	
    	// New window (Stage)
    	Stage newWindow = new Stage();
    	newWindow.setTitle("Tags Window");
    	newWindow.setScene(secondScene);
    	newWindow.show();
    }

    @FXML
    public void removeAllTag(MouseEvent event) {
    	
    	List<String> lines = Arrays.asList("Tags sẽ ở đây");
    	writeUnicodeJava11(fileNameStockStatus, lines );
    	
    	try {
    		FileWriter myWriter = new FileWriter(fileNameStockCode);
    		myWriter.write(" Tags Will Go Here");
    		myWriter.close();	
    	} catch (IOException e) {
    		
    	}
    	
    	tagRepresent.setText("");
    }

    @FXML
    public void spawnSentence(MouseEvent event) throws IOException {
    	
    	Paragraph p = new Paragraph();
    	SentencesRepresent.setWrapText(true);
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(
			    new FileInputStream(fileNameParagraph), "UTF-8"));
    	String str = br.readLine();
    	
    	br.close();
    	
    	SentencesRepresent.setText(str);
    }
    
    public void updateTag(ArrayList<String> tag) {
    	
    	for(int i=0; i<tag.size(); i++) {
    		tags.add(tag.get(i));
    	}
    	
    	try {
    		FileWriter myWriter = new FileWriter(fileNameStockCode);
    		myWriter.write(getTag());
    		myWriter.close();
    	} catch (IOException e) {		
    	}
	}
    
	public void printTag() throws UnsupportedEncodingException, FileNotFoundException {
    	
		// Scanning TagStatus.txt
    	tagShow = "";
    	BufferedReader br = new BufferedReader(new InputStreamReader(
    			    new FileInputStream(fileNameStockStatus), "UTF-8"));
    	
    	// Scanning inputData.txt 
    	String temp[] = {""};
    	
    	try {
    		File myObj = new File(fileNameStockCode);
    		
    		Scanner myReader = new Scanner(myObj);
    		while (myReader.hasNextLine()) {
    			String data = myReader.nextLine();
    			temp = data.split(" ");
    		}
    		myReader.close();
    	} catch (FileNotFoundException e) {
        }
    	
    	for(int i=0; i<temp.length; i++) {
    		tagShow += ("#" + temp[i] + "   ");
    		if(i%10==0 && i>0) {
    			tagShow += "\n";
    		}		
    	}
    	
    	// Present All Used Tags to window
    	try {
    		String str = br.readLine();
    		if(str != null) {
    			tagRepresent.setText("#" + str + "   " + tagShow);
    		} else {
    			tagRepresent.setText(tagShow);
    		}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    public String getTag() {
		
		String result="";
		for(int i=0; i<tags.size(); i++) {
			result += (tags.get(i)+ " ");
		}

		return result;
	}
    
    public void writeUnicodeJava11(String fileName, List<String> lines) {

        try (FileWriter fw = new FileWriter(new File(fileName), StandardCharsets.UTF_8);
             BufferedWriter writer = new BufferedWriter(fw)) {

            for (String line : lines) {
                writer.append(line);
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
