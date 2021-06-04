package main;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import main.JOP;

public class Tracker {
	//This class helps manage the visuals and the list
	private boolean running = true;
	private List _l = new List();

	
	public Tracker() {
		while(running) {

			int action = JOptionPane.showConfirmDialog(null,
					"Yes = Create a hiker, location, and duratiaon or remove a rider."
					+ "\n No = See the list"
		            + "\n Cancel = Exit",
		            "Hiking Club",
		            JOptionPane.YES_NO_CANCEL_OPTION);
			if(action == JOptionPane.YES_OPTION){
				ManageList();
			}else if(action == JOptionPane.NO_OPTION){
				ViewStats();
			}
			else if(action == JOptionPane.CANCEL_OPTION) {
				JOP.msg("Bye");
				running = false;
			}
			else{
				JOP.msg("Bye");
				running = false;
			
			}
		}
	}
	

	//This method creates a pop out to ask what you want to do
	private void ManageList() {
		String manageChoice = JOP.in("Write 'add' to create a new location and 'remove' to remove a location");
		if(manageChoice.equalsIgnoreCase("add")) {
			String name = JOP.in("Hiker's name?");
			String location = JOP.in("Hiking location?");
			String duration = JOP.in("Hiking duration?");
			_l.addHike(name, location, duration);
		}
		else if(manageChoice.equalsIgnoreCase("remove")) {
			String name = JOP.in("What is the name of the hiker you wish to remove?");
			_l.removeHiker(name);
		}

	}
	//This method creates a pop out that displays the stats of the hikes
	private void ViewStats() {
		String viewChoice = JOP.in("To see the list type 'list' and to see the durations write 'duration'");
		if(viewChoice.equals("list")) {
			
			JOP.msg(_l.listAll());
		}
		else if(viewChoice.equals("duration")) {
			String durationChoice = JOP.in("If you want to search by name then type 'name' or /n if you want to search by location type 'location'.");
			if(durationChoice.equalsIgnoreCase("name")) {
				String name = JOP.in("hiker name?");
				JOP.msg(_l.totalDurationName(name));
			}
			else if (durationChoice.equalsIgnoreCase("location")) {
				String location = JOP.in("hike location?");
				JOP.msg(_l.totalDurationLocation(location));
			}
			
		}
	}
}
