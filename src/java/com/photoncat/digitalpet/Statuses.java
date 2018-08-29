package com.photoncat.digitalpet;

/**
 * A class holding everything status of a digital pet.
 */
public class Statuses {
	public static class Builder {
        private long timestamp;
        private int hunger;
        private int cleanness;

        public Builder setTimestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setHunger(int hunger) {
            this.hunger = hunger;
            return this;
        }

        public Builder setCleanness(int cleanness) {
            this.cleanness = cleanness;
            return this;
        }

		public Statuses build() {
		    Statuses result = new Statuses();
		    result.timestamp = timestamp;
		    result.hunger = hunger;
		    result.cleanness = cleanness;
		    return result;
        }
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

	// We put an empty constructor here to limit accessibility to the constructor.
	private Statuses() {}
}