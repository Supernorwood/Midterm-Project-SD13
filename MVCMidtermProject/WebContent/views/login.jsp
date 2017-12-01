<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/Main.css">
<link rel="stylesheet" href="css/viv.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<%@ include file="navbar.jsp"%>

	<div class="mainpic">
		<img src="images/chickenrocks.jpg" width="100%" height="100%">
	</div>

	<div class="container">
		<div class="loginForm">
		<div class="row">
			<div class="col-md-6">
				<form action="showLogin.do" method="GET">
					Your email:
					<input type="text" name="userEmail" value="${user.userEmail}" placeholder="email" required>
					<br>
					<br> 
					Your password:
					<input type="password" name="userPass" value="${user.pwd}" placeholder="password" required>
					<br>
					<br> 
					<input type="submit" value="Login">

				</form>
				<br>
				<button type="button" class="cancelbtn">Cancel</button>
				<br>
				<br>
				<span class="psw">Forgot <a href="#">password?</a></span>
			</div>

			<div class="col-md-6">
				
			</div>
		</div>
		</div>



	</div>


	<%@ include file="footer.jsp"%>
</body>
</html>