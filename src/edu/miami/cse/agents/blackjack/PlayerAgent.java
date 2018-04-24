package edu.miami.cse.agents.blackjack;

public class PlayerAgent {

	public Action act(Hand playerCards, Hand dealerCards) {

		int dealerUpCard = dealerCards.cardValue(dealerCards.getCards().get(1));
		if (playerCards.getValue() > 16) {
			return Action.STAND;
		}
		 // if the dealer has a bad card up then stand
		if (playerCards.getValue() > 11 && dealerUpCard < 7) { 
			return Action.STAND;
		} else {
			return Action.HIT;
		}
	}
}
