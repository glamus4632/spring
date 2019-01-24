<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/bootstrap.css">
</head>
<body>
여기는 글쓰기 페이지 입니다
<form action="<%= request.getContextPath() %>/bbs/modify" method="POST">
	<input type="hidden" value="${detail.id}" name="id">
	<div class="form-group">
		<label for="title">제목:</label>
		<input type="text" class="form-control" id="title" name="title" value="${ detail.title }">
	</div>
	<div class="form-group">
		<label for="title">작성자:</label>
		<input type="text" class="form-control" id="writer" name="writer" readonly="readonly" value="${ detail.writer }">
	</div>
	<div class="form-group">
		<label for="content">내용:</label>
		<textarea class="form-control" id="content" name="content">${ detail.content }</textarea>
	</div>
	
	<button class="btn btn-outline-primary">수정</button>
</form>
	
</body>
</html>