package Deck;

public class Card {
// protected is package wide access
	protected Suit s;
	protected Rank r;
	
	public Card(Suit s, Rank r){
		this.s = s;
		this.r = r;
	}

	public Suit getSuit() {
		return s;
	}

	public void setS(Suit s) {
		this.s = s;
	}

	public Rank getRank() {
		return r;
	}

	public void setR(Rank r) {
		this.r = r;
	}
	
	public void printCard(){
		System.out.printf("%s of %s", r.rankName, s.suitName);
	}
}
