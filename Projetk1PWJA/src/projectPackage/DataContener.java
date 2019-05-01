package projectPackage;

public class DataContener extends AbstractObject {
		String cityName;
		String tempValue;
		String windSpeed;
		String country;
		String time;
		 
		public DataContener() {
			super();
			cityName = "undefined";			
		}
		
		
		public DataContener(String cityName,  String tempValue, String windSpeed, String country,String time) {
			super();			
			this.cityName = cityName;
			this.tempValue = tempValue;
			this.windSpeed = windSpeed;
			this.country = country;
			this.time = time;
		}
		public void setCity(String cityName) {
			String oldValue = this.cityName;
			firePropertyChange("cityName", oldValue, cityName);
			this.cityName = cityName;
		}
		
		public void setTemp(String tempValue) {
			String oldValue = this.tempValue;
			firePropertyChange("tempValue", oldValue, tempValue);
			this.tempValue = tempValue;
		}
		
		public void setWind(String windSpeed) {
			String oldValue = this.windSpeed;
			firePropertyChange("windSpeed", oldValue, windSpeed);
			this.windSpeed = windSpeed;
		}
		
		public void setCountry(String country) {
			String oldValue = this.country;
			firePropertyChange("country", oldValue, country);
			this.country = country;
		}
		
		public void setTime(String time) {
			String oldValue = this.time;
			firePropertyChange("time", oldValue, time);
			this.time = time;
		}
		
		public String getCity() {
			return cityName;
		}
			
		public String getTemp() {
			return tempValue;
		}
		
		public String getWind() {
			return windSpeed;
		}
		
		public String getCountry() {
			return country;
		}
		
		public String getTime() {
			return time;
		}
		
}
