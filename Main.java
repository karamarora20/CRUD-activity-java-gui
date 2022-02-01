package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler; 
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import javafx.scene.control.Button;

import java.io.IOException;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent root= FXMLLoader.load(getClass().getResource("create page.fxml"));
			Scene scene= new Scene(root);
			primaryStage.setTitle("App window");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}






	




 