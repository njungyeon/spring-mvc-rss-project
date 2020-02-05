<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home</title>
</head>
<body>
<h1>
	welcome to my spring mvc project
</h1>



<!--이건 왜 안되는지 궁금하다
<a href="/myapp/resources/html/memJoin.html">Go to Join</a>
<c:if test="${empty member}">	
	<a href="${cp}/member/joinForm">JOIN</a> &nbsp;&nbsp; 
</c:if>
-->
<a href="/myapp/member/joinForm">JOIN</a> &nbsp;&nbsp;
<a href="/myapp/member/loginForm">LOGIN</a> &nbsp;&nbsp; 
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
