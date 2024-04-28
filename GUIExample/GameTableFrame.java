package GUIExample;

import java.awt.*;
import javax.swing.*;

import Controller.GameController;
import Model.*;
import View.GUIView;

public class GameTableFrame extends JFrame {

    private GameTablePanel gtp;
    private Dealer dealer;
    private Player player;
    private GUIView view;
    private GameController gameController;

    public GameTableFrame(Dealer dealer, Player player) {
        this.dealer = dealer;
        this.player = player;
        gtp = new GameTablePanel(dealer, player);

        add(gtp);
        pack();
        setVisible(true);
    }

    public void updateGameTable() {
        gtp.repaint();
    }

    public void run() {

        this.view = new GUIView();
        this.gameController = new GameController(this.dealer, this.player, this.view, gtp);
        this.gameController.run();
    }

}
