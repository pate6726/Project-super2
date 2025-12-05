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
 */
public class WarPlayerTest {
    
   @Test
    public void testGetCardsNotNull() {
        WarDeck deck = new WarDeck();
        assertNotNull(deck.getCards(), "Deck card list should not be null");
    }

    @Test
    public void testDeckHas52CardsInitially() {
        WarDeck deck = new WarDeck();
        assertEquals(52, deck.getCards().size(), "New deck should contain 52 cards");
    }

    @Test
    public void testShuffleChangesOrder() {
        WarDeck deck = new WarDeck();
        String firstCardBefore = deck.getCards().get(0).toString();

        deck.shuffle();

        String firstCardAfter = deck.getCards().get(0).toString();

        // Order should usually change
        assertNotEquals(firstCardBefore, firstCardAfter,
                "Shuffling should change card order");
    }

    @Test
    public void testDealCardReducesDeckSize() {
        WarDeck deck = new WarDeck();

        int before = deck.getCards().size();
        WarCard dealt = deck.dealCard();
        int after = deck.getCards().size();

        assertNotNull(dealt, "Dealt card should not be null");
        assertEquals(before - 1, after, "Deck should shrink by 1 after dealing");
    }

    @Test
    public void testHasCardsWorks() {
        WarDeck deck = new WarDeck();
        assertTrue(deck.hasCards(), "Fresh deck should have cards");

        // Empty the deck
        for (int i = 0; i < 52; i++) {
            deck.dealCard();
        }

        assertFalse(deck.hasCards(), "After dealing all cards, deck should be empty");
    }
}
