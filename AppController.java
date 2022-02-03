package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.*;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class AppController {
	@FXML
	private Button btnsearch;
	@FXML
	public TextField tfName;
	@FXML
	public TextField tfAge;
	@FXML
	public TextField tfNumber;
	@FXML
	public TextField tfEmail;
	@FXML
	private Label lblName;
	@FXML
	private Label lblAge;
	@FXML
	private Label lblNumber;
	@FXML
	private Label lblEmail;

	// Event Listener on Button[#btnsearch].onAction
	@FXML
	public void searchdata(ActionEvent event)throws NotFoundException {
		database connectnow= new database();
		Connection connected= connectnow.getConnection();
		String sql="Select * from form where number='"+tfNumber.getText()+"'";
		try {
			Statement stmt=connected.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
			 tfName.setText(rs.getString("name"));
			 tfAge.setText(rs.getString("age"));
			 tfEmail.setText(rs.getString("email"));
						 // String lastName = rs.getString("last_name");
			//lblout.setText("Deleted successfully");
		}
			else{  tfAge.setText("");
		           tfEmail.setText("");
				throw new NotFoundException("not found");
			      }}
			
			catch (Exception e) {
			e.printStackTrace();
			tfName.setText("not found");
		}
	}
	public void notfound(ActionEvent event) {
		try{searchdata(event);}
		catch(NotFoundException e) {
			tfName.setText("not found");
		}
		
	}

	public boolean searchdata1(ActionEvent event,TextField N)throws NotFoundException {
		database connectnow= new database();
		Connection connected= connectnow.getConnection();
		String sql="Select * from form where number='"+N.getText()+"'";
		try {
			Statement stmt=connected.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				return true;}
			else{return false;}}
			catch(Exception e) {
				return false;}
			
			}
	public boolean validate_name(ActionEvent event, TextField name){//, TextField age, TextField enrollment, TextField email) {
		return name.getText().matches( "^[\\p{L} .'-]+$" );
	}
	public boolean validate_age(ActionEvent event, TextField age){
		if(age.getText()!="") { 
		
		int n= Integer.parseInt(age.getText());
		if(n>5 && n<85) return true;
		else return false;
	} else return false;}
	public boolean validate_email(ActionEvent event, TextField email){
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[\\a-zA-Z]{2,6}";
		Pattern pattern = Pattern.compile(regex);
		if (email == null)
		return false;
		return pattern.matcher(email.getText()).matches();
	}
	
	public boolean validate_enrollment(ActionEvent event, TextField number){
		String s= number.getText().toLowerCase();
		int f=0;
		try{
		    if(s.substring(0,2).equals("bt")) {
		            
					if(Integer.parseInt(s.substring(2,4))>0) {
					        
							if(s.substring(4,7).equals("hcs")|| s.substring(4,7).equals("gcs")||s.substring(4,7).equals("gbt")|| s.substring(4, 7).equals("hec")|| s.substring(4,7).equals("gec")) {
									
									if(Integer.parseInt(s.substring(7,10))>0) 
											{
											f=1;}}}
							}
					
			}
			catch(Exception e)
			{System.out.println("wrong value");}
		try{
		    if(s.substring(0,2).equals("im")) {
		            
					if(Integer.parseInt(s.substring(2,4))>0) {
					        
							if(s.substring(4,7).equals("hmg")|| s.substring(4,7).equals("gmg")) {
									
									if(Integer.parseInt(s.substring(7,10))>0) 
											{
											f=1;}}}
							}
					
			}
			catch(Exception e)
			{System.out.println("wrong value");}
		if(f==0) return false;
		else return true;
						}
				
			
		
	}
class NotFoundException extends Exception {
	 
    public NotFoundException(String message) {
        super(message);
    }
}
