<html>
<head>
<title>Student Tracking System</title>
<script>
	function logIn()
	{
    	document.forms[0].action="logIn";
    	document.forms[0].submit();
	}
	function signUp()
	{
    	document.forms[0].action="signUp";
    	document.forms[0].submit();
	}
</script>
</head>
<body>
	<form>
		<table align="center">
			<tr>
				<th colspan="2">Login Into System</th>
			</tr>
			<tr>
				<td>User Id</td>
				<td><input type="text" name="userName" id="userName"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" id="password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="button" name="LogIn" value="Log In"
					onclick="logIn()"> 
					<input type="button" name="SignUp"
					value="Sign Up" onclick="signUp()"></td>
			</tr>
			<tr>
				<td colspan="2">${message}</td>
			</tr>
		</table>
	</form>
</body>
</html>