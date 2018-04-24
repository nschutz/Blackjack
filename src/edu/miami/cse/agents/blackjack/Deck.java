package edu.miami.cse.agents.blackjack;

import java.util.ArrayList;
import java.util.Collections;

import edu.miami.cse.agents.blackjack.Card.Rank;
import edu.miami.cse.agents.blackjack.Card.Suit;

/**
 * A card in a Blackjack card deck.
 * The card deck has 52 cards and shuffled
 */
public class Deck {
	ArrayList<Card> deck = new ArrayList<Card>();
	
	 /**
	   * Creates a new shuffled card deck with the given rank and suit.
	   */
	public Deck(){
		for(int i = 0; i < Rank.values().length; i++){
			for(int j = 0; j < Suit.values().length; j++){
				deck.add(new Card(Rank.values()[i], Suit.values()[j]));
			}
		}
		Collections.shuffle(deck);
	}
	
	 /**
	   * Gets the top card of the deck.
	   * If no cards left, it creates a new shuffled deck and returns the top card 
	   * @return the top card in the deck
	   */
	public Card getCard(){
		if(deck.size() == 0){
			//System.out.println("New card deck");
			for(int i = 0; i < Rank.values().length; i++){
				for(int j = 0; j < Suit.values().length; j++){
					deck.add(new Card(Rank.values()[i], Suit.values()[j]));
				}
			}
			Collections.shuffle(deck);
		}
		return deck.remove(0);
	}
	
}
