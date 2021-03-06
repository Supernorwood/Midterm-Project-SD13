<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User Details</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<!-- this page should display a user's info and a list of their items
		!!! controller checks to see what user is allowed to see, adds bool named "authUserHasPermission" with true/false based on check.
		!!! use this bool to determine what to display:
		
		if the user is permission level 0:		
			"authUserHasPermission" is false
			the first name of the requested user is added to model, name is "requestedUserFirstName"
		if the user is permission level 1+:
			"authUserHasPermission" is true
			the user object is named "requestedUser"
		in both cases:
			the list of items is named "requestedUserItems"
	 -->
	<c:if test="${requestedUserDTO != null}">
		<form:form action="processUserUpdateInfo.do" method="post" modelAttribute="requestedUserDTO">
			<form:hidden path="userId" />
			<form:hidden path="permissionLevel" />
			Email:
			<form:input path="email" />
			Password:
			<form:input path="pwd" />
			First Name:
			<form:input path="firstName" />
			Last Name:
			<form:input path="lastName" />
			Phone Number:
			<form:input path="phone" />
			Street Address:
			<form:input path="street" />
			City:
			<form:input path="city" />
			State:
			<form:input path="state" />
			Zip Code:
			<form:input path="zip" />
			<input type="submit" value="Update Info">
		</form:form>
	</c:if>
	<%@ include file="footer.jsp"%>
</body>
</html>