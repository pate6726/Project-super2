/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author jash kirtikumar patel
 * * @author pujan patel
 *  @author harshkumar patel
 */

import java.util.ArrayList;
import java.util.Collections;

public class WarDeck extends GroupOfCards {
    
    private ArrayList<Card> deckCards; // Store our own cards
    
    public WarDeck() {
        super(52);
        initializeDeck();
    }
    
    // Create all 52 cards
    private void initializeDeck() {
        deckCards = new ArrayList<>();
        
        for (WarCard.Suit suit : WarCard.Suit.values()) {
            for (WarCard.Rank rank : WarCard.Rank.values()) {
                deckCards.add(new WarCard(suit, rank));
            }
        }
    }
    
    // Override getCards to return our deck
    @Override
    public ArrayList<Card> getCards() {
        return deckCards;
    }
    
    // Override shuffle to shuffle our deck
    @Override
    public void shuffle() {
        Collections.shuffle(deckCards);
    }
    
   //dealing card here
    public WarCard dealCard() {
        if (deckCards != null && !deckCards.isEmpty()) {
            return (WarCard) deckCards.remove(0);
        }
        return null;
    }
    
//checking if deck has cardds
    public boolean hasCards() {
        return deckCards != null && !deckCards.isEmpty();
    }
}