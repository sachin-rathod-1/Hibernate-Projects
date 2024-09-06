<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/MyHibernateWeb/EmployeeServlet">
		<table>
			<tr>
				<td>Employee Name:</td>
				<td> <input type="text" name="ename" /> </td>
			</tr>
			<tr>
				<td>Employee Email:</td>
				<td> <input type="text" name="email" /> </td>
			</tr>
			<tr>
				<td>Employee Password:</td>
				<td> <input type="password" name="pass" /> </td>
			</tr>	
			<tr>
				<td>Address:</td>
				<td> <textarea name="address" rows="6" cols="20" ></textarea> </td>
			</tr>	
			<tr>
				<td>Salary:</td>
				<td> <input type="text" name="salary" /> </td>
			</tr>
			<tr>
				<td></td>
				<td> 
				<input type="submit" value="Add Employee" name="addemp"/>
				<input type="submit" value="View all Employees" name="VieveEmployees"/> 
				<input type="reset" value="Cancle"/>
				</td>
			</tr>				
		</table> 
	</form>	
</body>
</html>