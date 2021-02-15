<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    
    <form name="student_form" action="insert" method="post">
    <caption><h2>New Student Form</h2></caption>
        <p><label>Student Name:</label>
        <input type="text" name="studentname" value="">
        <br>
        <p><label>Student Cohort:</label>
        <input type="text" name="studentcohort" value="">
        <p><label>Student Track:</label>
        <input type="text" name="studenttrack" value="">
        <p><label>Student Internship:</label>
        <input type="text" name="studentinternship" value="">
        <p><label>Email:</label>
    	<input type="text" name="studentEmail" value="">
        <p><label>Converted?</label>
        <p>Yes <input type="radio" name="converted" value="yes">  No<input type="radio" name="converted" value="no"><br>
        <input id="submit-btn" 	type="submit" value="Submit">
    </form>
</body>
</html>