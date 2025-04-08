<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>Game of Thrones Quest</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
    <style>
        <c:choose>
        <c:when test="${scene == 'start'}">
        body {
            background-image: url('${pageContext.request.contextPath}/images/Varias.jpg');
        }

        </c:when>
        <c:when test="${scene == 'tavern'}">
        body {
            background-image: url('${pageContext.request.contextPath}/images/Tirion.jpg');
        }

        </c:when>
        <c:when test="${scene == 'prison'}">
        body {
            background-image: url('${pageContext.request.contextPath}/images/Gavan.jpg');
        }

        </c:when>
        <c:otherwise>
        body {
            background-image: url('${pageContext.request.contextPath}/images/Throne.png');
        }

        </c:otherwise>
        </c:choose>
    </style>
</head>

<body>


<div class="container">
    <c:choose>
        <c:when test="${scene == 'start'}">
            <h1>Ночь в Королевской Гавани</h1>
            <p>Вы — лорд Эдрик Дарквуд. В таверне к вам подходит Варис:</p>
            <p>"Тайные слуги сообщают, что королева Серсея планирует казнить невинных. Ваши действия?"</p>
            <form action="${pageContext.request.contextPath}/game" method="post">
                <button type="submit" name="action" value="1">Предупредить горожан (рискнуть собой)</button>
                <button type="submit" name="action" value="2">Сохранить верность короне (игнорировать)</button>
            </form>
            <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
            <p>Игрок: ${gameState.playerName} </p>
            <p>Игр сыграно: ${gameState.gamesPlayed}</p>
        </c:when>

        <c:when test="${scene == 'tavern'}">
            <h1>Предупреждение горожан</h1>
            <p>Вы предупредили горожан, но вас арестовали. Казнь через 3 дня.</p>
            <p>Вас посещает Тирион:</p>
            <p>"Я могу вас спасти, но взамен вы должны..."</p>
            <form action="${pageContext.request.contextPath}/game" method="post">
                <button type="submit" name="action" value="1">Поклясться в верности Дейенерис</button>
                <button type="submit" name="action" value="2">Отказаться и надеяться на милость Серсеи</button>
            </form>
            <p>Игрок: ${gameState.playerName} </p>
            <p>Игр сыграно: ${gameState.gamesPlayed}</p>

        </c:when>

        <c:when test="${scene == 'prison'}">
            <h1>Побег</h1>
            <p>Тирион организует побег. Вы плывете в Миэрин.</p>
            <p>Дейенерис предлагает:</p>
            <form action="${pageContext.request.contextPath}/game" method="post">
                <button type="submit" name="action" value="1">Возглавить штурм Королевской Гавани</button>
                <button type="submit" name="action" value="2">Стать её послом к Королю Ночи</button>
            </form>
            <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
            <p>Игрок: ${gameState.playerName} </p>
            <p>Игр сыграно: ${gameState.gamesPlayed}</p>
        </c:when>

        <c:when test="${scene == 'victory' || scene == 'loyalty' || scene == 'betrayal' || scene == 'execution'}">
            <div class="player-info">
                <H1>${gameState.gameWon ? "Вы победили!" : "Вы проиграли!"}</H1>
                <h3>Игрок: ${gameState.playerName} </h3>
                <p>Игр сыграно: ${gameState.gamesPlayed}</p>
                <p>Выиграно игр: ${gameState.gamesPlayedWon}</p>
                <p>Проиграно игр: ${gameState.gamesPlayedWin}</p>
            </div>
            <form action="${pageContext.request.contextPath}/game" method="post">
                <button type="submit" name="action" value="continue">Играть снова</button>
            </form>
        </c:when>
    </c:choose>
</div>
</body>
</html>
