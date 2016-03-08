package edu.towson.cis.cosc603.project2.monopoly;

public interface IOwnable {

	/**
	 * Gets the theOwner.
	 *
	 * @return the theOwner
	 */
	Player getTheOwner();

	/**
	 * Sets the theOwner.
	 *
	 * @param theOwner the new theOwner
	 */
	void setTheOwner(Player owner);

}