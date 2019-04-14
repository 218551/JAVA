package projectPackage;

import java.sql.*;

public class DatabaseConnection {

	public void queryExecution() {
		
		try {
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost/projectdatabase?"
					+ "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","TKpa55w0rd");
			Statement myStatement = myConnection.createStatement();
			ResultSet myResult = myStatement.executeQuery("select * from pracownicy");
			while(myResult.next()) {
				System.out.println(myResult.getString("nazwisko")+ ", " + myResult.getString("imie"));
			}
			
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
	}
}
