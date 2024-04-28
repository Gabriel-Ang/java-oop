package View;

import javax.swing.JOptionPane;

import Helper.Keyboard;
import Model.*;

public class GUIView {

	public void showOptionPane(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public char showWithOptions(String message, String[] o) {
		int answer = JOptionPane.showOptionDialog(null, message, message, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, o, o[0]);
		if (answer == JOptionPane.YES_OPTION)
			return 'y';
		else
			return 'n';
	}

	public void shuffleCard() {
		showOptionPane("Shuffling cards...");
	}

	public void displayExitGame() {
		showOptionPane("Thank you for playing HighSum game");
	}

	public void displayBetOntable(int bet) {
		showOptionPane("Bet on table : " + bet);
	}

	public void displayPlayerWin(Player player) {
		showOptionPane(player.getLoginName() + " Wins!");
	}

	public void displayDealerWin() {
		showOptionPane("Dealer Wins!");
	}

	public void displayTie() {
		showOptionPane("It is a tie!.");
	}

	public void displayPlayerQuit() {
		showOptionPane("You have quit the current game.");
	}

	public void displayPlayerTotalCardValue(Player player) {
		showOptionPane("Value:" + player.getTotalCardsValue());
	}

	public void displayDealerDealCardsAndGameRound(int round) {
		showOptionPane("Dealer dealing cards - ROUND " + round);
	}

	public void displayGameStart() {
		showOptionPane("Game starts - Dealer shuffle deck");
	}

	public char getPlayerCallOrQuit() {
		String[] o = { "Call", "Quit" };
		char a = showWithOptions("Do you want to call or quit?", o);
		if (a == 'y')
			return 'c';
		else
			return 'q';

	}

	public char getPlayerFollowOrNot(Player player, int dealerBet) {
		String[] o = { "Follow", "Not Follow" };
		return showWithOptions("Do you want to follow?", o);

	}

	public char getPlayerNextGame() {
		String[] o = { "Next Game", "Quit" };
		return showWithOptions("Play next? Or quit", o);
	}

	public int getPlayerCallBetChip(Player player) {
		boolean valid = false;
		int bets = 0;
		while (!valid) {
			String bet = JOptionPane.showInputDialog(null, player.getLoginName() + ", please enter your bet: ");
			bets = Integer.parseInt(bet);
			if (bets < 0) {
				showOptionPane("Invalid bet amount, please enter again.");
			} else if (bets > player.getChips()) {
				showOptionPane("You do not have enough chips, please enter again.");
			} else {
				valid = true;
			}
		}
		return bets;
	}

	public int getDealerCallBetChips() {
		return 10;
	}

	public void displayDealerScore(Dealer dealer) {
		JOptionPane.showMessageDialog(null, "Dealer Score: " + dealer.getTotalCardsValue());
	}

}
