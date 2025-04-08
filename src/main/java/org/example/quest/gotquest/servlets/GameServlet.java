package org.example.quest.gotquest.servlets;

import org.example.quest.gotquest.model.GameState;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
        HttpSession session = req.getSession();
        GameState gameState = (GameState) session.getAttribute("gameState");

        if (gameState == null) {
            resp.sendRedirect(req.getContextPath() + "/start");
            return;
        }

        req.setAttribute("scene", gameState.getCurrentScene());
        req.getRequestDispatcher("/WEB-INF/views/game.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession();
        GameState gameState = (GameState) session.getAttribute("gameState");

        switch (gameState.getCurrentScene()) {
            case "start":
                if ("1".equals(action)) {
                    gameState.setCurrentScene("tavern");
                } else {
                    gameState.setCurrentScene("loyalty");
                    gameState.setGameWon(false);
                    gameState.incrementGamesWin();
                    gameState.incrementGamesPlayed();
                }
                break;
            case "tavern":
                if ("1".equals(action)) {
                    gameState.setCurrentScene("prison");
                } else {
                    gameState.setCurrentScene("betrayal");
                    gameState.setGameWon(false);
                    gameState.incrementGamesWin();
                    gameState.incrementGamesPlayed();
                }
                break;
            case "prison":
                if ("1".equals(action)) {
                    gameState.setCurrentScene("victory");
                    gameState.incrementGamesPlayed();
                    gameState.incrementGamesWon();
                    gameState.setGameWon(true);
                } else {
                    gameState.setCurrentScene("execution");
                    gameState.setGameWon(false);
                    gameState.incrementGamesWin();
                    gameState.incrementGamesPlayed();
                }
                break;
            case "loyalty":
            case "betrayal":
            case "execution":
            case "victory":
                gameState.setCurrentScene("start");
                break;
        }

        resp.sendRedirect(req.getContextPath() + "/game");
    }
}
