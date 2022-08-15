<%@ page import="businessObjects.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Mary Rachid
  Date: 14/03/2022
  Time: 00:19
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
    <div>
        <div>
            <a class="text-center mt-4 name" style="color: #e5b935; font-size: 14px;background-color:#e8ebed; padding: 7px 16px; border-radius: 10px;" href="${pageContext.request.contextPath}/AllScoreServlet">Best scores</a>
            <a class="text-center mt-4 name" style="color: #e5b935; font-size: 14px;background-color:#e8ebed; padding: 7px 16px; border-radius: 10px;" href="${pageContext.request.contextPath}/DeconnectServlet">Logout</a>
            <div class="text-center mt-4 name" style="color: #e5b935; font-size: 30px; max-width: 60%; margin-left: 20%; margin-top: 60px">Dices Online</div>
        </div>
    </div>
    <div class="text-center mt-4 name" style="color: #ecf0f3; background-color: #e53b35; font-size: 20px;margin-top: 30px">GAME OVER !</div>
    <div class="text-center">
    <h5 style="margin-top: 40px">Score      : ${ user.getScore() } </h5>
    <h5 style="margin-top: 30px">Best Score  : ${ user.getBestScore() } </h5>
    <a style="margin-top: 40px; max-width: 250px" class="btn" href="${pageContext.request.contextPath}/ReinitGameServlet">Play Again</a>
    </div>

</div>



</body>
</html>
