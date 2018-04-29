package Game;

import Player.Player;
import Player.Dealer;

import java.util.Scanner;

import Deck.Deck;

public class Game {
	//Deck deck = new Deck();
	//Player player = new Player();
	//Dealer dealer = new Dealer();
	boolean endGame;
	
	public Game(){
		Deck deck = new Deck();
		Player player = new Player();
		Dealer dealer = new Dealer();
		boolean endGame = false;
		Scanner scan = new Scanner(System.in);
		
		while(!endGame){
			Run(player, dealer, deck);
			
			//endPrompt();
			System.out.println("Play again? (yes/no)");
			switch(scan.next()){
			case "yes":
				endGame = false; break;
			case "no":
				endGame = true; break;
			}
		}
		System.out.println("Thanks for playing!");
	}
	
	private void Run(Player p, Dealer d, Deck deck){
		boolean endRound = false;
		
		while(p.handValue() <= 21 && d.handValue() <= 21 && !endRound){
			p.resetHand();
			d.resetHand();
			Deal(p, d, deck);
			
			p.displayHand();
			d.displayHand();
			
			drawPhase(p, d, deck);
			
			if (d.handValue() > 21)
				dealerBust();
			
			if (p.handValue() > 21)
				playerBust();
			
			endRound = true;
		}
		if (p.handValue() > d.handValue())
			System.out.println("Player wins!");
		else if (p.handValue() < d.handValue())
			System.out.println("Dealer wins!");
		else if (p.handValue() == d.handValue())
			System.out.println("Tie goes to Dealer");
	}
	
	private void drawPhase(Player p, Dealer d, Deck deck){
		playerDraw(p, deck);
		
		// added if statement so dealer doesn't draw if player busts
		if (p.handValue() <= 21)
			dealerDraw(d, deck);
	}
	
	private void endPrompt(){
		Scanner input = new Scanner(System.in);
		
		System.out.println("Play another hand?");
		if (input.next().toLowerCase() == "no")
			endGame = true;
	}
	
	private void Deal(Player p, Dealer d, Deck deck){
		// use drawCard method to hand card directly to player or dealer
		p.Deal(deck.drawCard(), deck.drawCard());
		d.Deal(deck.drawCard(), deck.drawCard());
	}
	
	private void dealerBust(){
		System.out.println("Dealer busts!");
		System.out.println("You win!");
	}
	
	private void playerBust(){
		System.out.println("You busted!");
		System.out.println("You lose");
	}
	
	private void playerDraw(Player p, Deck deck){
		Scanner input = new Scanner(System.in);
		boolean stay = false;
		String in;
		
		/*
		 *  Figured out why it wasn't hitting or staying. 
		 *  For some reason it was not liking my if statements, and kept looping them
		 *  So switched to switch statement
		 *  All credit goes to my co-worker Shelly
		 */
		do{
			System.out.printf("Hit or stay?\n");
			in = input.next();
			
			switch(in.toLowerCase()){
			case "hit": 
				p.drawCard(deck.drawCard());
				p.displayHand(); break;
			case "stay": 
				stay = true; break;
			}
		}while(!stay && p.handValue() < 21); // made less then 21 so you can't hit on 21
		
		System.out.println();
	}
	
	private void dealerDraw(Dealer d, Deck deck){
		
		while(d.handValue() < 17){
			System.out.println("Dealer draws");
			d.drawCard(deck.drawCard());
			d.displayUpdatedHand();
		}
	}
}
