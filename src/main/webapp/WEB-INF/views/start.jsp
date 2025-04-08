<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>Game of Thrones Quest - Start</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
  <style>


    body {
      background-image: url('${pageContext.request.contextPath}/images/Homes.jpg');
    }

  </style>
</head>
<body>
<div class="container">
  <h1>Введите ваш логин</h1>
  <form action="${pageContext.request.contextPath}/start" method="post">
    <input type="text" name="playerName" required>
    <button type="submit">Начать игру</button>
  </form>
</div>
</body>
</html>
