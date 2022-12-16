package u3pp;
import java.util.Random;

public class Deck {

    private int dealtCards = 0;

    Random myRandom = new Random();

    private Card[] Cards = new Card[52]; 
    
    public Deck() {

        int valueIndex = 0;

        for (int i = 0; i < Card.VALUES.length; i++) {
            for (int j = 0; j < Card.SUITS.length; j++) {
                Card myCard = new Card (Card.SUITS[j], Card.VALUES[i]);
                Cards [valueIndex] = myCard;
                valueIndex++;
            }
        }
    }
    public int numLeft() {
        return (Cards.length - dealtCards);
    }
    public Card deal() {
        if(dealtCards == 52){
            System.out.println("No more cards in deck, Now shuffling");
            return null;
        }
        dealtCards += 1; 
        return Cards[51 - (dealtCards - 1)];
    }
    public void shuffle() {
        dealtCards = 0;
        for (int i = 0; i < Cards.length; i++){
            int rand;
            
            rand = myRandom.nextInt(Cards.length);
            
            Card temp;
            temp = Cards[rand];
            Cards[rand] = Cards[i];
            Cards[i] = temp;
        }
        dealtCards = 0;
    }
}
