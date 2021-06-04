package main;

import java.util.ArrayList;

public class List {
	
	private ArrayList <Info> infoList;
	private int hikeDur = 0;
	
	public List() {
		infoList = new ArrayList<Info>();
	}
	//This method adds a hike with a name, a location and the duration of the hike
	public void addHike(String hikeName, String hikeLocation, String hikeDuration) {
		hikeDur = Integer.parseInt(hikeDuration);
		if(this.infoList.size() == 0) {
			this.infoList.add(new Info(hikeName, hikeLocation, hikeDur));
		}
		else if (this.infoList.size() != 0) {
			boolean unsorted = true;
			for(int i = 0; i < this.infoList.size(); i++) {
				if(hikeName.compareToIgnoreCase(this.infoList.get(i).getName()) <= 0 && unsorted) {
					this.infoList.add(i, new Info(hikeName, hikeLocation, hikeDur));
					unsorted = false;
				}
			}
			
			if(unsorted) {
			this.infoList.add(new Info(hikeName, hikeLocation, hikeDur));
			}
		}
	}
	//This method removes a hiker
	public void removeHiker(String hikeName) {
		for(int i = this.infoList.size()- 1; i >= 0; i--) {
			if(hikeName.equalsIgnoreCase(this.infoList.get(i).getName())) {
				infoList.remove(i);
			}
		}
	}
	//This method creates a list of all the information of the hikes
	public String listAll() {
		String total = "";
		for(int i = 0; i <this.infoList.size(); i++) {
			total += "\n" + infoList.get(i).toString();
		}
		return total;
	}
	//This method gets the duration of the hike by finding the name of the hike
	public String totalDurationName(String hikeName) {
		int total = 0;
		for(int i = 0; i < this.infoList.size(); i++) {
			if(infoList.get(i).getName().equalsIgnoreCase(hikeName)) {
				total += infoList.get(i).getTime();
			}
		}
		return "" + total;
	}
	//This method gets the duration of the hike by finding the location
	public String totalDurationLocation(String hikeLocation) {
		int total = 0;
		for(int i = 0; i < this.infoList.size(); i++) {
			if(infoList.get(i).getLocation().equalsIgnoreCase(hikeLocation)) {
				total += infoList.get(i).getTime();
			}
		}
		return "" + total;
	}
}
