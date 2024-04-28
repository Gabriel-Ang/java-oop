package Controller;

import Model.Dealer;
import Model.Player;
import View.*;
import GUIExample.GameTablePanel;

public class GameController {

	private Dealer dealer;
	private Player player;
	private GUIView view;
	private int chipsOnTable;
	private GameTablePanel gtp;

	public GameController(Dealer dealer, Player player, GUIView view, GameTablePanel gtp) {
		this.dealer = dealer;
		this.player = player;
		this.view = view;
		this.chipsOnTable = 0;
		this.gtp = gtp;
	}

	public void run() {

		boolean carryOn = true;

		while (carryOn) {
			runOneRound();
			char r = this.view.getPlayerNextGame();
			if (r == 'n') {
				carryOn = false;
			}
		}
		this.view.displayExitGame();
	}

	public void endRound() {
		gtp.setreveal(true);
		gtp.repaint();
		this.view.displayDealerScore(dealer);
	}

	public void runOneRound() {
		this.view.displayGameStart();
		this.dealer.shuffleCards();
		this.chipsOnTable = 0;
		boolean playerQuit = false;

		for (int round = 1; round <= 4; round++) {

			this.view.displayDealerDealCardsAndGameRound(round);

			if (round == 1) {// round 1 deal extra card
				this.dealer.dealCardTo(this.player);
				this.dealer.dealCardTo(this.dealer);
			}
			this.dealer.dealCardTo(this.player);
			this.dealer.dealCardTo(this.dealer);

			gtp.repaint();
			this.view.displayPlayerTotalCardValue(player);

			int whoCanCall = this.dealer.determineWhichCardRankHigher(dealer.getLastCard(), player.getLastCard());

			if (whoCanCall == 1) {// dealer call
				int chipsToBet = this.view.getDealerCallBetChips();
				// ask player want to follow?
				char r = this.view.getPlayerFollowOrNot(this.player, chipsToBet);
				if (r == 'y') {
					this.player.deductChips(chipsToBet);
					this.chipsOnTable += 2 * chipsToBet;
					gtp.setChips(this.chipsOnTable);
					gtp.repaint();
					this.view.displayBetOntable(this.chipsOnTable);

				} else {
					playerQuit = true;
					break;
				}
			} else {// player call
				if (round == 1) {// round 1 player cannot quit
					int chipsToBet = view.getPlayerCallBetChip(this.player);
					this.player.deductChips(chipsToBet);
					this.chipsOnTable += 2 * chipsToBet;
					gtp.setChips(this.chipsOnTable);
					gtp.repaint();
					this.view.displayBetOntable(this.chipsOnTable);
				} else {
					char r = this.view.getPlayerCallOrQuit();
					if (r == 'c') {
						int chipsToBet = view.getPlayerCallBetChip(this.player);
						this.player.deductChips(chipsToBet);
						this.chipsOnTable += 2 * chipsToBet;
						gtp.setChips(this.chipsOnTable);
						gtp.repaint();
						this.view.displayBetOntable(this.chipsOnTable);
					} else {
						playerQuit = true;
						break;
					}
				}
			}
		}
		gtp.setreveal(true);
		gtp.repaint();
		// check who win
		if (playerQuit) {

			this.view.displayPlayerQuit();
		} else if (this.player.getTotalCardsValue() > this.dealer.getTotalCardsValue()) {
			this.view.displayPlayerWin(this.player);
			this.player.addChips(chipsOnTable);
			this.chipsOnTable = 0;

		} else if (this.player.getTotalCardsValue() < this.dealer.getTotalCardsValue()) {
			this.view.displayDealerWin();

		} else {
			this.view.displayTie();
			this.player.addChips(chipsOnTable / 2);

		}

		// put all the cards back to the deck
		dealer.addCardsBackToDeck(dealer.getCardsOnHand());
		dealer.addCardsBackToDeck(player.getCardsOnHand());
		dealer.clearCardsOnHand();
		player.clearCardsOnHand();
		gtp.reset();
	}

}
