package Deck;

public enum Suit {
	SPADES("spades"), HEARTS("hearts"), CLUBS("clubs"), DIAMONDS("diamonds");
	
	// variables
	protected final String suitName;
	
	Suit(String suitName){
		this.suitName = suitName;
	}
	
	public String getName(){
		return suitName;
	}
}
