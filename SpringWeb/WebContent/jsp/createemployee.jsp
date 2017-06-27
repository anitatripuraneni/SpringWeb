<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Employee</title>
</head>
<body>
	<sf:form method="post"
		action="${pageContext.request.contextPath}/docreate" commandName="employee">
		<table class="formtable">
			<tr>
			<tr>
				<td>Name:</td>
				<td><sf:input path="name" name="name" type="text"/></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><sf:input path="email" name="email" type="text"/></td>
			</tr>
			<tr>
				<td>text:</td>
				<td><sf:input path="text" name="text" type="text"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input value="Create Employee" type="submit"></td>
			</tr>

		</table>
	</sf:form>
</body>
</html>