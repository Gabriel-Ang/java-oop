package GUIExample;

import java.awt.*;
import javax.swing.*;

import Model.*;

public class GameTablePanel extends JPanel {

	private Player player;
	private Dealer dealer;
	private ImageIcon cardBackImage;
	private int chips = 0;
	private boolean reveal = false;

	public GameTablePanel(Dealer dealer, Player player) {

		setBackground(Color.GREEN);
		setPreferredSize(new Dimension(1120, 1080));

		cardBackImage = new ImageIcon("images/back.png");
		this.dealer = dealer;
		this.player = player;

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("paintComponent");
		String font = "Comic Sans MS";
		int fontType = Font.ITALIC;
		int fontSize = 20;

		int x = 50;
		int y = 70;

		int i = 0;
		for (Card c : dealer.getCardsOnHand()) {
			// display dealer cards
			if (reveal) {
				c.paintIcon(this, g, x, y);
			} else {
				if (i == 0) {
					cardBackImage.paintIcon(this, g, x, y);
					i++;
				} else {
					c.paintIcon(this, g, x, y);
				}
			}

			x += 200;
		}

		x = 50;
		y = 300;
		g.setFont(new Font(font, fontType, fontSize));
		g.drawString("Dealer", x, y);

		x = 50;
		y = 550;

		for (Card c : player.getCardsOnHand()) {

			c.paintIcon(this, g, x, y);
			x += 200;
		}

		y = 800;
		x = 50;

		g.setFont(new Font(font, fontType, fontSize));
		g.drawString("Player", x, y);

		x = 50;
		y = 850;

		g.setFont(new Font(font, fontType, fontSize));
		g.drawString("Value: " + player.getTotalCardsValue(), x, y);

		x = 250;
		g.setFont(new Font(font, fontType, fontSize));
		g.drawString("Balance chips: " + player.getChips(), x, y);

		// display chips on table
		x = 50;
		y = 500;

		g.setFont(new Font("Arial", fontType, fontSize));
		g.drawString("Chips on table: " + chips, x, y);
	}

	public void setChips(int chipsOnTable) {
		this.chips = chipsOnTable;
	}

	public void setreveal(boolean reveal) {
		this.reveal = reveal;
	}

	public void reset() {
		this.chips = 0;
		this.reveal = false;
	}
}
