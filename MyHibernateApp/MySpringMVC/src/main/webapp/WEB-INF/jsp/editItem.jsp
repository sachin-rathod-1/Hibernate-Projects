<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Item Details</title>
<script>
	function updateItems(id)
	{
		document.forms[0].action="<%=request.getContextPath()%>/updateItems/"+id;
		document.forms[0].method="post";
		document.forms[0].submit();
	}
	function pageOnLoad()
	{
		$('#itemName').val('${addItemModel.itemName}');	
		$('#itemCode').val('${addItemModel.itemCode}');
		$('#itemType').val('${addItemModel.itemType}');
	}
</script>
<style>
td {
	padding: 10px;
}
</style>
</head>
<body onload="pageOnLoad()">
	<form action="">
		<center>
			<table width="350px"
				style="border-collapse: collapse; border: 1px solid;">
				<tr>
					<BR>
					<font color='gold' size=4>Edit Item</font>
					<HR>
				</tr>
			</table>
			<table width="350px">
				<tr>
					<td>Item Name:</td>
					<td><input type="text" name="itemName" id="itemName" /></td>
				</tr>
				<tr>
					<td>Item Code:</td>
					<td><input type="text" name="itemCode" id="itemCode" /></td>
				</tr>
				<tr>
					<td>Item Type:</td>
					<td><select name="itemType" id="itemType">
							<option>---Select Item Type---</option>
							<option value="Laptop">Laptop</option>
							<option value="USB">USB</option>
							<option value="Mouse">Mouse</option>
					</select></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="button" name="update" value="Update"
						onclick="updateItems(${addItemModel.id})" /></td>
				</tr>
				<tr>
					<td colspan=2>${message}</td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>