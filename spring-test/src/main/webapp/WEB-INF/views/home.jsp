<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> 세션정보 강제 false--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<title>Home</title>
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/bootstrap.css">
</head>
<body>
<h1>
	Login!  
</h1>

<form action="<%= request.getContextPath() %>/" method="POST"
  style="<c:if test="${user != null}">display:none;</c:if>">
	<input type="text" name="id" id="id"><br>
	<input type="password" name="pw" id="pw"><br>
	<button type="submit" class="btn btn-primary">log-in</button>
</form>
<a href="<%= request.getContextPath() %>/signup"
style="<c:if test="${user != null}">display:none;</c:if>">회원가입 페이지로 이동</a><br>

<script>
$(document).ready(function(){
	var login = ${login};//어트리뷰트로 온거랑 변수 이름이랑 다르게 하자!
	if(login == false){
		alert("회원정보가 일치하지 않습니다");
	}
});	
</script>
</body>
</html>
