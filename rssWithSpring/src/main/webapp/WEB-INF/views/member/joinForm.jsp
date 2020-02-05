<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${cp}/resources/css/normal.css" />
</head>
<body>
	<h1>MEMBER JOIN</h1>
	
	<form:form action="${cp}/member/join" method="post" commandName="member">
		<table>
			<tr>
				<td>ID</td>
				<td><form:input path="memId" /></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><form:password path="memPw" /></td>
			</tr>
			<tr>
				<td>MAIL</td>
				<td><form:input path="memMail" /></td>
			</tr>
			<tr>
				<td>NICKNAME</td>
				<td><form:input path="memNickname" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Join" >
				</td>
			</tr>
		</table>
	</form:form>
	
	<a href="${cp}/feed/">���</a>
</body>
</html>