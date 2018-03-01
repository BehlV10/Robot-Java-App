package com.javatest;

public class Item {
	private static int ID = 0;
	private int id;
	private float weight;
	private float height;
	private float width;
	private float depth;
	private boolean isPrivateLabel;
	private boolean isFragileGoods;

	public Item(float weight, float height, float width, float depth, boolean isPrivateLabel, boolean isFragileGoods) {
		this.id = ID;
		ID++;

		this.weight = weight;
		this.height = height;
		this.width = width;
		this.depth = depth;
		this.isPrivateLabel = isPrivateLabel;
		this.isFragileGoods = isFragileGoods;
	}

	public int getId() {
		return id;
	}

	public float getWeight() {
		return weight;
	}

	public float getHeight() {
		return height;
	}

	public float getWidth() {
		return width;
	}

	public float getDepth() {
		return depth;
	}

	public boolean isPrivateLabel() {
		return isPrivateLabel;
	}

	public boolean isFragileGoods() {
		return isFragileGoods;
	}

	@Override
	public String toString() {
		return id + ";" + weight + ";" + height + ";" + width + ";" + depth + ";" + isPrivateLabel + ";" + isFragileGoods ;
	}
}
