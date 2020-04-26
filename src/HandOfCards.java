import java.util.Arrays;

public class HandOfCards {
	
	private static final int CARDS_IN_HAND = 5;
	private Card[] hand = new Card[CARDS_IN_HAND];
	private int curCard = 0;
	
	public void setHand(Card[] playerHand){
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle(); // place Cards in random order
		
		for (int i = 0; i < CARDS_IN_HAND; i++) {
			playerHand[i] = myDeckOfCards.dealCard();	
		}
		System.arraycopy(playerHand, CARDS_IN_HAND, this.hand, CARDS_IN_HAND, playerHand.length);
		
	}
	
	
	public void showPlayerHand() {
		System.out.println("Player's Hand");
		
		for (int i = 0; i < CARDS_IN_HAND; i++) {
			System.out.println(Arrays.toString(hand));
					
		}
		
	}

}
