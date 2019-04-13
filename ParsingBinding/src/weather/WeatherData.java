package weather;


public class WeatherData {
	String cityName;
	String tempValue;
	String windSpeed;
	String country;
	String time;
	public WeatherData() {
		super();
		cityName = "undefined";
	}
	
	public WeatherData(String cityName,  String tempValue, String windSpeed, String country,String time) {
		super();
		this.cityName = cityName;
		this.tempValue = tempValue;
		this.windSpeed = windSpeed;
		this.country = country;
		this.time = time;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public void setTempValue(String tempValue) {
		this.tempValue = tempValue;
	}
	
	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getCityName() {
		return cityName;
	}
		
	public String getTempValue() {
		return tempValue;
	}
	
	public String getWindSpeed() {
		return windSpeed;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getTime() {
		return time;
	}
	
	
}
