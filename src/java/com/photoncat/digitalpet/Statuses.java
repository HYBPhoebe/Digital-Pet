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
	
	// These fields will be modified to private with some getters in 
	// a few commits.
	// They are as they like because this is simple.
	public long timestamp;
	public int hunger;
	public int cleanness;
}