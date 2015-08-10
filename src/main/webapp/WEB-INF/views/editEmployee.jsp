<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Edit Employee Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>

</head>
<body>
	<h1>Edit an Employee</h1>

	<form:form commandName="employee" method="post"  action="/edit/{id}">
		<table>
			<tbody>
				<tr>
					<td><form:label path="firstName">First Name</form:label></td>
					<td><form:hidden path="id" /><form:input path="firstName"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="lastName">Last Name</form:label></td>
					<td><form:input path="lastName"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="title">Title</form:label></td>
					<td><form:input path="title"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="address">Address</form:label></td>
					<td><form:input path="address"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="phoneNumber">Phone</form:label></td>
					<td><form:input path="phoneNumber"></form:input></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Save">
					</td>
				</tr>
			</tbody>
		</table>

	</form:form>

</body>
</html>