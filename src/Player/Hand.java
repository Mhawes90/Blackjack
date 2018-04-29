package Player;

import java.util.ArrayList;
import Deck.Card;

public class Hand {
	private ArrayList<Card> cards;
	
	public Hand(){
		cards = new ArrayList<Card>();
		resetHand();
	}
	
	public void resetHand(){
		// probably a better way to do this, but this is what I found
		cards.clear();
	}
	
	public void addCard(Card c){
		cards.add(c);
	}
	
	public int getHandValue(){
		int handValue = 0;
		
		for(Card c: cards){
			handValue += c.getRank().getValue();
		}
		return handValue;
	}
	
	public int getAceCount(){
		int aceCount = 0;
		
		for(Card c: cards){
			// calculates aceCount
			if(c.getRank().getValue() == 11)
				aceCount++;
		}
		return aceCount;
	}
	
	public int getTotalValue(){
		if (getHandValue() > 21 && getAceCount() > 0)
			return (getHandValue() - getAceCount()*10);
		else
			return getHandValue();
	}
	
	public void displayHand(){
		for(Card c: cards){
			System.out.printf("\n");
			c.printCard();
		}
		System.out.printf("\nHand value is %d\n", getTotalValue());
		System.out.println();
	}
}
