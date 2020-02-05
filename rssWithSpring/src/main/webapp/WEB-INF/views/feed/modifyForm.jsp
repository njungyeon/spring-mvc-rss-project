<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>Feed modify</h1>
	
	<form:form action="${cp}/feed/urlModify" method="post" commandName="feedInfo">
		<form:hidden path="id" value="${feedInfo.id}"/>
		<table>
			<tr>
				<td>사이트 이름</td>
				<td><form:input path="siteTitle" value="${feedInfo.siteTitle}" /></td>
			</tr>
			<tr>
				<td>rss URL</td>
				<td><form:input path="rssAddress" value="${feedInfo.rssAddress}" /></td>
			</tr>
			<tr>
				<td>summary</td>
				<td><form:input path="desc" value="${feedInfo.desc}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정" ></td>
			</tr>
		</table>
	</form:form>
	
	<a href="${cp}/feed/showFeed">취소</a>
</body>
</html>