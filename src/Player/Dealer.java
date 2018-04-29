package Player;

import Deck.Card;

public class Dealer {
	Hand hand = new Hand();
	
	public Dealer(){
		
	}
	
	public void resetHand(){
		hand.resetHand();
	}
	
	public Dealer(Card c, Card d){
		Deal(c, d);
	}
	
	public void Deal(Card c, Card d){
		drawCard(c);
		drawCard(d);
	}
	
	public void drawCard(Card c){
		hand.addCard(c);
	}
	
	public int handValue(){
		return hand.getTotalValue();
	}
	
	public void displayHand(){
		System.out.printf("Dealer has ");
		hand.displayHand();
		System.out.printf("\n");
	}
	
	public void displayUpdatedHand(){
		System.out.printf("Dealer now has ");
		hand.displayHand();
		System.out.printf("\n");
	}
}