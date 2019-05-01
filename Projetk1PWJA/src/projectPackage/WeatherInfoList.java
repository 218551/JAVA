package projectPackage;

import java.util.ArrayList;
import java.util.List;

import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

 

public class WeatherInfoList extends AbstractObject{
	 
	ObservableList<DataContener> contener = 
			   ObservableCollections.observableList(
			      new ArrayList<DataContener>());
	
	WeatherInfoList(){
	}
	
	public void addData(DataContener data) {
		List<DataContener> oldValue = contener;
		contener.add(data);
		firePropertyChange("contener", oldValue,contener);
		firePropertyChange("contenerSize",oldValue.size(),contener.size());
	}
	
	public void eraseData() {
		List<DataContener> oldValue = contener;
		contener = ObservableCollections.observableList(
			      new ArrayList<DataContener>());
		firePropertyChange("contener", oldValue, contener);
		firePropertyChange("contenerSize", oldValue.size(), contener.size());
	}
	
	public void clearLastElement() {
		
		contener.remove(contener.size()-1);
	}
	
	public DataContener getLastElement() {
		DataContener newOne = contener.get(contener.size()-1);
		return newOne;
	}
	
	public List<DataContener> getContener(){
		return contener;
	}
	
	public int getContenerSize() {
		return contener.size();
	}
}
