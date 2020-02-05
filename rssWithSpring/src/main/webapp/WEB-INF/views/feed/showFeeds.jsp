<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>your feed lists</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<P>hello, ${nickname}. This is your feed lists.</P>

<form action="${cp}/feed/urlDelete" method="post" name="feedForm">
	<input type="hidden" id="rowIdx" name="rowIdx">
	<table>
        <thead>
            <tr>
                <td><b>Name</b></td>
                <td><b>Rss url</b></td>
                <td><b>Summary</b></td>
                <td></td>
                <td></td>
            </tr>
        </thead>
		
		<c:forEach var="tmp" items="${feedInfos}">
		  <tr>
		    <td>${tmp.siteTitle}</td>
		    <td>${tmp.rssAddress}</td>
		    <td>${tmp.desc}</td>
		    
		    <td>
			    <input id ='${tmp.id}' type = "submit" class="modify_click" onclick="func2()" value="수정">
			    <input id ='${tmp.id}' type = "submit" class='delete_click' onclick="func1()" value="삭제">
		    </td>
		 
		    <td><a href="${tmp.rssAddress}">사이트 GO</a></td>
		  </tr>
		</c:forEach>

    </table>
    </form>			
	
	    <script type="text/javascript">
    	
    	function func2(){
    		var Idx = event.path[2].rowIndex;
        	document.getElementById("rowIdx").value = Idx;
        	console.log(Idx);
        	document.feedForm.action = "${cp}/feed/modifyForm";	
    	}
    	
    	function func1(){
    		var rowIdx = event.path[1].children[1].id;
    		console.log(event.path[2].rowIndex);
    		//내일 ajax이용해서 request요청하는거 하고 이 프로젝트는 걍 끝내자!
    		//console.log(event.path[1].children[1].id);
    		//console.log(rowIdx);
    		document.getElementById("rowIdx").value = rowIdx;
    		console.log(document.getElementById("rowIdx").value);
    		
    	}
    	

    </script>
    
    <a href="/myapp/feed/">go to main page.</a>
</body>
</html>