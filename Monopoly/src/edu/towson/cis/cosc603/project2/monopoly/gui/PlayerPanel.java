/*
 * 
 */
package edu.towson.cis.cosc603.project2.monopoly.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.OverlayLayout;
import javax.swing.border.BevelBorder;

import edu.towson.cis.cosc603.project2.monopoly.*;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerPanel.
 */
public class PlayerPanel extends JPanel {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	private PlayerPanelData data = new PlayerPanelData();

	/**
     * Instantiates a new player panel.
     *
     * @param player the player
     */
    public PlayerPanel(Player player) {
        JPanel pnlAction = new JPanel();
        JPanel pnlInfo = new JPanel();
        data.btnRollDice = new JButton("Roll Dice");
        data.btnPurchaseProperty = new JButton("Purchase Property");
        data.btnEndTurn = new JButton("End Turn");
        data.btnBuyHouse = new JButton("Buy House");
        data.btnGetOutOfJail = new JButton("Get Out of Jail");
        data.btnDrawCard = new JButton("Draw Card");
        data.btnTrade = new JButton("Trade");
        this.data.player = player;
        data.lblName = new JLabel();
        data.lblMoney = new JLabel();
        data.txtProperty = new JTextArea(30, 70);

        data.txtProperty.setEnabled(false);

        JPanel pnlName = new JPanel();
        JPanel pnlProperties = new JPanel();

        pnlInfo.setLayout(new BorderLayout());
        pnlInfo.add(pnlName, BorderLayout.NORTH);
        pnlInfo.add(pnlProperties, BorderLayout.CENTER);

        pnlProperties.setLayout(new OverlayLayout(pnlProperties));

        pnlName.add(data.lblName);
        pnlName.add(data.lblMoney);
        pnlProperties.add(data.txtProperty);

        pnlAction.setLayout(new GridLayout(3, 3));
        pnlAction.add(data.btnBuyHouse);
        pnlAction.add(data.btnRollDice);
        pnlAction.add(data.btnPurchaseProperty);
        pnlAction.add(data.btnGetOutOfJail);
        pnlAction.add(data.btnEndTurn);
        pnlAction.add(data.btnDrawCard);
        pnlAction.add(data.btnTrade);

        pnlAction.doLayout();
        pnlInfo.doLayout();
        pnlName.doLayout();
        pnlProperties.doLayout();
        this.doLayout();

        setLayout(new BorderLayout());
        add(pnlInfo, BorderLayout.CENTER);
        add(pnlAction, BorderLayout.SOUTH);

        data.btnRollDice.setEnabled(false);
        data.btnPurchaseProperty.setEnabled(false);
        data.btnEndTurn.setEnabled(false);
        data.btnBuyHouse.setEnabled(false);
        data.btnGetOutOfJail.setEnabled(false);
        data.btnDrawCard.setEnabled(false);
        data.btnTrade.setEnabled(false);

        setBorder(new BevelBorder(BevelBorder.RAISED));

        data.btnRollDice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnRollDiceClicked();
            }
        });

        data.btnEndTurn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnEndTurnClicked();
            }
        });

        data.btnPurchaseProperty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnPurchasePropertyClicked();
            }
        });

        data.btnBuyHouse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnBuyHouseClicked();
            }
        });

        data.btnGetOutOfJail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnGetOutOfJailClicked();
            }
        });

        data.btnDrawCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Card card = GameMaster.instance().btnDrawCardClicked();
                JOptionPane
                        .showMessageDialog(PlayerPanel.this, card.getLabel());
                displayInfo();
            }
        });

        data.btnTrade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnTradeClicked();
            }
        });
    }

    /**
     * Display info.
     */
    public void displayInfo() {
        data.lblName.setText(data.player.getName());
        data.lblMoney.setText("$ " + data.player.getMoney());
        StringBuffer buf = new StringBuffer();
        IOwnable[] cells = data.player.getAllProperties();
        for (int i = 0; i < cells.length; i++) {
            buf.append(cells[i] + "\n");
        }
        data.txtProperty.setText(buf.toString());
    }
    
    /**
     * Checks if is buy house button enabled.
     *
     * @return true, if is buy house button enabled
     */
    public boolean isBuyHouseButtonEnabled() {
        return data.btnBuyHouse.isEnabled();
    }

    /**
     * Checks if is draw card button enabled.
     *
     * @return true, if is draw card button enabled
     */
    public boolean isDrawCardButtonEnabled() {
        return data.btnDrawCard.isEnabled();
    }

    /**
     * Checks if is end turn button enabled.
     *
     * @return true, if is end turn button enabled
     */
    public boolean isEndTurnButtonEnabled() {
        return data.btnEndTurn.isEnabled();
    }
    
    /**
     * Checks if is gets the out of jail button enabled.
     *
     * @return true, if is gets the out of jail button enabled
     */
    public boolean isGetOutOfJailButtonEnabled() {
        return data.btnGetOutOfJail.isEnabled();
    }
    
    /**
     * Checks if is purchase property button enabled.
     *
     * @return true, if is purchase property button enabled
     */
    public boolean isPurchasePropertyButtonEnabled() {
        return data.btnPurchaseProperty.isEnabled();
    }
    
    /**
     * Checks if is roll dice button enabled.
     *
     * @return true, if is roll dice button enabled
     */
    public boolean isRollDiceButtonEnabled() {
        return data.btnRollDice.isEnabled();
    }

    /**
     * Checks if is trade button enabled.
     *
     * @return true, if is trade button enabled
     */
    public boolean isTradeButtonEnabled() {
        return data.btnTrade.isEnabled();
    }

    /**
     * Sets the buy house enabled.
     *
     * @param b the new buy house enabled
     */
    public void setBuyHouseEnabled(boolean b) {
        data.btnBuyHouse.setEnabled(b);
    }

    /**
     * Sets the draw card enabled.
     *
     * @param b the new draw card enabled
     */
    public void setDrawCardEnabled(boolean b) {
        data.btnDrawCard.setEnabled(b);
    }

    /**
     * Sets the end turn enabled.
     *
     * @param enabled the new end turn enabled
     */
    public void setEndTurnEnabled(boolean enabled) {
        data.btnEndTurn.setEnabled(enabled);
    }

    /**
     * Sets the gets the out of jail enabled.
     *
     * @param b the new gets the out of jail enabled
     */
    public void setGetOutOfJailEnabled(boolean b) {
        data.btnGetOutOfJail.setEnabled(b);
    }

    /**
     * Sets the purchase property enabled.
     *
     * @param enabled the new purchase property enabled
     */
    public void setPurchasePropertyEnabled(boolean enabled) {
        data.btnPurchaseProperty.setEnabled(enabled);
    }

    /**
     * Sets the roll dice enabled.
     *
     * @param enabled the new roll dice enabled
     */
    public void setRollDiceEnabled(boolean enabled) {
        data.btnRollDice.setEnabled(enabled);
    }

    /**
     * Sets the trade enabled.
     *
     * @param b the new trade enabled
     */
    public void setTradeEnabled(boolean b) {
        data.btnTrade.setEnabled(b);
    }
}