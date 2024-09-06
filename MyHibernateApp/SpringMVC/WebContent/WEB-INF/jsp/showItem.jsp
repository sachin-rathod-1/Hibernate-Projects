<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Item Details</title>
</head>
<body>
	<BR>
	<font color="cyan" size="4"> Show Item Details</font>
	<HR>
	<form>
		<div id="tbl">
			<table border=1 class="table">
				<tr>
					<th>Item Name</th>
					<th>Item Code</th>
					<th>Item Type</th>
					<th>Action</th>
				</tr>
				<c:choose>
					<c:when
						test="${addItemModels != null && fn:length(addItemModels) > 0}">
						<c:forEach var="model" items="${addItemModels}"
							varStatus="counter">
							<tr>
								<td><c:out value="${model.itemName}" /></td>
								<td><c:out value="${model.itemCode}" /></td>
								<td><c:out value="${model.itemType}" /></td>
								<td><a
									href="<%=request.getContextPath()%>/getItem/${model.id}">Update</a>&nbsp;/&nbsp;
									<a href="<%=request.getContextPath()%>/deleteItems/${model.id}">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</table>
		</div>
		${deleteMessage} ${updateMessage}
	</form>
</body>
</html>