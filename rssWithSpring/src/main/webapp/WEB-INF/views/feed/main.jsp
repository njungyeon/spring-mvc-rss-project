<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h2>hello ${nickname}</h2>
	
	<a href="${cp}/member/logout">logout</a>
	
	<a href="/myapp/feed/showForm">Add Rss URL</a>
	
	<a href="/myapp/feed/showFeed">Show my Rss list</a>
	
	<a href="/myapp/feed/">Main</a>
	
	
</body>
</html>