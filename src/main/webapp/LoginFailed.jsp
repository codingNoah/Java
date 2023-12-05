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
	<h4>Incorrect credentials</h4>
	<a href="Login.jsp">Try again</a>
</body>
</html>