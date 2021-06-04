package main;


import java.util.ArrayList;

public class Info {
	//This class creates the informantion of a hike
	String name;
	String location;
	int duration;
	
	public Info(String hikeName, String hikeLocation, int hikeDuration) {
		
		name = hikeName;
		location = hikeLocation;
		duration = hikeDuration;
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getLocation() {
		return location;
	}
	
	public String getDuration() {
		return duration + "";
	}
	
	public int getTime() {
		return duration;
	}
	
	public String toString() {
		return getName() + " " + getLocation() + " " + getDuration() + " ";
	}
}
