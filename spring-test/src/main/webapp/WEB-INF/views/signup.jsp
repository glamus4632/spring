<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<div class="container">

</div>
<form action="<%= request.getContextPath() %>/signup" method="post">
ID: <input type="text" name="id"><br>
PW: <input type="password" name="pw"><br>
E-mail: <input type="email" name="email"><br>
Gender: <input type="radio" id="male" value="male" name="gender" checked>
		<label for="male">남성</label>
		<input type="radio" id="female" value="female" name="gender">
		<label for="female">여성</label><br>
<button type="submit">가입</button>

<script type="text/javascript">
	var signup = ${signup};
	if(signup == true) alert("아이디가 중복되어 회원가입에 실패했습니다.");
</script>
</form>
</body>
</html>