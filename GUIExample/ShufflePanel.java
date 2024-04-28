package GUIExample;

import java.awt.*;
import javax.swing.*;

import Model.*;

public class ShufflePanel extends JPanel {

	private ImageIcon cardBackImage;

	public ShufflePanel() {

		setBackground(Color.GREEN);
		setPreferredSize(new Dimension(1024, 768));

		cardBackImage = new ImageIcon("images/back.png");
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int x = 50;
		int y = 400;

		for (int i = 0; i < 6; i++) {
			cardBackImage.paintIcon(this, g, x + 150 * i, y);
		}

		String lbl = "Shuffle";
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		g.drawString(lbl, 400, 50);

	}
}
