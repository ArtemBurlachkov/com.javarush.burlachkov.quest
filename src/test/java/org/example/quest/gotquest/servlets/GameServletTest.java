package org.example.quest.gotquest.servlets;

import org.example.quest.gotquest.model.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameServletTest {

    private GameServlet servlet;

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private RequestDispatcher requestDispatcher;

    @BeforeEach
    void setUp() {
        servlet = new GameServlet();
    }

    @Test
    void testDoGetWithoutGameState() throws Exception {
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("gameState")).thenReturn(null);
        when(request.getContextPath()).thenReturn("/context");

        servlet.doGet(request, response);

        verify(response).sendRedirect("/context/start");
    }

    @Test
    void testDoGetWithGameState() throws Exception {
        GameState gameState = new GameState();
        gameState.setCurrentScene("start");

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("gameState")).thenReturn(gameState);
        when(request.getRequestDispatcher("/WEB-INF/views/game.jsp")).thenReturn(requestDispatcher);

        servlet.doGet(request, response);

        verify(request).setAttribute("scene", "start");
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    void testDoPostStartSceneOption1() throws Exception {
        testSceneTransition("start", "1", "tavern");
    }

    @Test
    void testDoPostStartSceneOption2() throws Exception {
        testSceneTransition("start", "2", "loyalty");
    }

    @Test
    void testDoPostTavernSceneOption1() throws Exception {
        testSceneTransition("tavern", "1", "prison");
    }

    @Test
    void testDoPostTavernSceneOption2() throws Exception {
        GameState gameState = new GameState();
        gameState.setCurrentScene("tavern");

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("gameState")).thenReturn(gameState);
        when(request.getParameter("action")).thenReturn("2");
        when(request.getContextPath()).thenReturn("/context");

        servlet.doPost(request, response);

        assertEquals("betrayal", gameState.getCurrentScene());
        assertFalse(gameState.isGameWon());
        assertEquals(1, gameState.getGamesPlayed());
        verify(response).sendRedirect("/context/game");
    }

    @Test
    void testDoPostPrisonSceneOption1() throws Exception {
        testSceneTransition("prison", "1", "victory");
    }

    @Test
    void testDoPostPrisonSceneOption2() throws Exception {
        GameState gameState = new GameState();
        gameState.setCurrentScene("prison");

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("gameState")).thenReturn(gameState);
        when(request.getParameter("action")).thenReturn("2");
        when(request.getContextPath()).thenReturn("/context");

        servlet.doPost(request, response);

        assertEquals("execution", gameState.getCurrentScene());
        assertFalse(gameState.isGameWon());
        assertEquals(1, gameState.getGamesPlayed());
        verify(response).sendRedirect("/context/game");
    }


    @Test
    void testDoPostRestartGame() throws Exception {
        GameState gameState = new GameState();
        gameState.setCurrentScene("victory");
        gameState.setGameWon(true);
        gameState.setGamesPlayed(5);

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("gameState")).thenReturn(gameState);
        when(request.getParameter("action")).thenReturn("continue");
        when(request.getContextPath()).thenReturn("/context");

        servlet.doPost(request, response);

        assertEquals("start", gameState.getCurrentScene());
        assertTrue(gameState.isGameWon());
        assertEquals(5, gameState.getGamesPlayed()); // Количество игр не должно увеличиваться
        verify(response).sendRedirect("/context/game");
    }

    private void testSceneTransition(String initialScene, String action, String expectedScene) throws IOException, IOException, ServletException {
        GameState gameState = new GameState();
        gameState.setCurrentScene(initialScene);

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("gameState")).thenReturn(gameState);
        when(request.getParameter("action")).thenReturn(action);
        when(request.getContextPath()).thenReturn("/context");

        servlet.doPost(request, response);

        assertEquals(expectedScene, gameState.getCurrentScene());
        verify(response).sendRedirect("/context/game");
    }
}