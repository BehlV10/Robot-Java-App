package com.javatest;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Conveyor {
	private static final int MAX_ROBOT_SATIONS = 3;
	LinkedHashMap<Integer, RobotStation> rSs = new LinkedHashMap<Integer, RobotStation>();
	List<Location> locations = new LinkedList<Location>();

	public void addRobotStation(RobotStation r) {
		if(rSs.size() < MAX_ROBOT_SATIONS)
		{
			rSs.put(rSs.size(), r);
		}
	}

	private void moveConveyor() throws Exception {
		for(Location location : locations) {
			location.setLocation(location.getLocation() + 1);
			if(location.getLocation() > rSs.size()) {
				throw new Exception("Package was DROPPED!");
			}
		}
	}

	public void putPackageOnConveyor(Item item) throws Exception {
		moveConveyor();
		locations.add(new Location(0, item));
	}

	public void pickupPackages() throws Exception {
		for (Map.Entry<Integer, RobotStation> entry : rSs.entrySet()) {
			Location packageToRemove = null;
			for(Location location : locations) {
				if(entry.getKey() == location.getLocation()) {
					RobotStation robotStation = entry.getValue();
					robotStation.packageReady(location.getItem());
					if(robotStation.wasPackageRemoved()) {
						packageToRemove = location;
						break;
					}
				}
			}

			if(packageToRemove != null) {
				locations.remove(packageToRemove);
			}
		}
	}

	private class Location {

		private int location;
		private Item item;

		Location(int location, Item item) {
			this.location = location;
			this.item = item;
		}

		public Item getItem() {
			return item;
		}

		public int getLocation() {
			return location;
		}

		public void setLocation(int location) {
			this.location = location;
		}
	}

}
