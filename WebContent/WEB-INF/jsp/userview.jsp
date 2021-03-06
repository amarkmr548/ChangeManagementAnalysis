<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Order details</title>
</head>
<body>
	<form action="userDetails.htm">
	<input type="hidden" id="user_id" value="${user_id }">
	<div id="rolechange" align="right">
		<select id="roleselect" style="border: none;width:100px;" onchange="JavaScript:document.forms[0].submit()">
			
			<option value="manager">Manager</option>
			<option value="user" selected>User</option>
			
		</select>
	</div>
	<div id="Order Details">
		<table>
			<tr>
				<th>Order ID</th>
				<th>Reason for Change</th>
				<th>Comments</th>
				<th>reviewed?</th>
				<th>review comments</th>
			</tr>
			<c:forEach var="orderdetail" items="${orderbolist}">
			<tr>
				<td>${orderdetail.order_id }</td>
				<td>${orderdetail.reason_code }</td>
				<td>${orderdetail.comments }</td>
				<td>${orderdetail.review }</td>
				<td>
				<c:choose>
				<c:when test="${not empty orderdetail.review_comments }">
					${orderdetail.review_comments }
				</c:when>
				<c:otherwise>
					Not reviewed yet
				</c:otherwise>
				</c:choose>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	</form>
</body>
</html>