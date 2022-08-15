<%@ page import="businessObjects.GameState" %><%--
  Created by IntelliJ IDEA.
  User: Mary Rachid
  Date: 14/03/2022
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/style/inscription.css"
          rel="stylesheet">
</head>
<body>

<div class="wrapper">
    <div class="text-center">
        <a CLASS="btn mt-3" href="${pageContext.request.contextPath}/DeconnectServlet">
            Se deconnecter</a>
    </div>
    <div class="text-center mt-4 name">
        Welcome
            <%GameState gameState = (GameState) request.getSession().getAttribute("gameState");
                out.print(gameState.getUser().getPrenom());
            %> !!
    </div>

    <div>
        <div  class="text-center mt-4 name">
            <img src="${pageContext.request.contextPath}/images/gold.png" style="max-width: 50%">
        </div>
        <div>
            <div class="text-center mt-4 name">
                Régles de jeu
            </div>
            <div class="text-center" style="color: #1c1c1c; font-size: 14px; max-width: 84%; margin-top: 20px; margin-left: 8%">
                Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,
                when an unknown printer took a galley of type and scrambled it to make a type
                specimen book. It has survived not only five centuries,
                but also the leap into electronic typesetting, remaining essentially unchanged.
            </div>
        </div>
    </div>
    <div class="text-center">
        <form action="${pageContext.request.contextPath}/playServlet">
            <input class="btn mt-3" type="submit" value="Play" />
        </form>
    </div>

</div>

</body>
</html>
