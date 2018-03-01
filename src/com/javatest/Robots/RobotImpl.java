package com.javatest.Robots;

import com.javatest.Item;

public class RobotImpl implements Robot {
	private String robotType;
	private float maxWeight;
	private boolean hasItem = false;
	private Item pickedUpItem;

	public RobotImpl(String robotType, float maxWeight) {
		this.robotType = robotType;
		this.maxWeight = maxWeight;
	}

	@Override
	public boolean canLift(Item item) {
		return maxWeight >= item.getWeight();
	}

	@Override
	public void pickUp(Item item) throws Exception {
		if(hasItem) {
			throw new Exception("Cannot pickup two items!");
		} else {
			hasItem = true;
			pickedUpItem = item;
			setSpeed();
		}
	}

	private void setSpeed() {
		if(pickedUpItem.isFragileGoods()) {
			//set low speed
		} else {
			//set high speed
		}
	}

	@Override
	public Item deliver() {
		if(hasItem) {
			if(pickedUpItem.isPrivateLabel()) {
				//place on pallet to the right
			} else {
				//place on pallet to the left
			}

			System.out.println(getDeliveredString());
		}

		hasItem = false;
		return pickedUpItem;
	}

	public String getDeliveredString() {
		return robotType + " delivered: " + pickedUpItem.toString();
	}
}
