package application;

import java.sql.Connection;

import com.mysql.cj.xdevapi.Statement;
//import application.AppController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DeletepageController extends AppController {
	@FXML
	private Button btndelete;
	@FXML
	private TextField tfNumber;
	@FXML
	private Label lblNumber;
	@FXML
	private Label lblout;

	// Event Listener on Button[#btndelete].onAction
	@FXML
	public void deletedata(ActionEvent event) {
		database connectnow= new database();
		Connection connected= connectnow.getConnection();
		String sql="Delete from form_entries where number='"+tfNumber.getText()+"'";
	if(validate_enrollment(event, tfNumber)){
		try{
				if(searchdata1(event,tfNumber)) {				
			try {
			java.sql.Statement stmt=connected.createStatement();
			stmt.execute(sql);
			lblout.setText("Deleted the record containing "+tfNumber.getText()+" as enrollment Number");
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
}
