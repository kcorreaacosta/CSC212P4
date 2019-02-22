package edu.smith.cs.csc212.p4;

public class SecretExit extends Exit {
	private boolean hidden = true;
	/**
	 * sets parameters for Secret exit for a place and a location
	 * @param target
	 * @param description
	 */
	public SecretExit(String target, String description) {
		super(target, description);
}
	/**
	 * sets SecretExit to whatever hidden is 
	 */
	public boolean isSecret() {
		return hidden;
	}
	/**
	 * sets hidden to false when the search method is called in order to see the SecretExits
	 */
	public void search() {
		hidden = false;
	}

	
}
