<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
	<title>Cabinet</title>
</head>
<body class = "body_style">
<header class="header">
	<div class="container">
		<div class="header_inner">
			<div class="header_logo"><a class="nav_link" href="${contextPath}/main">Coding City</a></div>
			<nav class="nav">
				<ul>
                   <sec:authorize access="hasAuthority('ADMIN')">
                                           <li><a class="nav_link" href="${contextPath}/admin/create_courses">Create course</a></li>
                                       </sec:authorize>
                               <li><a class="nav_link" href="${contextPath}/logout">Sign out</a></li>
                               <li><a class="nav_link" href="${contextPath}/courses">Our courses</a></li>
				</ul>
			</nav>
		</div>
	</div>
</header>
    <section class="section">
            <div class="intro_inner">
				<h1 class="intro_title">Welcome back, ${user.getFirstName()} ${user.getLastName()}</h1>
				<h2 class="section_title1">Amount of money: ${user.getAmountOfMoney()}</h2>
				<a class="btn" href="${contextPath}/cabinet/money">Add money</a>
			</div>
    </section>
    <div class="section_header">
    <h2 class="section_title1">Your courses</h2>
    </div>
    <c:forEach items="${courses}" var="course">
    <div class="container">
    <div class="section_header">
            				<h2 class="section_title1">${course.name}</h2>
            			</div>
    	<table>
    			<tr class = "th_thead">
    			    <th>Num of day</th>
    				<th>Task</th>
    				<th>Links</th>
    				<th>Status</th>
    			</tr>
    		 <c:forEach items="${course.getTasks()}" var="task">
    		 <c:forEach items="${progresses}" var="progress">
    		 <c:if test = "${progress.getTask().getId().equals(task.getId())}">
                       			<tr class="tr_tbody">
                       				<td class = "td_tbody">${task.getNumberOfDay()}</td>
                       				<td class = "td_tbody">${task.getTask()}</td>
                       				<td class = "td_tbody">${task.getLinks()}</td>
                       				<td class = "td_tbody">${progress.getProgress()}</td>
                       			</tr>
             </c:if>
    		</c:forEach>
    		</c:forEach>
    	</table>
    </div>
    </c:forEach>
    <div class="container">
    <c:if test = "${size!=0}">
        	<springForm:form  method="POST" action="${contextPath}/cabinet" modelAttribute="courseRes">
                            <h2 class="section_title1">Select info about task you want to change</h2>
                                <springForm:select path="name">
                                    <springForm:options items="${courses}" itemValue="name" itemLabel="name"/>
                                </springForm:select>
                                <springForm:select path="day">
                                    <springForm:options items="${days}" itemValue="day" itemLabel="day"/>
                                </springForm:select>
                                <springForm:select path="status">
                                    <springForm:options items="${statuses}" itemValue="status" itemLabel="status"/>
                                </springForm:select>
                                <springForm:button type="submit" class="btn-submit">Select</springForm:button>
            </springForm:form>
      </c:if>
    </div>

</body>
</html>