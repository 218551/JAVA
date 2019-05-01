package projectPackage;

import java.sql.*;
import java.time.LocalDateTime;

  
public class DatabaseConnection {
	private static Statement myStatement=null;
	private static Connection myConnection=null;
	public static Statement dbConnect() {
		
		try {
			 myConnection = DriverManager.getConnection("jdbc:mysql://localhost/projectdatabase?"
					+ "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","pass");
			myStatement = myConnection.createStatement();
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		return myStatement;
	}


	
	public static java.util.List<DataContener> selectWeatherEntries() {
		java.util.List<DataContener> contener = new java.util.LinkedList<DataContener>();
		try {
			myStatement = myConnection.createStatement();
			ResultSet results = myStatement.executeQuery("SELECT * FROM weatherdata");
			
			while (results.next()) {
				String city = results.getString("cityName");
				String country = results.getString("countryName");
				String temperature = results.getString("tempValue");
				String speed = results.getString("windSpeed");
				String time = results.getString("time");
				DataContener entry = new DataContener(city, temperature, speed, country, time );
				contener.add(entry);
			}
			results.close();
			myStatement.close();
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}

		return contener;
	}

	public static void insertEntry( DataContener entry) {
		try {
			PreparedStatement preparedStatement = myConnection
					.prepareStatement("INSERT INTO  weatherdata  (cityName, countryName, tempValue, windSpeed, time) values (?, ?, ?, ?, ?)");
			
			preparedStatement.setString(1, entry.getCity());
			preparedStatement.setString(2, entry.getCountry());
			preparedStatement.setString(3, entry.getTemp());
			preparedStatement.setString(4, entry.getWind());
			preparedStatement.setString(5, entry.getTime());
			preparedStatement.executeUpdate();
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}
	
	public static void deleteAllDbData() {
		try {
			myStatement = myConnection.createStatement();
			myStatement.executeUpdate("DELETE FROM weatherdata");
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}
}

