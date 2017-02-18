<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session ="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration Form</title>
<style type="text/css">
.error
{
	color: #FA8072;
	font-style: oblique;
	font-weight: bold;
}	
tr:first-child
{
            font-weight: bold;
            background-color: #C6C9C4;
}
</style>
</head>
<body>
<h1>SIGN UP</h1>

<div class="container">
	<c:choose>
		<c:when test="${userForm['new']}">
		<h1>Add User</h1>
		</c:when>
		<c:otherwise>
		<h1>Update User</h1>
		</c:otherwise>
	</c:choose><br/>
	
	<form:form class="form-horizontal" method="POST"  modelAttribute="userForm">
		<form:hidden path="id"/>
		
		<spring:bind path="name">
			<div class="form-group ${status.error ? 'has-error' : '' }">
			<label class="control-label col-sm-2">Name</label>
			<div class="col-sm-10">
				<form:input path="name" type="text" id="name" placeholder="Name" class="form-control"/>
				<form:errors path="name" cssClass="error" class="control-label"/>
			</div>
			</div>	
		</spring:bind>
		<spring:bind path="password">
			<div class="form-group ${status.error ? 'has-error' : '' }">
			<label class="control-label col-sm-2">Password</label>
			<div class="col-sm-10">
				<form:password path="password" id="password" placeholder="Password" class="form-control"/>
				<form:errors path="password" cssClass="error" class="control-label"/>
			</div>
			</div>
		</spring:bind>
		<spring:bind path="confirmPassword">
			<div class="form-group ${status.error ? 'has-error' : '' }">
			<label class="control-label col-sm-2">Confirm Password</label>
			<div class="col-sm-10">
				<form:password path="confirmPassword" id="password" placeholder="Password" class="form-control"/>
				<form:errors path="confirmPassword" cssClass="error" class="control-label"/>		
			</div>
			</div>		
		</spring:bind>
		<spring:bind path="email">
			<div class="form-group ${status.error ? 'has-error' : '' }">
			<label class="control-label col-sm-2">Email</label>
			<div class="col-sm-10">
				<form:input path="email" type="text" id="email" class="form-control" placeholder="Email Address"/>
				<form:errors path="email" cssClass="error" class="control-label"/>
			</div>		
			</div>	
		</spring:bind>
		<spring:bind path="date">
			<div class="form-group ${status.error ? 'has-error' : '' }">
			<label class="control-label col-sm-2">Day of Birth</label>
			<div class="col-sm-10">
				<form:input path="date" id="date" placeholder="Birth Day" class="form-control"/>
				<form:errors path="date" cssClass="error" class="control-label"/>
			</div>
			</div>
		</spring:bind>
		<spring:bind path="phone">
			<div class="form-group ${status.error ? 'has-error' : '' }">
			<label class="control-label col-sm-2">Phone Number</label>
			<div class="col-sm-10">
				<form:input path="phone" id="phone" class="form-control" placeholder="Phone Number"/>
				<form:errors path="phone" cssClass="error" class="control-label"/>
			</div>		
			</div>	
		</spring:bind>
		<spring:bind path="address">
			<div class="form-group ${status.error ? 'has-error' : '' }">
			<label class="control-label col-sm-2">Address</label>
			<div class="col-sm-10">
				<form:textarea path="address" rows="6" class="form-control" id="address"/>
				<form:errors path="address" cssClass="error" class="control-label"/>
			</div>
			</div>	
		</spring:bind>
		<spring:bind path="gender">
			<div class="form-group ${status.error ? 'has-error' : '' }">
			<label class="control-label col-sm-2">Gender</label>
			<div class="col-sm-5">
				<form:select path="gender" id="gender" class="form-control">
					<form:option value="" label="Select Gender"/>
					<form:option value="MALE" label="Male"/>
					<form:option value="FEMALE" label="Female"/>
				</form:select>
				<form:errors path="gender" cssClass="error" class="control-label"/>
			</div>
			</div>
		</spring:bind>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${userForm['new']}">
						<button type="submit" class="btn-lg btn-primary pull-right">Add User</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn-lg btn-primary pull-right">Update</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>
	<br>
	<br>
	Go back to <a href="<c:url value='/users' />">List of All Employees</a>
</div>
</body>
</html>