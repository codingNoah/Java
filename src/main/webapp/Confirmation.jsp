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
	<h1>You have successfully registered!</h1>
	<section>You can now <a href="/RegistrationSystem/Login.jsp">Login</a> to your account. </section>
</body>
</html>