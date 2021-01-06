<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    	<meta charset="utf-8">
        	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
        	<link href="https://fonts.googleapis.com/css?family=Lobster|Oswald:400,700|Poiret+One&display=swap" rel="stylesheet">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
            <script src="${contextPath}/resources/js/jquery.vide.min.js"></script>
            <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
                    integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
                    crossorigin="anonymous"></script>
	<title>Coding city</title>
</head>
<body>
<header class="header">
	<div class="container">
		<div class="header_inner">
			<div class="header_logo"><a class="nav_link" href="${contextPath}/main">Coding City</a></div>
			<nav class="nav">
				<ul>
				    <sec:authorize access="hasAuthority('ADMIN')">
                        <li><a class="nav_link" href="${contextPath}/admin/create_courses">Create course</a></li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                      <li><a class="nav_link" href="#">Cabinet</a>
                                   <ul class="submenu">
                                        <li><a class="nav_link" href="${contextPath}/cabinet">Your profile</a></li>
                                        <li><a class="nav_link" href="${contextPath}/logout">Sign out</a></li>
                                  </ul>
                      </li>
                      <li><a class="nav_link" href="${contextPath}/courses">Our courses</a></li>
                    </sec:authorize>
                    <sec:authorize access="!isAuthenticated()">
                    <ul>
                         <li><a class="nav_link" href="${contextPath}/login">Sign in</a></li>
                    </ul>
                     </sec:authorize>
				</ul>
			</nav>
		</div>
	</div>
	</div>
</header>
	<div class="intro">
		<div class="container">
			<div class="intro_inner">
				<h1 class="intro_title">No such task for this course</h1>
			</div>
		</div>
	</div>
</body>
</html>