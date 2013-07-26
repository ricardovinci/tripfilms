<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
		<title>Social web</title>
	</head>
	<body>
	<ul>
		<li>Logged as <c:out value="${email}"/></li>
		<li><a href="<c:url value="/signout" />">Sign Out</a></li>
	</ul>
	
	<div align="center">
		
		<a href="<c:url value="/preferences-page" />"><h3>Preferences</h3></a>
		
	</div>
	<div align="center">
		
		<a href="<c:url value="/video-page" />"><h3>Video Upload</h3></a>
		
	</div>
	
	
	<!--  <h3>Your Facebook Friends</h3>
	<ul>
	<c:forEach items="${friends}" var="friend">
		<li><img src="http://graph.facebook.com/<c:out value="${friend.id}"/>/picture" align="middle"/><c:out value="${friend.name}"/></li>
	</c:forEach>
	</ul>-->	
	</body>
</html>