<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/bootstrap.css">
<title>success</title>
</head>
<body>
${user.id}님 환영합니다<!-- 세션에 저장하면 getAttribute 없이 사용 가능하다 --><br>
<table class="table table-dark table-hover">
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
	</tr>
	<c:forEach items="${list}" var="board">
		<tr>
			<td>${ board.id }</td>
			<td><a href="<%= request.getContextPath() %>/bbs/read"">${ board.title }</a></td>
			<td>${ board.writer }</td>
			<td>${ board.registerd_date }</td>
		</tr>
	</c:forEach>
</table>
<a href="<%= request.getContextPath() %>/bbs/register">글쓰기</a><br>

</body>
</html>