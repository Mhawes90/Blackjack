package Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;
	
	public Deck(){
		cards=new ArrayList<Card>();
		resetDeck();
		Shuffle();
	}
	
	public void resetDeck(){
		for(Suit s: Suit.values()){
			for(Rank r: Rank.values()){
				cards.add(new Card(s, r));		// creates a new card with rank and suit as it's constructors
			}
		}
	}
	
	public void Shuffle(){
		// refer back to chapter 7 example
		// found on stackoverflow
		Collections.shuffle(cards);
	}
	
	// total - 10 * aceCount if would bust1
	
	public void printDeck(){
		for(Card c: cards)
			c.printCard();
	}
	
	public Card drawCard(){
		// removes card from deck (array) and gives it away - use first index because we always know it's there
		return cards.remove(0);
	}
}
