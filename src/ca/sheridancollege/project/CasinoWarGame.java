/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/*game name --         "CASINO WAR" ----------------------------------------------
 * @author jash kirtikumar patel
*@author pujan patel
@author harshkumar patel
 */
import java.util.ArrayList;
import java.util.Scanner;

public class CasinoWarGame extends Game {
    
    private WarDeck deck;
    private WarPlayer player;
    private WarPlayer dealer;
    private Scanner scanner;
    
    public CasinoWarGame(String name) {
        super(name);
        this.deck = new WarDeck();
        this.scanner = new Scanner(System.in);
    }
    
    // Setup the game
    public void setupGame() {
        System.out.println("Welcome to Casino War!");
        System.out.println("Rules: Highest card wins. Ace is highest, 2 is lowest.");
        System.out.println("If cards tie, you go to WAR!\n");
        
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine().trim();
        if (playerName.isEmpty()) {
            playerName = "Charles";
        }
        
        player = new WarPlayer(playerName);
        dealer = new WarPlayer("Dealer");
        
        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        players.add(dealer);
        setPlayers(players);
        
        System.out.println("Game setup complete!\n");
    }
    
    @Override
    public void play() {
        deck.shuffle();
        boolean keepPlaying = true;
        
        while (keepPlaying) {
            // Check deck
            if (!deck.hasCards()) {
                System.out.println("Reshuffling deck...");
                deck = new WarDeck();
                deck.shuffle();
            }
            
            playRound();
            
            System.out.print("\nPlay another round? (Y/N): ");
            String response = scanner.nextLine().trim().toUpperCase();
            keepPlaying = response.equals("Y");
        }
        
        declareWinner();
    }
    
    // Play one round
    private void playRound() {
        System.out.println("\n--- New Round ---");
        System.out.print("Press Enter to draw cards...");
        scanner.nextLine();
        
        // Deal cards
        WarCard playerCard = deck.dealCard();
        WarCard dealerCard = deck.dealCard();
        
        // Show cards
        System.out.println(player.getName() + " draws: " + playerCard);
        System.out.println(dealer.getName() + " draws: " + dealerCard);
        
        // Compare cards
        int comparison = playerCard.compareTo(dealerCard);
        
        if (comparison > 0) {
            System.out.println(player.getName() + " WINS!");
            player.addWin();
            dealer.addLoss();
        } else if (comparison < 0) {
            System.out.println(dealer.getName() + " wins.");
            player.addLoss();
            dealer.addWin();
        } else {
            System.out.println("TIE! Going to WAR!");
            handleWar();
        }
    }
    
   
    private void handleWar() {
        System.out.println("WAR: Each player burns 3 cards, then draws 1 card.");
        System.out.print("Press Enter to go to war...");
        scanner.nextLine();
        
        // Burn 3 cards each
        System.out.println("Burning 3 cards each...");
        for (int i = 0; i < 3; i++) {
            deck.dealCard();
            deck.dealCard();
        }
        
        // Draw final cards
        WarCard playerWarCard = deck.dealCard();
        WarCard dealerWarCard = deck.dealCard();
        
        System.out.println(player.getName() + "'s WAR card: " + playerWarCard);
        System.out.println(dealer.getName() + "'s WAR card: " + dealerWarCard);
        
        // Compare war cards
        int warResult = playerWarCard.compareTo(dealerWarCard);
        
        if (warResult > 0) {
            System.out.println(player.getName() + " WINS THE WAR!");
            player.addWin();
            dealer.addLoss();
        } else if (warResult < 0) {
            System.out.println(dealer.getName() + " wins the war.");
            player.addLoss();
            dealer.addWin();
        } else {
            System.out.println("Another tie! Round is a draw.");
        }
    }
    
    @Override
    public void declareWinner() {
        System.out.println("\n=== GAME OVER ===");
        player.showStats();
        dealer.showStats();
        
        if (player.getWins() > dealer.getWins()) {
            System.out.println(player.getName() + " is the OVERALL WINNER!");
        } else if (player.getWins() < dealer.getWins()) {
            System.out.println(dealer.getName() + " wins overall.");
        } else {
            System.out.println("It's a TIE overall!");
        }
    }
    
    // Main method to run the game
    public static void main(String[] args) {
        CasinoWarGame game = new CasinoWarGame("Casino War");
        game.setupGame();
        game.play();
    }
}

