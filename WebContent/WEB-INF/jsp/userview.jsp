<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="rolechange" align="right">
		<select id="roleselect" style="border: none;width:100px;" onchange="userDetails.htm">
			<option value="manager">Manager</option>
			<option value="user">User</option>
		</select>
	</div>
	<div id="Order Details">
		<table>
			<tr>
				<th>Order ID</th>
				<th>Reason for Change</th>
				<th>Comments</th>
			</tr>
			<c:forEach var="orderdetail" items="">
			<tr>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>