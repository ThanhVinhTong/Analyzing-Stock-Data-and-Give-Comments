package ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GetStartedController {
	
	private Stage newWindow;
	private Scene secondScene;
    private Parent root;
    private String fileMenu = "Menu.fxml";
    
	@FXML
    void startMenu(MouseEvent event) {
		
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource(fileMenu));
    		root = loader.load();

    		// New window (Stage)
    		newWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		secondScene = new Scene(root);
    		newWindow.setScene(secondScene);
    		newWindow.show();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
