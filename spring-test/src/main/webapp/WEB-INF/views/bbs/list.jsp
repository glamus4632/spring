<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/bootstrap.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/list.css">
<title>success</title>
</head>
<body>
<table class="table table-dark table-hover">
	<tr>
		<td class="board-text">작성번호</td>
		<td class="board-text">제목</td>
		<td class="board-text">작성자</td>
		<td class="board-text">작성일</td>
	</tr>

	<c:forEach items="${list}" var="board">
		<c:if test="${board.state == 'I'}">
			<tr class="board-row">
				<td class="board-number">${ board.id }</td>
				<td class="board-title" style="width:400px">
					<a href="<%= request.getContextPath() %>/bbs/detail?id=${board.id}">${ board.title }</a>
				</td>
				<td class="board-writer">${ board.writer }</td>
				<td class="board-date">${ board.registerd_date }</td>
			</tr>
		</c:if>
	</c:forEach>
	
</table>

<a href="<%= request.getContextPath() %>/bbs/register">
	<button>글쓰기</button>
</a>
</body>
</html>