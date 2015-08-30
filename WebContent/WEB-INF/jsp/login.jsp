<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Management Analysis</title>
</head>
<body>
<form action="userDetails.htm" method="post">
<table>
	<tr>
	<td>Name:</td>
	<td><input id="user_id" name="user_id" type="text" value="">
	</tr>
	<tr>
	<td>Password:</td>
	<td><input id="password" name="password" type="password" value="">
	</tr>
</table>
<div style="color: red;">
<c:choose>
<c:when test="${not empty failure }">
${failure }
</c:when>
</c:choose>
<br>
</div>

<input type="submit" value="submit">
</form>
</body>
</html>