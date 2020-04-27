// Fig. 7.12: DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.
import java.security.SecureRandom;

public class DeckOfCards {
   // random number generator
   private static final SecureRandom randomNumbers = new SecureRandom();
   private static final int NUMBER_OF_CARDS = 52; // constant # of Cards
  
   //I added this 
   private static final int CARDS_IN_HAND = 5; // Constant 5 card hand

   private Card[] deck = new Card[NUMBER_OF_CARDS]; // Card references
   private int currentCard = 0; // index of next Card to be dealt (0-51)

   
   
   // constructor fills deck of Cards
   public DeckOfCards() {
      String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};    
      String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};      

      // populate deck with Card objects                   
      for (int count = 0; count < deck.length; count++) {  
         deck[count] =                                     
            new Card(faces[count % 13], suits[count / 13]);
      }                                                    
   } 

   // shuffle deck of Cards with one-pass algorithm
   public void shuffle() {
      // next call to method dealCard should start at deck[0] again
      currentCard = 0; 

      // for each Card, pick another random Card (0-51) and swap them
      for (int first = 0; first < deck.length; first++) {
         // select a random number between 0 and 51 
         int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

         // swap current Card with randomly selected Card
         Card temp = deck[first];   
         deck[first] = deck[second];
         deck[second] = temp;       
      } 
   } 

   // deal one Card
   public Card dealCard() {
      // determine whether Cards remain to be dealt
      if (currentCard < deck.length) {
         return deck[currentCard++]; // return current Card in array
      } 
      else {
         return null; // return null to indicate that all Cards were dealt
      } 
   }
   
   // My added Code is below here
   
   public int getHandSize() {
	   int handSize = CARDS_IN_HAND;
	   return handSize;
   }
   
   
   
   
   
   public void handCheck() {
	   
	   if (checkPair() == true) {
		   System.out.println("There is a pair");
	   } 
	   else if (checkPair() == false) {
		   System.out.println("No Pairs");
	   }
	   if (checkTwoPair()== true) {
		   System.out.println("There are two pairs");
	   }
	   if (checkTwoPair() == false){
		   System.out.println("There is not two pairs");
	   }
	   // function to check three of a kind
	   //function to check four of a kind
	   }
	   
   public Boolean checkPair(){	
	    for (int i = 0; i < CARDS_IN_HAND; i++) {
		   for (int j = i+1; j < CARDS_IN_HAND; j++) {
			   if (deck[i].getFace().equals(deck[j].getFace())) {
				   return true;
			   } 
		   }
	   }
	   return false;
	}
   
   public Boolean checkTwoPair(){
	   int numberOfPairs = 0;
	   for (int i = 0; i < CARDS_IN_HAND; i++) {
		   for (int j = i + 1; j < CARDS_IN_HAND; j++) {
			   if (deck[i].getFace() == deck[j].getFace()) {
				   numberOfPairs++;
			   }
		   }
	   }
	   if (numberOfPairs >= 2) {
		   return true;
	   }
	   return false;
	}
   
   public Boolean checkThreeOfKind() {
	   int matchCount = 0;
	   for (int i = 0; i < CARDS_IN_HAND; i++) {
		   for (int j = i + 1; j < CARDS_IN_HAND; j++) {
			   if (deck[i].getFace() == deck[j].getFace()) {
				   matchCount++;
			   }
		   }
		   
	   } 
	   if (matchCount >= 3) {
		   return true;
	   }
	   return false;
   }
   
    
}
