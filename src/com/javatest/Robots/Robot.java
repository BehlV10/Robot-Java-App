package com.javatest.Robots;

import com.javatest.Item;

public interface Robot {
	boolean canLift(Item item);
	void pickUp(Item item) throws Exception;
	Item deliver();
}
