package com.photoncat.digitalpet;

/**
 * An interface for digital pet.
 */
public interface Pet {
	/** called when pet does nothing. */
	public Statuses doNothing(long timestamp);
	/** called when pet is fed */
	public Statuses feed(long timestamp);
	/** called when pet does bath. */
	public Statuses bath(long timestamp);
}