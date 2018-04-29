package Deck;

public enum Rank {
	ACE("ace", 11), TWO("two", 2), THREE("three", 3), FOUR("four", 4), FIVE("five", 5), SIX("six", 6), SEVEN("seven", 7), 
	EIGHT("eight", 8), NINE("nine", 9), TEN("ten", 10), JACK("jack", 10), QUEEN("queen", 10), KING("king", 10);
	
	// variables
	protected final String rankName;
	protected final int value;
	
	Rank(String rankName, int value){
		this.rankName = rankName;
		this.value = value;
	}
	
	public String getRankName(){
		return rankName;
	}
	
	public int getValue(){
		return value;
	}
}
