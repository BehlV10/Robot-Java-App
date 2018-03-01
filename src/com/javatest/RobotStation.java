package com.javatest;

import com.javatest.Robots.Robot;

public class RobotStation {
	private Robot robot;
	private boolean didRemovePackage = false;

	public RobotStation(Robot robot) {
		this.robot = robot;
	}

	public void packageReady(Item item) throws Exception {
		didRemovePackage = false;
		if(robot.canLift(item)) {
			didRemovePackage = true;
			robot.pickUp(item);
			robot.deliver();
		}
	}

	public boolean wasPackageRemoved() {
		return didRemovePackage;
	}
}
