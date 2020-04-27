
// Fig. 7.11: DeckOfCardsTest.java
// Card shuffling and dealing application.

public class ShuffleCards {
	
	// execute application
	public static void main( String args[] ){
	 
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle(); // place Cards in random order

		 //print all 52 Cards in the order in which they are dealt
		 //for ( int i = 0; i < 13; i++ ){
 		 //deal and print 4 Cards
		 //	System.out.printf( "%-20s%-20s%-20s%-20s\n",
		 //	myDeckOfCards.dealCard(), myDeckOfCards.dealCard(),
		// myDeckOfCards.dealCard(), myDeckOfCards.dealCard() );
		//} // end for
		
		
	// My code is below here
		
		
		// Get Hand size, in case you want to play with more cards
		int handSize = myDeckOfCards.getHandSize();
		
		// Proper thing would be to make an array for each player's hand
		Card[] playerHand = new Card[handSize];
		
		for (int i = 0; i < handSize; i++) {
			playerHand[i] = myDeckOfCards.dealCard();
		}
		
		for (int i = 0; i < handSize; i++) {
			System.out.print("Your hand is: ");
			System.out.print(playerHand[i]);
			System.out.print("\n");	
		}
		
		
		myDeckOfCards.handCheck();
		
		System.out.println("Thank you for using the Card Shuffling and Dealing application");
		java.util.Date date = new java.util.Date();
		System.out.println("The current date and time is: ");
		System.out.println(date);
		
		
	} // end main
 } // end class DeckOfCardsTest


