<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home Page</title>
	<link href="<c:url value='/resources/CSS/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/resources/CSS/app.css' />" rel="stylesheet"></link>
</head>
<body>
<div class="form-container">
	 <h1>Welcome to FileDownloader Example</h1>
	    Click on below links to see FileDownload in action.<br/><br/>
	    
	    <a href="<c:url value='/download/internal'/>"> Click Here to Download Internal File</a><br>
	    <a href="<c:url value='/download/external'/>"> Click Here to Download External File </a>
</div>
</body>
</html>
