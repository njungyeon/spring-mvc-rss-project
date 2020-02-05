<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>
<body>
	<h1>ADD feed</h1>
	
	<form:form action="${cp}/feed/addRssUrl" method="post" commandName="feedInfo">
		<table>
			<tr>
				<td>����Ʈ �̸�</td>
				<td><form:input path="siteTitle" type="text" /></td>
			</tr>
			<tr>
				<td>RSS �ּ�</td>
				<td><form:input path="rssAddress" /></td>
			</tr>
			<tr>
				<td>����Ʈ ����</td>
				<td><form:input path="desc" /></td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="�߰�" >
					<a href="${cp}/feed/" >���</a>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>