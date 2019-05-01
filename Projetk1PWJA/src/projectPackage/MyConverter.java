package projectPackage;

import org.jdesktop.beansbinding.Converter;
 
public class MyConverter extends Converter<String, String> {

	@Override
	public String convertForward(String arg0) {
		String result = arg0;
		return result;
	}

	@Override
	public String convertReverse(String arg0) {
		String result = arg0;
		return result;
	}
}
