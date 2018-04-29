package Player;

import java.util.Scanner;

import Deck.Card;

public class Player {
	Hand hand = new Hand();
	
	public Player(){
		
	}
	
	public void resetHand(){
		hand.resetHand();
	}
	
	public Player(Card c, Card d){
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
		System.out.printf("You have ");
		hand.displayHand();
		System.out.printf("\n");
	}
}
