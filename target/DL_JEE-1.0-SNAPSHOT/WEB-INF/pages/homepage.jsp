<%@ page import="businessObjects.GameState" %><%--
  Created by IntelliJ IDEA.
  User: Mary Rachid
  Date: 13/03/2022
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>home</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/style/login.css"
        rel="stylesheet">
</head>


<body>

<div class="wrapper">
  <div>
    <div class="text-center mt-4 name" style="color: #e5b935; font-size: 26px">
      Dices Online
    </div>
    <c:out value="${sessionScope.gameState.user.nom}" /><br>
    <a class="btn mt-3" style="background-color: #e5b935" href="${pageContext.request.contextPath}/AllScoreServlet">Meilleurs
      scores</a>
    <a class="btn mt-3" style="background-color: #e5b935" href="${pageContext.request.contextPath}/ReinitGameServlet">Réinitialiser
      le jeu</a>
    <a class="btn mt-3" style="background-color: #e5b935" href="${pageContext.request.contextPath}/DeconnectServlet">Se deconnecter</a>
  </div>


  <form action="${pageContext.request.contextPath}/GameServlet">
    <div class="text-center mt-4 name">
      Enter the dice numbre
    </div>
    <div class="form-field d-flex align-items-center">
      <input type="text" name="dice"/>
    </div>
    <div>
      <input class="btn mt-3" type="submit" value="Envoyer"/>
    </div>
  </form>
</div>




</body>

</html>
