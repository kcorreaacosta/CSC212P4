package edu.smith.cs.csc212.p4;

public class GameTime {
	int hours;
	int finalhours;
	/**
	 * makes the contructor of game time and initialize 
	 * hours and final hours to be used later
	 */
	public GameTime (int hour, int finalhours) {
		this.hours = hours;
		this.finalhours = finalhours;
	}
	
	/**
	 * increases hours by one every new room
	 * if the time goes over 23 it restarts for a new day
	 */
	public void increaseHour() {
		hours += 1;
		if(hours > 23) {
			hours = 0;
		}
		
		System.out.println("The Current time is: " + (hours%24) + ":00\n");
	};
	
	public void increaseHours() {
		finalhours += 1;
	}
	
	/**
	 * 
	 * @return the hours spent
	 */
	public int getHours() {
		return finalhours;
	}
	
	/**
	 * increases hour by 2 to make a faster night
	 */
	public void rest() {
		if (hours%5 ==0) {
			hours+=2;
		}
	}
	
	/**
	 * checks if the time is day or night
	 */
	public boolean isNightTime() {
		if(hours%24 <12) {
			return false;
		}
		else {
			return true;
		}
	}
}
