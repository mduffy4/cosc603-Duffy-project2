package edu.towson.cis.cosc603.project2.monopoly.gui;

import javax.swing.JLabel;

import edu.towson.cis.cosc603.project2.monopoly.Cell;

public class GUICellData {
	/** The cell. */
	public Cell cell;
	/** The lbl info. */
	public JLabel lblInfo;
	/** The lbl players. */
	public JLabel[] lblPlayers;

	public GUICellData(JLabel[] lblPlayers) {
		this.lblPlayers = lblPlayers;
	}
}