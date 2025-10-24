/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author jash kirtikumar patel
 * @author pujan patel
 *  @author harshkumar patel
 */
public class WarCard extends Card {
    
    public enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }
    
    public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), 
        EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);
        
        private final int value;
        
        Rank(int value) {
            this.value = value;
        }
        
        public int getValue() {
            return value;
        }
    }
    
    private final Suit suit;
    private final Rank rank;
    
    public WarCard(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }
    
    public Suit getSuit() {
        return suit;
    }
    
    public Rank getRank() {
        return rank;
    }
    
    /**
     * Get the numeric value of the card for comparison
     * Ace is highest (14), 2 is lowest (2)
     */
    public int getValue() {
        return rank.getValue();
    }
    
    /*
      Compare this card to another card like of dealer with player
     
     */
    public int compareTo(WarCard other) {
        return this.getValue() - other.getValue();
    }
    
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}