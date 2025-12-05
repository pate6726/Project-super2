/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca.sheridancollege.project;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Jash Kirtikumar Patel
 * 
 */
public class WarCardTest {
    
   
    @Test
    public void testGetSuit() {
        WarCard card = new WarCard(WarCard.Suit.SPADES, WarCard.Rank.ACE);
        assertEquals(WarCard.Suit.SPADES, card.getSuit(), "Suit should be SPADES");
    }

    @Test
    public void testGetRank() {
        WarCard card = new WarCard(WarCard.Suit.HEARTS, WarCard.Rank.KING);
        assertEquals(WarCard.Rank.KING, card.getRank(), "Rank should be KING");
    }

    @Test
    public void testGetValue() {
        WarCard card = new WarCard(WarCard.Suit.CLUBS, WarCard.Rank.QUEEN);
        assertEquals(12, card.getValue(), "Queen should have value 12");
    }

    @Test
    public void testCompareToHigher() {
        WarCard card1 = new WarCard(WarCard.Suit.DIAMONDS, WarCard.Rank.ACE);
        WarCard card2 = new WarCard(WarCard.Suit.CLUBS, WarCard.Rank.TEN);

        assertTrue(card1.compareTo(card2) > 0, "Ace should be higher than Ten");
    }

    @Test
    public void testCompareToLower() {
        WarCard card1 = new WarCard(WarCard.Suit.CLUBS, WarCard.Rank.TWO);
        WarCard card2 = new WarCard(WarCard.Suit.SPADES, WarCard.Rank.KING);

        assertTrue(card1.compareTo(card2) < 0, "Two should be lower than King");
    }

    @Test
    public void testCompareToEqual() {
        WarCard card1 = new WarCard(WarCard.Suit.HEARTS, WarCard.Rank.JACK);
        WarCard card2 = new WarCard(WarCard.Suit.CLUBS, WarCard.Rank.JACK);

        assertEquals(0, card1.compareTo(card2), "Same rank should return 0");
    }

    @Test
    public void testToString() {
        WarCard card = new WarCard(WarCard.Suit.SPADES, WarCard.Rank.ACE);
        assertEquals("ACE of SPADES", card.toString(), "String format should match");
    }
}
