<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Item</title>
<script>
	function saveAddNewItem()
	{
		document.forms[0].action="<%=request.getContextPath()%>/saveAddNewItem";
		document.forms[0].method="post";
		document.forms[0].submit();
	}
</script>
</head>
<body>
	<form action="">
		<BR> <font color='gold' size="4"> Add New Item </font>
		<HR>
		<div>
			<div>
				<label>Item Name:</label> <input type="text" name="itemName"
					id="itemName" />
			</div>
		</div>
		<div>
			<div>
				<label>Item Code:</label> <input type="text" name="itemCode"
					id="itemCode" />
			</div>
		</div>
		<div>
			<div>
				<label>Item Type:</label> <select name="itemType" id="itemType">
					<option>---Select Item Type---</option>
					<option value="Laptop">Laptop</option>
					<option value="USB">USB</option>
					<option value="Mouse">Mouse</option>
				</select>
			</div>
		</div>
		<div>
			<div>
				<label>&nbsp;</label> <input type="button" name="save" value="Save"
					onclick="saveAddNewItem()" />
			</div>
		</div>
		<div>
			<div>${message}</div>
		</div>
	</form>
</body>
</html>