<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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

</body>
</html>