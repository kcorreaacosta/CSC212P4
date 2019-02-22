package edu.smith.cs.csc212.p4;

public class NightPlaces extends Place {
	/**
	 * initializes the different time descriptions 
	 */
	String nightDescription;
	String morningDescription;
	
	/**
	 * creates constructors for night time
	 */
	
	public NightPlaces(String id, String nightDescription, boolean terminal, String morningDescription) {
		super(id,morningDescription,terminal);
		this.nightDescription = nightDescription;
		this.morningDescription = morningDescription;
	}
	/*
	 * overrides descriptions whether its night or day
	 */
	@Override
	public String printDescription(GameTime time) {
		if(time.isNightTime() == false) {
			return morningDescription;
		}
		else {
			return nightDescription;
		}
	}
	/**
	 * makes new place when changing from night to day before the end of the game
	 * @param id
	 * @param nightDescription
	 * @param morningDescription
	 * @return
	 */
	public static NightPlaces makenew(String id, String nightDescription, String morningDescription) {
		return new NightPlaces(id, nightDescription, false, morningDescription);
	}
	/**
	 * makes new place when changing from night to day at the end of the game
	 * @param id
	 * @param nightDescription
	 * @param morningDescription
	 * @return
	 */
	public static NightPlaces endmaking(String id, String nightDescription, String morningDescription) {
		return new NightPlaces(id, nightDescription, false, morningDescription);
	}
	
}
