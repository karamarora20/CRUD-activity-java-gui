package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;



public class createpageController extends AppController implements Initializable {
	@FXML
	private TextField tfname;
	@FXML
	private TextField tfage;
	@FXML
	private TextField tfnumber;
	@FXML
	private TextField tfEmail;
	@FXML
	private Label lblout;
	@FXML
	private Button btncreate;
	@FXML
	private MenuItem btngetinfo;
	@FXML
	private MenuItem btnupdate;
	@FXML
	private MenuItem btndelete;
	@FXML
	private TableView<TableController> tbdata;
	@FXML
	private TableColumn<TableController,String> colName;
	@FXML
	private TableColumn<TableController,String> colNumber;
	@FXML
	private TableColumn<TableController,String> colAge;
	@FXML
	private TableColumn<TableController,String> colEmail;

	// Event Listener on Button[#btncreate].onAction
	@FXML
	public void createdata(ActionEvent event) {
		showdata(event);
		database connectnow= new database();
		Connection connected= connectnow.getConnection();
		String sql="Insert into form_entries values ('"+tfname.getText().toUpperCase()+"','"+tfage.getText()+"','"+tfnumber.getText().toUpperCase()+"','"+tfEmail.getText()+"')";
		if(validate_age(event, tfage) && validate_email(event, tfEmail) && validate_enrollment(event, tfnumber) && validate_name(event, tfname)) 
		{
			try {
		
			java.sql.Statement stmt=connected.createStatement();
			stmt.execute(sql);
			lblout.setText("success");
		} catch (Exception e) {
			e.printStackTrace();
		}}
		else lblout.setText("please enter correct values");
		
	}
	// Event Listener on MenuItem[#btngetinfo].onAction
	@FXML
	public void openinfopage(ActionEvent event) {
try {
			
			Parent root= FXMLLoader.load(getClass().getResource("Infopage.fxml"));
			Scene scene= new Scene(root);
			Stage primaryStage= new Stage();
			primaryStage.setTitle("Information window");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			lblout.setText("Unable to open new window");
		}
		// TODO Autogenerated
	}
	// Event Listener on MenuItem[#btnupdate].onAction
	@FXML
	public void openupdatepage(ActionEvent event) {
try {
			
			Parent root1= FXMLLoader.load(getClass().getResource("Updatepage.fxml"));
			Scene scene1= new Scene(root1);
			Stage primaryStage= new Stage();
			primaryStage.setTitle("Update window");
			primaryStage.setScene(scene1);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			lblout.setText("Unable to open new window");
		}
		// TODO Autogenerated
	}
	// Event Listener on MenuItem[#btndelete].onAction
	@FXML
	public void opendeletepage(ActionEvent event) {
try {
			
			Parent root2= FXMLLoader.load(getClass().getResource("Deletepage.fxml"));
			Scene scene2= new Scene(root2);
			Stage primaryStage= new Stage();
			primaryStage.setTitle("Delete window");
			primaryStage.setScene(scene2);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			lblout.setText("Unable to open new window");
		}
		// TODO Autogenerated
	}
	public void showdata(ActionEvent event) {
		 
	}
	// Event Listener on MenuItem[#btnsearch].onAction
	
	List<TableController> li = new ArrayList<TableController>();
	ObservableList<TableController> oblist = FXCollections.observableList(li);
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// TODO Auto-generated method stub
		try{database connectnow= new database();
		Connection connected= connectnow.getConnection();
		String sql= "Select * from form_entries";
		Statement stmt=connected.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			oblist.add(new TableController(rs.getString("name"),rs.getString("number"),rs.getString("age"), rs.getString("email")));
		}
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
		colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		colNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
		tbdata.setItems(oblist);
	}
}

	// Event Listener on TableView[#tbdata].onSort
