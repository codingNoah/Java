<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		HttpSession s = request.getSession();
		String name = (String) session.getAttribute("name");
		
		if(name != null){
			response.sendRedirect("index.jsp");
		}
	%>
	<h1>Login to your account.</h1>
	<form action="LoginServlet" method="post">
		<div>
			<label for="name">Name:</label>
			<input type="text" name="name" id="name" required>
		</div>
		
		<div>
			<label for="password">Password:</label>
			<input type="password" name="password" id="password" required>
		</div>
		<button type="submit">Login</button>
	</form>
	<br />
	<div>
	<section>don't have an account?</section>
	<a href="RegistrationForm.jsp">Register</a>
	</div>
</body>
</html>