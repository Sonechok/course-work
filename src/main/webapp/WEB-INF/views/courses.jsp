<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
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
	<title>Courses</title>
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
                               <li><a class="nav_link" href="#">Cabinet</a>
                    			  <ul class="submenu">
                    			     <li><a class="nav_link" href="${contextPath}/cabinet">Your profile</a></li>
                    			     <li><a class="nav_link" href="${contextPath}/logout">Sign out</a></li>
                                  </ul>
                    		   </li>
				</ul>
			</nav>
		</div>
	</div>
</header>
<body class = "body_style">
<c:forEach items="${courses}" var="course">
    <section class="section">
    		<div class="container">
    			<div class="section_header">
    				<h2 class="section_title1">${course.getName()}</h2>
    			</div>
    			<div class="courses">
    				<div class="courses_item" id = "course"></div>
    				<div class="courses_item">
    					<div class="accordion" >
    						<div class="accordion_item">
    							<div class="accordion_title">${course.name}</div>
    							<div class="accordion_content">
    								<p>
    								    ${course.description}<br>
    									Price = ${course.price}
    								</p>
    							</div>
    						</div>
    					</div>
    				</div>
    			</div>
    		</div>
    	</section>
</c:forEach>
    	<div class="container">
    	<springForm:form  method="POST" action="${contextPath}/courses" modelAttribute="courseRes">
                        <h2 class="section_title1">Select course you want to buy</h2>
                            <springForm:select path="name">
                                <springForm:options items="${courses}" itemValue="name" itemLabel="name"/>
                            </springForm:select>
                            <springForm:button type="submit" class="btn-submit">Select</springForm:button>
                    </springForm:form>

        </div>
</body>
</html>