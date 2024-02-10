package org.hw19;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameProcTest {

    private Game game;
    private Player player;
    private Player computer;

    @BeforeEach
    void setUp(){
        player = new Player();
        computer = new Player();
        game = new Game(player, computer);
    }

    @Test
    void isValidChoiceTest() throws Exception {
        String validChoice = "rock";

        assertTrue(game.isValidChoice(validChoice), "Should be true");

        String invalidChoice = "wrongInput";

        assertThrows(RuntimeException.class, () -> game.isValidChoice(invalidChoice), "Should throw exception");
    }

    @Test
    void calculateWinnerDrawTest(){
        player.setSymbol('r');
        computer.setSymbol('r');
        assertEquals(0, player.getWins() + player.getLosses());
        assertEquals(0, computer.getWins() + computer.getLosses());

        game.calculateWinner();
        assertEquals(0, player.getWins() + player.getLosses());
        assertEquals(0, computer.getWins() + computer.getLosses());

        player.setSymbol('p');
        computer.setSymbol('p');
        game.calculateWinner();
        assertEquals(0, player.getWins() + player.getLosses());
        assertEquals(0, computer.getWins() + computer.getLosses());

        player.setSymbol('s');
        computer.setSymbol('s');
        game.calculateWinner();
        assertEquals(0, player.getWins() + player.getLosses());
        assertEquals(0, computer.getWins() + computer.getLosses());
    }

    @Test
    void calculateWinnerPWinTest(){
        player.setSymbol('r');
        computer.setSymbol('s');
        assertEquals(0, player.getWins() + player.getLosses());
        assertEquals(0, computer.getWins() + computer.getLosses());

        game.calculateWinner();
        assertEquals(1, player.getWins());
        assertEquals(0, player.getLosses());
        assertEquals(1, computer.getLosses());
        assertEquals(0, computer.getWins());


        player.setSymbol('p');
        computer.setSymbol('r');
        game.calculateWinner();
        assertEquals(2, player.getWins());
        assertEquals(0, player.getLosses());
        assertEquals(2, computer.getLosses());
        assertEquals(0, computer.getWins());

        player.setSymbol('s');
        computer.setSymbol('p');
        game.calculateWinner();
        assertEquals(3, player.getWins());
        assertEquals(0, player.getLosses());
        assertEquals(3, computer.getLosses());
        assertEquals(0, computer.getWins());
    }

    @Test
    void calculateWinnerCWinTest(){
        computer.setSymbol('r');
        player.setSymbol('s');
        assertEquals(0, player.getWins() + player.getLosses());
        assertEquals(0, computer.getWins() + computer.getLosses());

        game.calculateWinner();
        assertEquals(1, computer.getWins());
        assertEquals(0, computer.getLosses());
        assertEquals(1, player.getLosses());
        assertEquals(0, player.getWins());

        computer.setSymbol('p');
        player.setSymbol('r');
        game.calculateWinner();
        assertEquals(2, computer.getWins());
        assertEquals(0, computer.getLosses());
        assertEquals(2, player.getLosses());
        assertEquals(0, player.getWins());

        computer.setSymbol('s');
        player.setSymbol('p');
        game.calculateWinner();
        assertEquals(3, computer.getWins());
        assertEquals(0, computer.getLosses());
        assertEquals(3, player.getLosses());
        assertEquals(0, player.getWins());
    }

    @Test
    void getRandomSymbolTest(){
        boolean rockFlag = false;
        boolean paperFlag = false;
        boolean scissorsFlag = false;

        while( !(rockFlag && paperFlag && scissorsFlag)){
            String symbol = Main.getRandomSymbol();

            switch (symbol){
                case "rock": rockFlag = true; break;
                case "paper": paperFlag = true; break;
                case "scissors": scissorsFlag = true; break;
                default: fail();
            }
        }
    }

    @Test
    void getResultsTest(){
        player.setWins(1);
        computer.setLosses(1);
        assertEquals("You won", game.getResults(player, computer));

        player.setWins(0);
        player.setLosses(1);
        computer.setLosses(0);
        computer.setWins(1);
        assertEquals("You lost", game.getResults(player, computer));

        player.setWins(1);
        computer.setLosses(1);
        assertEquals("Draw", game.getResults(player, computer));
    }
}














