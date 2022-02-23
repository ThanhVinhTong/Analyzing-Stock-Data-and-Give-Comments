package ui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class ChooseTagController implements UnicodeWritable{
	
	private ArrayList<String> tags = new ArrayList<String>();
	
	private String[] item = {"Tang", "Giam", "Dung"};
	private String fileName = "D://Games//Java//Stock//src//data//TagStatus.txt";
	
	@FXML
    private CheckBox ACB;

    @FXML
    private CheckBox AMD;

	@FXML
    private CheckBox CSTB2101;

    @FXML
    private CheckBox DBC;

    @FXML
    private CheckBox DRL;

    @FXML
    private CheckBox DSN;

    @FXML
    private CheckBox GAB;

    @FXML
    private CheckBox HAH;

    @FXML
    private CheckBox HAS;

    @FXML
    private CheckBox HAX;

    @FXML
    private CheckBox HPG;

    @FXML
    private CheckBox LPB;

    @FXML
    private CheckBox ROS;

    @FXML
    private CheckBox STB;

    @FXML
    private CheckBox TAC;

    @FXML
    private CheckBox TCB;

    @FXML
    private CheckBox TEG;

    @FXML
    private CheckBox TTF;

    @FXML
    private CheckBox VHM;

    @FXML
    private CheckBox VPB;

    @FXML
    private Button Done;
    
    @FXML
    private ChoiceBox<String> StockStatus;
  
	@FXML
    void GettingEverythingDone(ActionEvent event) {
		
		clearStatusItems();
		
		String temp = StockStatus.getValue();
		List<String> lines = new ArrayList<String>();
		
		if(temp != null) {
			if(temp.equals("Tang")) {
				lines = Arrays.asList("tăng\n");
			} else if(temp.equals("Giam")) {
				lines = Arrays.asList("giảm\n");
			} else if(temp.equals("Dung")) {
				lines = Arrays.asList("đứng\n");
			}
		}
		writeUnicodeJava11(fileName, lines);

		MenuController controller = new MenuController();
		controller.updateTag(tags);
		
		Stage stage = (Stage) Done.getScene().getWindow();
	    stage.close();
    }
	
	@FXML
	void GettingACB(ActionEvent event) {
		
		if(ACB.isSelected()) {
			
			if(!tags.contains("ACB")) {
				updateTags("ACB");
			}
		} else if(!ACB.isSelected()){
			removeTags("ACB");
		}
	}

	@FXML
	void GettingAMD(ActionEvent event) {
		
		if(AMD.isSelected()) {
			
			if(!tags.contains("AMD")) {
				updateTags("AMD");
			}
		} else {
			removeTags("AMD");
		}
	}

	@FXML
	void GettingCSTB2101(ActionEvent event) {
		
		if(CSTB2101.isSelected()) {
			
			if(!tags.contains("CSTB2101")) {
				updateTags("CSTB2101");
			}
		} else {
			removeTags("CSTB2101");
		}
	}

	@FXML
	void GettingDBC(ActionEvent event) {
		
		if(DBC.isSelected()) {
			
			if(!tags.contains("DBC")) {
				updateTags("DBC");
			}
		} else {
			removeTags("DBC");
		}
	}

	@FXML
	void GettingDRL(ActionEvent event) {
		
		if(DRL.isSelected()) {
			
			if(!tags.contains("DRL")) {
				updateTags("DRL");
			}
		} else {
			removeTags("DRL");
		}
	}

	@FXML
	void GettingDSN(ActionEvent event) {
		
		if(DSN.isSelected()) {
			
			if(!tags.contains("DSN")) {
				updateTags("DSN");
			}
		} else {
			removeTags("DSN");
		}
	}

	@FXML
	void GettingGAB(ActionEvent event) {
		
		if(GAB.isSelected()) {
			
			if(!tags.contains("GAB")) {
				updateTags("GAB");
			}
		} else {
			removeTags("GAB");
		}
	}

	@FXML
	void GettingHAH(ActionEvent event) {
		
		if(HAH.isSelected()) {
			
			if(!tags.contains("HAH")) {
				updateTags("HAH");
			}
		} else {
			removeTags("HAH");
		}
	}

	@FXML
	void GettingHAS(ActionEvent event) {
		
		if(HAS.isSelected()) {
			
			if(!tags.contains("HAS")) {
				updateTags("HAS");
			}
		} else {
			removeTags("HAS");
		}
	}

	@FXML
	void GettingHAX(ActionEvent event) {
		
		if(HAX.isSelected()) {
			
			if(!tags.contains("HAX")) {
				updateTags("HAX");
			}
		} else {
			removeTags("HAX");
		}
	}

	@FXML
	void GettingHPG(ActionEvent event) {
		
		if(HPG.isSelected()) {
			
			if(!tags.contains("HPG")) {
				updateTags("HPG");
			}
		} else {
			removeTags("HPG");
		}
	}

	@FXML
	void GettingLPB(ActionEvent event) {
		
		if(LPB.isSelected()) {
			
			if(!tags.contains("LPB")) {
				updateTags("LPB");
			}
		} else {
			removeTags("LPB");
		}
	}

	@FXML
	void GettingROS(ActionEvent event) {
		
		if(ROS.isSelected()) {
			
			if(!tags.contains("ROS")) {
				updateTags("ROS");
			}
		} else {
			removeTags("ROS");
		}
	}

	@FXML
	void GettingSTB(ActionEvent event) {
		
		if(STB.isSelected()) {
			
			if(!tags.contains("STB")) {
				updateTags("STB");
			}
		} else {
			removeTags("STB");
		}
	}

	@FXML
	void GettingTAC(ActionEvent event) {
		
		if(TAC.isSelected()) {
			
			if(!tags.contains("TAC")) {
				updateTags("TAC");
			}
		} else {
			removeTags("TAC");
		}
	}

	@FXML
	void GettingTCB(ActionEvent event) {
		
		if(TCB.isSelected()) {
			
			if(!tags.contains("TCB")) {
				updateTags("TCB");
			}
		} else {
			removeTags("TCB");
		}
	}

	@FXML
	void GettingTEG(ActionEvent event) {
		
		if(TEG.isSelected()) {
			
			if(!tags.contains("TEG")) {
				updateTags("TEG");
			}
		} else {
			removeTags("TEG");
		}
	}

	@FXML
	void GettingTTF(ActionEvent event) {
		
		if(TTF.isSelected()) {
			
			if(!tags.contains("TTF")) {
				updateTags("TTF");
			}
		} else {
			removeTags("TTF");
		}
	}

	@FXML
	void GettingVHM(ActionEvent event) {
		
		if(VHM.isSelected()) {
			
			if(!tags.contains("VHM")) {
				updateTags("VHM");
			}
		} else {
			removeTags("VHM");
		}
	}

	@FXML
	void GettingVPB(ActionEvent event) {
		
		if(VPB.isSelected()) {
			
			if(!tags.contains("VPB")) {
				updateTags("VPB");
			}
		} else {
			removeTags("VPB") ;
		}
	}
	
	public void initialize() {

    	List<String> statusItems = new ArrayList<String>();
   
    	for(int i=0; i<item.length; i++) {
    		statusItems.add(item[i]);
    	}
    	
        ObservableList<String> obList = FXCollections.observableList(statusItems);
        StockStatus.getItems().clear();
        StockStatus.setItems(obList);
    }

	public void updateTags(String tag) {
		
		tags.add(tag);	
	}
	
	public void removeTags(String tag) {
		
		tags.remove(tag);
	}
	
	public void clearStatusItems() {
		
		for(int i=0; i<item.length; i++) {
			tags.remove(item[i]);
		}
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
