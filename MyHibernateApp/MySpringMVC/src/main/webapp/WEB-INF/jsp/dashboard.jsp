<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	Welcome to Dashboard
	<br>
	<%
		out.println("User Name:"+session.getAttribute("userName")+"<br/>");
		out.println("Email:"+session.getAttribute("email"));
	%>
	<br>
	<a href="<%=request.getContextPath()%>/loadPageOnMenuClick/addNewItem">Add Items </a>
		
	<a href="<%=request.getContextPath()%>/showItems">Show Items </a>
</body>
</html>