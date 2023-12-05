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
	<h1>Create your account.</h1>
	<form action="RegisterServlet" method="post">
		<div>
			<label for="name">Name:</label>
			<input type="text" name="name" id="name" required>
		</div>
		<div>
			<label for="email">Email:</label>
			<input type="email" name="email" id="email" required>
		</div>
		<div>
			<label for="password">Password:</label>
			<input type="password" name="password" id="password" required>
		</div>
		<button type="submit">Register</button>
	</form>
	<br />
	<div>
	<section>already have an account?</section>
	<a href="Login.jsp">Login</a>
	</div>
</body>
</html>