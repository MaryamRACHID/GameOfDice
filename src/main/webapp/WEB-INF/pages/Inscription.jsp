<%@ page import="businessObjects.Message" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Mary Rachid
  Date: 13/03/2022
  Time: 13:52
  To change this template use File | Settings | File Templates.

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Title</title>
</head>
<body>
<% String Context_path=request.getServletContext().getContextPath();%>

<form action="<%=Context_path%>/UserManagementServlet" method="POST" >
  <fieldset>
    <legend>Inscription</legend>
    <p>Entrer vos informations pour s'inscrire sur le site</p>


    <label for="nom">nom<span class="requis">*</span></label>
    <input type="text" name="nom" value=""/>
    <br/>
    <label for="prenom">prénom<span class="requis">*</span></label>
    <input type="text" id="prenom" name="prenom" value=""/>
    <br/>
    <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
    <input type="password" id="motdepasse" name="password" value=""/><br/>
    <label for="nom">Nom d'utilisateur</label>
    <input type="text" id="nom" name=login value=""/>
    <br/>
    <input type="submit" value="Inscription" class="btn-primary"/>
    <br/>

  </fieldset>
</form>

</body>
</html>--%>









<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport"
        content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>App Game</title>

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
    <div class="row">
      <div class="col-md-6">
        <img src="${pageContext.request.contextPath}/images/dice.jpg">
      </div>
      <div class="col-md-6">
    <form class="p-4" method="post" action="${pageContext.request.contextPath}/UserManagementServlet">
      <fieldset>
        <legend class="text-center mt-4 name">Inscription</legend>
        <p>Entrer vos informations pour s'inscrire sur le site</p>
        <div class="form-field d-flex align-items-center">
          <input class="" type="text"  name="nom" value="" placeholder="Last Name *"/>
        </div>
        <div class="form-field d-flex align-items-center">
          <input class="" type="text" id="prenom" name="prenom" value=""  placeholder="First Name *"/>
        </div>
        <div class="form-field d-flex align-items-center">
          <input class="" type="password" id="motdepasse" name="password" value=""  placeholder="Password *"/>
        </div>
        <div class="form-field d-flex align-items-center">
          <input class="" type="text"  name=login value=""  placeholder="Username *"/>
        </div>

        <input class="form-group btn mt-3" style="background-color: #0666e8" type="submit" value="Inscription"/>
        <div class="form-group">
          <span style="font-size: smaller;">Already have an account?</span>
          <a style="color: #0666e8; font-size: smaller;" href="${pageContext.request.contextPath}/WEB-INF/pages/Login.jsp">Login !</a>
        </div>
      </fieldset>
    </form>
      </div>
    </div>
  </div>
</body>

</html>