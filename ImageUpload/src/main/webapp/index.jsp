<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration with Photo</title>
</head>
<body>
	<form method="post" action="/ImageUpload/MyServlet" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Student Name:</td>
				<td>
					<input type="text" name="sname" />
				</td>
			</tr>
			<tr>
				<td>Email ID:</td>
				<td>
					<input type="text" name="email" />
				</td>
			</tr>
			<tr>
				<td>Mobile:</td>
				<td>
					<input type="text" name="mobile" />
				</td>
			</tr>
			<tr>
				<td>Photo:</td>
				<td>
					<input type="file" name="photo" />
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="Save" />
				</td>
			</tr>
			
		</table>
	</form>
	<form action="/ImageUpload/DisplayServlet">
	<table>
	<tr>
				<td></td>
				<td>
					<input type="submit" value="Display" />
				</td>
			</tr>
			</table>
	</form>
</body>
</html>