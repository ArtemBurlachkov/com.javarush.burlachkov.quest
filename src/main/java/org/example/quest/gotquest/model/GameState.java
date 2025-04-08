package org.example.quest.gotquest.model;

public class GameState {
    private String currentScene;
    private String playerName;
    private int gamesPlayed;
    private boolean gameWon;
    private int gamesPlayedWon;
    private int gamesPlayedWin;

    public GameState() {
        this.gamesPlayed = 0;
        this.gamesPlayedWon = 0;
        this.gamesPlayedWin = 0;
    }

    public String getCurrentScene() {
        return currentScene;
    }

    public void setCurrentScene(String currentScene) {
        this.currentScene = currentScene;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getGamesPlayedWon() {
        return gamesPlayedWon;
    }

    public int getGamesPlayedWin() {
        return gamesPlayedWin;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void incrementGamesPlayed() {
        this.gamesPlayed++;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public void setGameWon(boolean gameWon) {
        this.gameWon = gameWon;
    }

    public void setGamesPlayed(int i) {
        this.gamesPlayed = i;
    }

    public void incrementGamesWon() {
        this.gamesPlayedWon++;
    }

    public void incrementGamesWin() {
        this.gamesPlayedWin++;
    }
}
