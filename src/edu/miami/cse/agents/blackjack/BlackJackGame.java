package edu.miami.cse.agents.blackjack;

public class BlackJackGame {

	public static int balance = 1000000; // make sure this works as intended
	public static int biggerBalance = 0;

	public static void main(String[] args) {

		for (int j = 0; j < 100; j++) { // outer for loop
		for (int i = 0; i < 1000; i++) { // inside for loop

			Deck deck = new Deck();

			Hand dealerCards = new Hand();
			Hand playerCards = new Hand();

			dealerCards.add(deck.getCard());
			dealerCards.add(deck.getCard());

			playerCards.add(deck.getCard());
			playerCards.add(deck.getCard());

			System.out.println("Player Hand: " + playerCards.toString() + playerCards.getValue());
			System.out.println("Dealer Hand: " + dealerCards.toString() + dealerCards.getValue());

			DealerAgent dealer = new DealerAgent();
			Action dealerAction = dealer.act(dealerCards);

			PlayerAgent player = new PlayerAgent();
			Action playerAction = player.act(playerCards, dealerCards);
			
			// long way of saying get the second card dealt to the dealer
			int dealerUpCard = dealerCards.cardValue(dealerCards.getCards().get(1)); 
			System.out.println("Dealer Card: " + dealerUpCard);

			balance -= 10; // player bets 10

			// first the player hits until he busts or gets above a 16 (or less
			// depending on dealer's hand)
			while (player.act(playerCards, dealerCards) != Action.STAND) {
				System.out.println("Player: " + playerAction);
				Card pulledCard = deck.getCard();
				playerCards.add(pulledCard);
				System.out.println("Player hit for a: " + pulledCard);
				if (playerCards.getValue() > 21 && playerCards.getCounter() > 0) {

				}
				System.out.println("Player has " + playerCards.getValue());

			}
			// each hit until they bust or stand
			while (dealer.act(dealerCards) != Action.STAND) {
				System.out.println("Dealer: " + dealerAction);
				Card pulledCard = deck.getCard();
				dealerCards.add(pulledCard);
				System.out.println("Dealer hit for a: " + pulledCard);
				System.out.println("Dealer has " + dealerCards.getValue());
			}

			// we only want to run check for winner once
			String result = checkForWinner(dealerCards, playerCards);

			if (result.equals("dealer")) {
				System.out.println("Player lost!\n");
			} else if (result.equals("push")) {
				System.out.println("Score tied, bets returned\n");
				balance += 10;
			} else {
				System.out.println("Congrats player, you won!\n");
				balance += 20;
			}

		} // end of inside for loop
		System.out.println("End player balance: " + balance);
		biggerBalance += balance;
	} // end of outside for loop
		System.out.println("Average Ending Balance: " + biggerBalance / 100);
	}

	/**
	 * If there are any winners this will return dealer, player, push, none.
	 * None means that they will both hit again (the value is <= 16)
	 * 
	 * @param dealerCards
	 *            the hand of the dealer
	 * @param playerCards
	 *            the hand of the player
	 * @return string value signifying state of the game
	 */
	public static String checkForWinner(Hand dealerCards, Hand playerCards) {
		int dealerValue = dealerCards.getValue(); // the getValue method counts
													// the aces, so don't deal
													// with aces until value is
													// read
		int playerValue = playerCards.getValue();
		// did the dealer win?
		if (playerCards.getValue() > 21) {
			System.out.println("Player busts!");
			return "dealer";
		}
		if (dealerCards.getValue() > 21) {
			System.out.println("Dealer busts!");
			return "player";
		}
		if (dealerValue == 21) {
			System.out.println("Dealer got blackjack!");
			return "dealer";
		}
		// did the player win?
		if (playerValue == 21) {
			System.out.println("Player got blackjack!");
			return "player";
		}
		if (playerValue > dealerValue) {
			return "player";
		}
		if (dealerValue > playerValue) {
			return "dealer";
		}
		// if the value is greater than 16 and they're tied
		if (playerValue > 15 && playerValue == dealerValue) {
			return "push";
		}
		return null; // this should never happen
	}

}
