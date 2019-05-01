package projectPackage;

import java.util.ArrayList;
import java.util.List;

import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

public class WeatherDbList extends AbstractObject {
 
	ObservableList<DataContener> contener = 
			   ObservableCollections.observableList(
			      new ArrayList<DataContener>());
	
	WeatherDbList(){
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
	
	public List<DataContener> getContener(){
		return contener;
	}
	
	public int getContenerSize() {
		return contener.size();
	}
}
