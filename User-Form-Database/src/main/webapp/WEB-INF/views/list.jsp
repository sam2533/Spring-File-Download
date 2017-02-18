<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Users Show Page</title>
<style>
        tr:first-child
        {
            font-weight: bold;
            background-color: #C6C9C4;
        }
</style>
</head>
<body>
<div class="container">
	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert" >
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden=true>x</span>
			</button>
			<strong>${msg}</strong>
		</div>	
	</c:if>
	
	<h1>All Users</h1>
	<br>
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Phone Number</th>
				<th>Gender</th>
			</tr>
		</thead>
		
	<c:forEach var="user" items="${users}">
		<tr>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.phone}</td>
			<td>${user.gender}</td>
			<td>
				<spring:url value="/${user.id}" var="userUrl"/>
				<spring:url value="/${user.id}/update" var="userUpdateUrl"/>
				<spring:url value="/${user.id}/delete" var="userdeleteUrl"/>
				
			<button class="btn btn-info" onclick="location.href='${userUrl}'">
				Query
			</button>
			<button class="btn btn-info" onclick="location.href='${userUpdateUrl}'">
				Update
			</button>
			<button class="btn btn-info" onclick="location.href='${userdeleteUrl}'">
				Delete
			</button>
			</td>
		</tr>		
	</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/add' />">Add New Employee</a>
</div>
</body>
</html>