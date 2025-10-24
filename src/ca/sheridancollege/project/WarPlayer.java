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
public class WarPlayer extends Player {
    
    private int wins;
    private int losses;
    
    public WarPlayer(String name) {
        super(name);
        this.wins = 0;
        this.losses = 0;
    }
    
    public int getWins() {
        return wins;
    }
    
    public int getLosses() {
        return losses;
    }
    
    public void addWin() {
        wins++;
    }
    
    public void addLoss() {
        losses++;
    }
    
    // Show player stats
    public void showStats() {
        System.out.println(getName() + " - Wins: " + wins + ", Losses: " + losses);
    }
    
    @Override
    public void play() {
        
    }
}
