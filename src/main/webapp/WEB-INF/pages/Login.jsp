<%@ page import="businessObjects.Message" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>MryChid game</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/style/login.css"
          rel="stylesheet">

</head>
<body>
<% String Context_path=request.getServletContext().getContextPath();%>
<div class="wrapper">
    <div class="logo"> <img src="http://www.zontikgames.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/b/a/backgammon-precision-dice-blue_primary.jpg" alt=""> </div>
    <div class="text-center mt-4 name"> Dice online </div>
    <form class="p-3 mt-3" action="<%=Context_path%>/LoginServlet" method="post">

        <div class="form-field d-flex align-items-center">
            <span class="far fa-user"></span>
            <input id="userName" placeholder="Username" type="text" name="login" value="" required="required"/>
        </div>
        <div class="form-field d-flex align-items-center">
            <span class="fas fa-key" ></span>
            <input id="pwd" placeholder="Password" type="password" name="password" required="required"/>
        </div>
        <input  class="btn mt-3" style="background-color: #0666e8" type="submit" value="Login" class="submit_btn"/>
        <div class="text-center fs-6" style="margin-top: 30px; ">
            <span style="font-size: smaller;">not registered?</span>
            <a style="color: #0666e8; font-size: smaller;" href="${pageContext.request.contextPath}/UserManagementServlet?create">Create an account !</a>
        </div>
    </form>
    <div>
    </div>
    <div style="font-size: smaller; background-color: #e8a006; border-radius: 10px; color: #ecf0f3" class="text-center fs-6">
        <%
            List<Message> messages = (List<Message>) request.getAttribute("messages");
            if (messages != null) {
                for (Message it : messages) {
                    out.print(it);
                }
             }%>
    </div>
</div>
</body>
</html>