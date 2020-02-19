<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function myFunction() {
		return confirm("Are you sure ? you want to delete..!!");
	}
</script>
</script>
</head>
<body bgcolor="F6B8CF">
	<center>
		<h2 style="color: blue; text-align: center;">
			<marquee>View All Contact Page...!!</marquee>
		</h2>
		<a href="/home" style="text-align: right;">+Add New Contact</a> <br>
		<h1></h1>
		<font color="green">${successMessage}</font><br>
		<table border="1" bgcolor="yellow">
			<tr background="yellow">
				<th>SL.NO</th>
				<th>CONTACT NAME</th>
				<th>CONTACT EMAIL</th>
				<th>CONTACT NUMBER</th>
				<th>CREATED DATE</th>
				<th>UPDATE DATE</th>
				<th>ACTION</th>
			</tr>
			<c:forEach items="${listContacts}" var="contact">
				<tr bgcolor="cyan">
					<td><c:out value="${contact.contactId}" /></td>
					<td><c:out value="${contact.contactName}" /></td>
					<td><c:out value="${contact.contactEmail}" /></td>
					<td><c:out value="${contact.contactNumber}" /></td>
					<td><c:out value="${contact.createDate}" /></td>
					<td><c:out value="${contact.updateDate}" /></td>
					<td><a href="/edit/${contact.contactId}">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="/delete?contactId=${contact.contactId}"
						onclick="return myFunction()">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<br> <a href="/home">Home</a>
</body>
</center>
</html>
