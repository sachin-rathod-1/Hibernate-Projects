<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration Form</title>
<script>
	function userRegistration()
	{
		document.forms[0].action="<%=request.getContextPath()%>/userRegistration";
		document.forms[0].method="post";
		document.forms[0].submit();
	}
</script>
</head>
<body>
	<form enctype="multipart/form-data">
		<table width="500px" align="center">
			<tr>
				<td>
					<table id="table2">
						<tr>
							<th>User Registration</th>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table>
						<tr>
							<td>Name:</td>
							<td><input type="text" name="name" id="name" maxlength="25" /></td>
							<td>Gender:</td>
							<td><input type="radio" name="gender" id="male" value="Male" />Male
								<input type="radio" name="gender" id="female" value="Female" />Female
							</td>
						</tr>
						<tr>
							<td>DOB:</td>
							<td><input type="text" name="dob" id="dob" maxlength="10" /></td>
							<td>Qualification:</td>
							<td><input type="text" name="qualification"
								id="qualification" maxlength="20" /></td>
						</tr>
						<tr>
							<td>Mobile:</td>
							<td><input type="text" name="mobile" id="mobile"
								maxlength="10" /></td>
							<td>Photo:</td>
							<td><input type="file" name="photo" id="photo" /></td>
						</tr>
						<tr>
							<td>Email ID:</td>
							<td><input type="text" name="email" id="email"
								maxlength="30" /></td>
							<td colspan=2></td>
						</tr>
						<tr>
							<td>Address:</td>
							<td colspan=3><input type="text" name="address" id="address" /></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td colspan=3><input type="password" name="password"
								id="password" maxlength="20" /></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="button" name="save" value="Save"
								onclick="userRegistration()" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>