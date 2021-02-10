<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
        <h1><a href="list">Student List</a></h1>
        <h2><a href="new">Add new student</a></h2>
    </div>
	
	<div class = "container">
		<table>
		<caption>List of Students</caption>
		<tr>
			<th>Student name</th>
			<th>Student cohort</th>
			<th>Student track</th>
			<th>Student internship</th>
			<th>Converted</th>
		</tr>

		<c:forEach items="${student_list}" var="item">
		<tr>
			<td>${item.getStudentName()}</td>
			<td>${item.getStudentCohort()}</td>
			<td>${item.getStudentTrack()}</td>
			<td>${item.getStudentInternship()}</td>
			<td>${item.getStudentConversion()}</td>
		</tr>
	</c:forEach>
		
	<c:forEach items = "${student_email}" var="item">
			<p><a href="mailto:${item}">${item}"</a>
	</c:forEach>
		</table>
</body>
</html>