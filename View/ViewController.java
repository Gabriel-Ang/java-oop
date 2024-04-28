package View;

import Helper.Keyboard;
import Model.*;

//all input and output should be done view ViewController
//so that it is easier to implement GUI later
public class ViewController {

	public void displayExitGame() {
		System.out.println("Thank you for playing HighSum game");
	}

	public void displayBetOntable(int bet) {
		System.out.println("Bet on table : " + bet);
	}

	public void displayPlayerWin(Player player) {
		System.out.println(player.getLoginName() + " Wins!");
	}

	public void displayDealerWin() {
		System.out.println("Dealer Wins!");
	}

	public void displayTie() {
		System.out.println("It is a tie!.");
	}

	public void displayPlayerQuit() {
		System.out.println("You have quit the current game.");
	}

	public void displayPlayerCardsOnHand(Player player) {

		System.out.println(player.getLoginName());

		if (player instanceof Dealer) {

			for (int i = 0; i < player.getCardsOnHand().size(); i++) {
				if (i == 0) {
					System.out.print("<HIDDEN CARD> ");
				} else {
					System.out.print(player.getCardsOnHand().get(i).toString() + " ");
				}
			}
		} else {
			for (Card card : player.getCardsOnHand()) {
				System.out.print(card + " ");
			}
		}
		System.out.println();
	}

	public void displayBlankLine() {
		System.out.println();
	}

	public void displayPlayerTotalCardValue(Player player) {
		System.out.println("Value:" + player.getTotalCardsValue());
	}

	public void displayDealerDealCardsAndGameRound(int round) {
		System.out.println("Dealer dealing cards - ROUND " + round);
	}

	public void displayGameStart() {
		System.out.println("Game starts - Dealer shuffle deck");
	}

	public void displayPlayerNameAndChips(Player player) {
		System.out.println(player.getLoginName() + ", You have " + player.getChips() + " chips");
	}

	public void displayPlayerNameAndLeftOverChips(Player player) {
		System.out.println(player.getLoginName() + ", You are left with " + player.getChips() + " chips");
	}

	public void displayGameTitle() {
		System.out.println("HighSum GAME");
	}

	public void displaySingleLine() {
		for (int i = 0; i < 30; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public void displayDoubleLine() {
		for (int i = 0; i < 30; i++) {
			System.out.print("=");
		}
		System.out.println();
	}

	public char getPlayerCallOrQuit() {
		char[] choices = { 'c', 'q' };
		char r = Keyboard.readChar("Do you want to [c]all or [q]uit?:", choices);
		return r;
	}

	public char getPlayerFollowOrNot(Player player, int dealerBet) {

		boolean validChoice = false;
		char[] choices = { 'y', 'n' };

		char r = 'n';
		while (!validChoice) {
			r = Keyboard.readChar("Do you want to follow?", choices);
			// check if player has enff chips to follow
			if (r == 'y' && player.getChips() < dealerBet) {
				System.out.println("You do not have enough chips to follow");
				displayPlayerNameAndChips(player);
			} else {
				validChoice = true;
			}
		}
		return r;
	}

	public char getPlayerNextGame() {
		char[] choices = { 'y', 'n' };
		char r = Keyboard.readChar("Next game?", choices);
		return r;
	}

	public int getPlayerCallBetChip(Player player) {
		boolean validBetAmount = false;
		int chipsToBet = 0;
		while (!validBetAmount) {
			chipsToBet = Keyboard.readInt("Player call, state bet:");
			if (chipsToBet < 0) {
				System.out.println("Chips cannot be negative");
			} else if (chipsToBet > player.getChips()) {
				System.out.println("You do not have enough chips");
			} else {
				validBetAmount = true;
			}
		}
		return chipsToBet;
	}

	public int getDealerCallBetChips() {
		System.out.println("Dealer call, state bet: 10");
		return 10;
	}

}
