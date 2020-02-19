<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
	<div align="center">
		<h1 style="color: red;">
			<marquee>WELCOME TO SAVE CONTACT HOME PAGE...!!</marquee>
		</h1>
		<h3 style="color: blue;">${successMsg}</h3>
		<h3 style="color: green;">${errorMsg}</h3>
		<form:form action="/processFrom?contactId=${contact.contactId}"
			modelAttribute="contact">
			<table border="1" bgcolor="yellow">
				<tr>
					<td colspan="2" align="center"><b style="color: red;">Enter
							Your Data</b></td>
				</tr>
				<tr>
					<td>Contact Name ::</td>
					<td><form:input path="contactName" /></td>
				</tr>
				<tr>
					<td>Contact Email ::</td>
					<td><form:input path="contactEmail" /></td>
				</tr>
				<tr>
					<td>Contact Number ::</td>
					<td><form:input path="contactNumber" /></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
						type="reset" value="Reset" /></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
						type="submit" value="Submit" /></td>
				</tr>
			</table>
			<br>
		&nbsp;&nbsp;&nbsp;<a href="/allContact">View All Contacts</a>
		</form:form>
</body>
</div>
</html>