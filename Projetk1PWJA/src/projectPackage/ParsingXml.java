package projectPackage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
  

public class ParsingXml {

	public static DataContener getWeatherInformation(String cityName ) {
		DataContener newData = new DataContener();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = null;
		
		try {
			saxParser = factory.newSAXParser();
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		} catch (SAXException e1) {
			e1.printStackTrace();
		}
		
		DefaultHandler handler = new DefaultHandler() {
			boolean bName = false;
			
			public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException{
				if (qName.equalsIgnoreCase("city")) {
					newData.setCity(attributes.getValue("name"));
					bName= true;
				}
				if (qName.equalsIgnoreCase("temperature")) {
					newData.setTemp(attributes.getValue("value"));
				}
				if (qName.equalsIgnoreCase("speed")) {
					newData.setWind(attributes.getValue("value"));
				}
				}
		
			public void endElement(String uri, String localName, String qName)
				throws SAXException{
				}
			
			public void characters(char ch[], int start, int lenght) 
				throws SAXException{
				
				if(bName) {
					newData.setCountry(new String(ch, start, lenght));
					bName=false;
				}
			
			}
		};
		
		 String weatherXmlUrl = 
				"http://api.openweathermap.org/data/2.5/weather?q="+ cityName +"&mode=xml&apikey=ab3a3a4743c325386addd4cfe19adfba";
		 
		 try {
			saxParser.parse(weatherXmlUrl, handler);
		} catch (SAXException e) {
			return newData;
		} catch (IOException e) {
			return newData;
		}
			Calendar cal = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	        newData.setTime(sdf.format(cal.getTime()));
		 
		return newData;
		 
	}
	
}
