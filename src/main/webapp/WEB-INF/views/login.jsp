<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
	<link href="https://fonts.googleapis.com/css?family=Lobster|Oswald:400,700|Poiret+One&display=swap" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/jquery.vide.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
	<title>Login</title>
</head>
<body>
<header class="header">
	<div class="container">
		<div class="header_inner">
			<div class="header_logo"><a class="nav_link" href="${contextPath}/main">Coding City</a></div>
			<nav class="nav">
				<ul>
					<li><a class="nav_link" href="${contextPath}/registration">Registration</a></li>
				</ul>
			</nav>
		</div>
	</div>
</header>
	<div data-vide-bg="${contextPath}/resources/videos/background.gif">
		<div class="container">
			<div class="intro_inner">
				<div class="registration" id="log">
		           <div class="container">
                      <div class="intro_inner">
                      <form method="POST" action="${contextPath}/login" class="box">
                              <h2 class="section_title1">Login</h2>
                              <input type="email" name="username" placeholder="Email">
                              <input type="password" name="password" placeholder="Password">
                              <input type="submit" name="" value="Login">
                      </form>
			      </div>
              </div>
	            </div>
			</div>
		</div>
	</div>
</body>
</html>