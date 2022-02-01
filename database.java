package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class database {
	public Connection databaselink;
	public Connection getConnection() {
		try {
			String database_name="java";
			String user="root";
			String password="bhaturae";
			Class.forName("com.mysql.cj.jdbc.Driver");
			databaselink= DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database_name,user,password);
		}
	catch (Exception e) {
		e.printStackTrace();}
		return databaselink;
	}
	
}



