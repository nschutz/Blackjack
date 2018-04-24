package edu.miami.cse.agents.blackjack;

import java.util.ArrayList;


/**
 * A hand (the cards) of a Blackjack player or dealer 
 */

public class Hand {
	private ArrayList<Card> cards;
	private int aceCounter;
	
	/**
	   * Creates a new empty card list.
	*/
	public Hand(){
		setCards(new ArrayList<Card>());
		aceCounter = 0;
	}
	/**
	 * To handle going over 21 with an ace 
	 * @param hand
	 * @return how many aces are in the player's hand
	 */
	public int getCounter() {
		return  aceCounter; 
	}
	public void useAnAceAs1() {
		aceCounter -= 1;
		
	}
	/**
	   * Add a card to the card list.
	*/
	public void add(Card card){
		getCards().add(card);
	}
	
	/**
	   * Calculates and returns the hand value (sum of the hand cards values)
	   * @return The hand value
	*/
	
	public int getValue(){	
		int totalValue = 0;
		int currentCardValue = 0;
		// if there is more than two cards, this will count all of them
		for (int i = 0; i < getCards().size(); i++) {
			currentCardValue = cardValue(getCards().get(i));
			totalValue = totalValue + currentCardValue;
			if (currentCardValue == 11) {
				aceCounter++;
			}
		}
		// deal with aces
		if (totalValue > 21 && aceCounter > 0) {
			totalValue -= 10;
			aceCounter--;
		}
		return totalValue;
	}
	/**
	 * Returns point value associated with rank in blackjack, returns 11 for ace, 
	 * should be  handled in get value method with a counter
	 * @param currentCard
	 * @return point value between 1 and 10
	 */
	public int cardValue(Card currentCard) {
		switch (currentCard.getRank()) {
		case ACE: return 11;
		case TWO: return 2;
		case THREE: return 3;
		case FOUR: return 4;
		case FIVE: return 5;
		case SIX: return 6;
		case SEVEN: return 7;
		case EIGHT: return 8;
		case NINE: return 9;
		case TEN: return 10;
		case JACK: return 10;
		case QUEEN: return 10;
		case KING: return 10;
		}
		return 99; // should never happen
	}
	/**
	 * override toString in class java.lang.Object
	 */
	
	public String toString(){
		StringBuilder out = new StringBuilder();
		
		for(Card c : getCards()){
			out.append(c.toString() + " ");
		}
		return new String(out);
	}
	public ArrayList<Card> getCards() {
		return cards;
	}
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	
}
