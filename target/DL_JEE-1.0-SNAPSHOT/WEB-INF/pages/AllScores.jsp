<%@ page import="businessObjects.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Mary Rachid
  Date: 15/03/2022
  Time: 22:54
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
<div class="container" style="max-width: 800px; margin: 60px 0px 0px 200px">
    <div>
        <div>
            <c:out value="${sessionScope.gameState.user.nom}" /><br>
            <a class="text-center mt-4 name" style="color: #e5b935; font-size: 14px;background-color:#e8ebed; padding: 7px 16px; border-radius: 10px;" href="${pageContext.request.contextPath}/BESTcoreServlet">Mes scores</a>
            <a class="text-center mt-4 name" style="color: #e5b935; font-size: 14px;background-color:#e8ebed; padding: 7px 16px; border-radius: 10px;" href="${pageContext.request.contextPath}/DeconnectServlet">Logout</a>
            <a class="text-center mt-4 name" style="color: #e5b935; font-size: 14px;background-color:#e8ebed; padding: 7px 16px; border-radius: 10px;" href="${pageContext.request.contextPath}/ReinitGameServlet">Play again</a>
            <div style="max-width : 90%">
                <%
                    List<User> users = (List<User>) request.getAttribute("users");
                    PrintWriter ou = response.getWriter();
                    ou.print("<table style=\"max-width : 90%\" class=\"table table-hover\"><tr><td>Nom</td><td>Score</td></tr>");

                    //On affiche le best score
                    for (User it : users) {
                        ou.print("<tr><td>" + it.getNom() + " " + it.getPrenom() + "</td><td>" + it.getBestScore() + "</td></tr>");

                    }
                    ou.print("</table>");
                %>
            </div>
        </div>
    </div>

</div>




</body>
</html>
