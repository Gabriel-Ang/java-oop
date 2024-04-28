package GUIExample;

import javax.swing.*;

import Model.Dealer;
import Model.Player;
import View.*;

public class ShuffleFrame extends JFrame {

    private ShufflePanel shufflePanel;
    private Dealer dealer;
    private Player player;

    public ShuffleFrame(Dealer dealer, Player player) {
        this.shufflePanel = new ShufflePanel();
        this.dealer = dealer;
        this.player = player;

        add(shufflePanel);
        pack();
        setVisible(true);

    }

    public void update() {
        this.shufflePanel.repaint();
    }

    public void run() {
        GUIView gv = new GUIView();
        gv.shuffleCard();
        setVisible(false);
        GameTableFrame app = new GameTableFrame(dealer, player);
        app.run();
    }

}
