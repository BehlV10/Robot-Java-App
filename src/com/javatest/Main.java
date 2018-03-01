package com.javatest;

import com.javatest.Robots.Robot;
import com.javatest.Robots.RobotImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	private static List<Item> items = new ArrayList<Item>();

    public static void main(String[] args) throws Exception {
    	RobotStation ur3 = new RobotStation(createRobot("UR3", 3.0F));
	    RobotStation ur5 = new RobotStation(createRobot("UR5", 5.0F));

	    Conveyor conveyor = new Conveyor();
	    conveyor.addRobotStation(ur3);
	    conveyor.addRobotStation(ur5);

	    for (int i = 0; i < 4; i++) {
	    	items.add(getRandomItem(0, 3));
		    items.add(getRandomItem(3, 5));
//		    items.add(getRandomItem(5, 10));
	    }

	    for (int i = 0; i < items.size(); i++) {
	    	System.out.println(items.get(i));
	    	conveyor.putPackageOnConveyor(items.get(i));
	    	conveyor.pickupPackages();
	    }
    }

	private static Robot createRobot(String robotType, float maxWeight) {
    	return new RobotImpl(robotType, maxWeight);
	}

	private static Item getRandomItem(int minWeight, int maxWeight) {
	    Random random = new Random();

	    float weight = minWeight + random.nextFloat() * (maxWeight - minWeight);
	    float height = 1 + random.nextFloat() * (9 - 1);
	    float width = 1 + random.nextFloat() * (9 - 1);
	    float depth = 1 + random.nextFloat() * (9 - 1);
	    boolean isPrivateLabel = random.nextFloat() < 0.5;
	    boolean isFragileGoods = random.nextFloat() < 0.5;

	    return new Item(weight, height, width, depth, isPrivateLabel, isFragileGoods);
    }
}
