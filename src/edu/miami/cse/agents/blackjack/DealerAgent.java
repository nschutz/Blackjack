package edu.miami.cse.agents.blackjack;

import java.util.Random;


/**
 * A dealer takes the {@link Action#HIT} action until their cards total 17 or
 * more points. Then the dealer takes the {@link Action#STAND} action.
 */



public class DealerAgent{

	/**
	 * Take an action based on the cards that have been dealt to the Agent.
	 * 
	 * @param cards
	 *          The cards dealt so far to the Agent.
	 * @return An action indicating whether the Agent would like to
	 *         {@link Action#HIT} or {@link Action#STAND}.
	 */
	
	public Action act(Hand cards) {
		if(cards.getValue() > 16)
			return Action.STAND;
		else
			return Action.HIT;
	}
}
