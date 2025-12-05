/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Jash Kirtikumar Patel
 */
public class WarDeckTest {
    
    @Test
    public void testGetCards_NotNullAnd52Cards() {
        WarDeck deck = new WarDeck();
        ArrayList<Card> cards = deck.getCards();

        assertNotNull(cards, "Deck should return a non-null card list");
        assertEquals(52, cards.size(), "A fresh deck should contain 52 cards");
    }

    @Test
    public void testShuffle_ChangesOrder() {
        WarDeck deck = new WarDeck();
        ArrayList<Card> beforeShuffle = new ArrayList<>(deck.getCards());

        deck.shuffle();
        ArrayList<Card> afterShuffle = deck.getCards();

      
        assertNotEquals(beforeShuffle, afterShuffle, "Shuffling should change card order");
    }

    @Test
    public void testDealCard_RemovesAndReturnsCard() {
        WarDeck deck = new WarDeck();

        int beforeSize = deck.getCards().size();
        WarCard card = deck.dealCard();

        assertNotNull(card, "dealCard() should return a real card");
        assertEquals(beforeSize - 1, deck.getCards().size(),
                "After dealing, deck size should decrease by 1");
    }

    @Test
    public void testHasCards_WhenFullDeck() {
        WarDeck deck = new WarDeck();
        assertTrue(deck.hasCards(), "A fresh deck should have cards");
    }

    @Test
    public void testHasCards_WhenEmptyDeck() {
        WarDeck deck = new WarDeck();

        // Emptying  the deck by dealing all cards
        for (int i = 0; i < 52; i++) {
            deck.dealCard();
        }

        assertFalse(deck.hasCards(), "After removing all cards, deck should be empty");
    }
}
