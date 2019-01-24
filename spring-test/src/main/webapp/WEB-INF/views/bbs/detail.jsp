<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세</title>
<script src="//code.jquery.com/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/bootstrap.css">
</head>
<body>

<h1>게시글 상세</h1>
	<div class="form-group">
		<label for="id">글번호:</label>
		<input type="text" class="form-control" id="id" name="id" value="${detail.id}" readonly>
	</div>
	<div class="form-group">
		<label for="title">제목:</label>
		<input type="text" class="form-control" id="title" name="title" value="${detail.title}" readonly>
	</div>
	<div class="form-group">
		<label for="title">작성자:</label>
		<input type="text" class="form-control" id="writer" name="writer" readonly="readonly" value="${detail.writer}" readonly>
	</div>
	<div class="form-group">
		<label for="content">내용:</label>
		<textarea class="form-control" id="content" name="content" readonly>${detail.content}</textarea>
	</div>
	<a href="<%= request.getContextPath() %>/bbs/list">
		<button class="btn btn-outline-primary" ">목록</button>
	</a>
	<a href="<%= request.getContextPath() %>/bbs/list"
		style="<c:if test="${user != detail.writer}">display:none;</c:if>">
		<button class="btn btn-outline-primary" ">수정</button>
	</a>
<script>
function adjustHeight() {
  var textEle = $('textarea');
  textEle[0].style.height = 'auto';
  var textEleHeight = textEle.prop('scrollHeight');
  textEle.css('height', textEleHeight);
};

adjustHeight();
</script>
</body>
</html>