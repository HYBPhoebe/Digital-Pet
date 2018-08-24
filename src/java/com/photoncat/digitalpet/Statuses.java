package com.photoncat.digitalpet;

/**
 * A class holding everything status of a digital pet.
 */
public class Statuses {
	public Statuses(long timestamp, int hunger, int cleanness) {
		this.timestamp = timestamp;
		this.hunger = hunger;
		this.cleanness = cleanness;
	}

	private long timestamp;
	private int hunger;
	private int cleanness;

	public long getTimestamp() {
		return timestamp;
	}

	public int getHunger() {
		return hunger;
	}

	public int getCleanness() {
		return cleanness;
	}
}