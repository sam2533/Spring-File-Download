<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Successfully added page</title>
</head>
<body>
<div class="container">
	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">x</span>
			</button>
		<strong>${msg}</strong>		
		</div>
	</c:if>
	
	<h1>User Detail</h1>
	<br>
	
	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${user.id}</div>
	</div>
	<div class="row">
		<label class="col-sm-2">Name</label>
		<div class="col-sm-10">${user.name}</div>	
	</div>
	<div class="row">
		<label class="col-sm-2">Email</label>
		<div class="col-sm-10">${user.email}</div>
	</div>
	<div class="row">
		<label class="col-sm-2">Date of Birth</label>
		<div class="col-sm-10"><fmt:formatDate value="${user.date}" type="date"/></div>
	</div>
	<div class="row">
		<label class="col-sm-2">Phone Number</label>
		<div class="col-sm-10">${user.phone}</div>
	</div>
	<div class="row">
		<label class="col-sm-2">Address</label>
		<div class="col-sm-10">${user.address}</div>
	</div>
	<div class="row">
		<label class="col-sm-2">Gender</label>
		<div class="col-sm-10">${user.gender}</div>
	</div>
Go back to <a href="<c:url value='/users' />">List of All Employees</a>
</div>
</body>
</html>