<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is a page for you to solve some quizs</title>
</head>
<body>
	<c:if test="${empty answer}">
		<form action="quizSubmitted" method="post">
			<label> 1. 4 + 6 = </label> <input type="hidden" name="question1" value="1">
			<input type="text" name="answer1" /> <br />
			<label> 2. 3 + 3 = </label> <input type="hidden" name="question2" value="2">
			<input type="text" name="answer2" /> <br />
			<label> 3. 1 + 1 = </label> <input type="hidden" name="question3" value="3">
			<input type="text" name="answer3" /> <br />
			<label> 4. 1 + 2 = </label> <input type="hidden" name="question4" value="4">
			<input type="text" name="answer4" /> <br />
			<label> 5. 1 + 3 = </label> <input type="hidden" name="question5" value="5">
			<input type="text" name="answer5" /> <br />
			<label> 6. 1 + 4 = </label> <input type="hidden" name="question6" value="6">
			<input type="text" name="answer6" /> <br />
			<label> 7. 1 + 5 = </label> <input type="hidden" name="question7" value="7">
			<input type="text" name="answer7" /> <br />
			<label> 8. 1 + 6 = </label> <input type="hidden" name="question8" value="8">
			<input type="text" name="answer8" /> <br />
			<label> 9. 1 + 7 = </label> <input type="hidden" name="question9" value="9">
			<input type="text" name="answer9" /> <br />
			<label> 10. 1 + 8 = </label> <input type="hidden" name="question10" value="10">
			<input type="text" name="answer10" /> 
			<button>Submit</button>
		</form>
	</c:if>
	
	<c:if test="${!empty answer}">
		<h1>Correct answer.</h1>
	</c:if>
</body>
</html>