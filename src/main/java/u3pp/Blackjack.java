package u3pp;

import java.util.Scanner;

public class Blackjack {
    
    Deck myDeck = new Deck();
    Card[] userHand = new Card[11];
    Card[] dealerHand = new Card[11];

    public Blackjack() {
        myDeck.shuffle();
    }
    public void play(Scanner scanner) {
        
    }
    public static int calcPoints(Card[] hand) {
        int total = 0;
        int value = 0;
        for (int i = 0; i < hand.length; i++){
            if (hand[i] == null){
                continue;
            }
            if (hand[i].getValue() == "Ace"){
                value = 11;
            }
            else if (hand[i].getValue() == "Jack"){
                value = 10;
            }
            else if (hand[i].getValue() == "Queen"){
                value = 10;
            }
            else if (hand[i].getValue() == "King"){
                value = 10;
            }
            else {
                value = Integer.parseInt(hand[i].getValue());
            }
            total = value + total;
        }
        System.out.println("Total points are: " + total);
        return total;
    }
    public static String determineResult(Card[] userHand, Card[] dealerHand) {
        if (calcPoints(userHand) == calcPoints(dealerHand)){
            return "Player Pushes";
        }
        if ((calcPoints(userHand) < calcPoints(dealerHand) || isBust(userHand) == true) && isBust(dealerHand) == false){
            return "Player Loses";
        }
        return "Player Wins";
    }
    public static boolean isBust(Card[] hand) {
        if (calcPoints(hand) > 21) {
            return true;
        }
        return false;
    }
    public static boolean isBlackjack(Card[] hand) {
        if (calcPoints(hand) == 21 && (isBust(hand) == false)){
            System.out.println( "Blackjack: " + true);
            return true;
        }
        System.out.println( "Blackjack: " + false);
        return false;
    }
    public static boolean shouldDealerKeepHitting(Card[] hand) {
        if (calcPoints(hand) <= 16){
            System.out.println("Dealer will keep hitting!");
            return true;
        }
        System.out.println("Dealer can no longer hit");
        return false;
    }
}
