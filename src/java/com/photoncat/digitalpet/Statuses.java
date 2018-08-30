package com.photoncat.digitalpet;

/**
 * A class holding everything status of a digital pet.
 */
public class Statuses {
	public static class Builder {
        private long timestamp;
        private int hunger;
        private int cleanness;
        private double x;
        private double y;

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

        public Builder setX(double x) {
            this.x = x;
            return this;
        }

        public Builder setY(double y) {
            this.y = y;
            return this;
        }

		public Statuses build() {
		    Statuses result = new Statuses();
		    result.timestamp = timestamp;
            result.hunger = hunger;
            result.cleanness = cleanness;
            result.x = x;
            result.y = y;
		    return result;
        }
	}

	private long timestamp;
	private int hunger;
	private int cleanness;
	private double x;
	private double y;

	public long getTimestamp() {
		return timestamp;
	}

    public int getHunger() {
        return hunger;
    }

    public int getCleanness() {
        return cleanness;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

	// We put an empty constructor here to limit accessibility to the constructor.
	private Statuses() {}
}