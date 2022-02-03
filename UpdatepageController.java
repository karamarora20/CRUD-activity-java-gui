package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.Statement;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class UpdatepageController extends AppController {
	@FXML
	private Button btnupdate;
	@FXML
	private TextField tfName;
	@FXML
	private TextField tfAge;
	@FXML
	private TextField tfenrollment;
	@FXML
	private TextField tfEmail;
	@FXML
	private Label lblName;
	@FXML
	private Label lblAge;
	@FXML
	private Label lblNumber;
	@FXML
	private Label lblEmail;
	@FXML
	private Label lblout;

	// Event Listener on Button[#btnupdate].onAction
	@FXML
	public void updatedata(ActionEvent event) {
		String table_name= "form";
		database connectnow= new database();
		Connection connected= connectnow.getConnection();
		String sql="UPDATE "+table_name+"\r\n"
				+ "SET name ='"+ tfName.getText().toUpperCase()+"',"+ "age ='"+ tfAge.getText()+"',"+"number ='"+tfenrollment.getText().toUpperCase()+"',"+"email='"+tfEmail.getText()+"'"+"\r\n"
				+ "WHERE number='"+tfenrollment.getText()+"';";
	if(validate_enrollment(event, tfenrollment)){
		try{
				if(searchdata1(event,tfenrollment)) {				
			try {
			java.sql.Statement stmt=connected.createStatement();
			stmt.execute(sql);
			lblout.setText("Updated Successfully");
			}
		 catch (Exception e) {
			e.printStackTrace();
		}
		    }
		else lblout.setText("record notfound");
		}catch(Exception e) {
			e.printStackTrace();
			lblout.setText("no record available");
		}}
		else lblout.setText("please enter correct value");
	
	}
}/**/
