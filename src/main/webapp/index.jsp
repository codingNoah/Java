<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="jakarta.servlet.http.HttpSession"%>
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

        
        if(name == null){
        	response.sendRedirect("Login.jsp");
        }
	
	%>
	Welcome ${name}
	<br/>
	<a href="LogoutServlet">Logout</a>
</body>
</html>