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
	<form action="userdetails.htm">
	<input type="hidden" id="user_id" value="${user_id }">
	<div id="rolechange" align="right">
		<select id="roleselect" style="border: none;width:100px;" onchange="userDetails.htm">
			
			<option value="manager" selected>Manager</option>
			<option value="user" selected>User</option>
			
		</select>
	</div>
	<div id="Order Details">
		<table>
			<tr>
				<th>Order ID</th>
				<th>Reason for Change</th>
				<th>Comments</th>
				<th>edited user</th>
				<th>reviewed?</th>
				
				<th>review comments</th>
			</tr>
			<c:forEach var="orderdetail" items="${orderbolist}">
			<tr>
				<td>${orderdetail.order_id }</td>
				<td>${orderdetail.reason_code }</td>
				<td>${orderdetail.comments }</td>
				<td>${orderdetail.edited_user_id }</td>
				<td>${orderdetail.review }</td>
				<td>
					<textarea id ="review_comment" rows="1" cols="50"></textarea>
					<input id="review_update" value="update" type="submit">
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	</form>
</body>
</html>