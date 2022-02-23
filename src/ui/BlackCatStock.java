package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BlackCatStock extends Application {
	
	private String fileName = "GetStarted.fxml";
	
	@Override
    public void start(Stage primaryStage) {
		
        try {
            // Read file fxml and draw interface.
            Parent root = FXMLLoader.load(getClass().getResource(fileName));
    		
    		primaryStage.setTitle("Black Cat Stock Application");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
