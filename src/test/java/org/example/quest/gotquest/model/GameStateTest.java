package org.example.quest.gotquest.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameStateTest {
    @Test
    void testInitialState() {
        GameState gameState = new GameState();

        assertNull(gameState.getCurrentScene());
        assertNull(gameState.getPlayerName());
        assertEquals(0, gameState.getGamesPlayed());
        assertFalse(gameState.isGameWon());
    }

    @Test
    void testIncrementGamesPlayed() {
        GameState gameState = new GameState();

        gameState.incrementGamesPlayed();
        assertEquals(1, gameState.getGamesPlayed());

        gameState.incrementGamesPlayed();
        assertEquals(2, gameState.getGamesPlayed());
    }

    @Test
    void testSettersAndGetters() {
        GameState gameState = new GameState();

        gameState.setCurrentScene("testScene");
        gameState.setPlayerName("Test Player");
        gameState.setGameWon(true);

        assertEquals("testScene", gameState.getCurrentScene());
        assertEquals("Test Player", gameState.getPlayerName());
        assertTrue(gameState.isGameWon());
    }
}