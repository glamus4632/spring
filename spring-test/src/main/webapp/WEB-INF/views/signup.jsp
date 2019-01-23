<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="//code.jquery.com/jquery-3.3.1.js"></script>
</head>
<body>
<div class="container">

</div>
<form action="<%= request.getContextPath() %>/signup" method="post">
ID: <input type="text" name="id" id="id">
	<button id="dup" type="button">중복 체크</button><br>
PW: <input type="password" name="pw"><br>
E-mail: <input type="email" name="email"><br>
Gender: <input type="radio" id="male" value="male" name="gender" checked>
		<label for="male">남성</label>
		<input type="radio" id="female" value="female" name="gender">
		<label for="female">여성</label><br>
<button type="submit">가입</button>

<script>
    var dup;
    $('#dup').click( function() {
        var id = "";
        id = $('#id').val();
        $.ajax({
        	async: true, //true면 동기 false면 비동기
        	type: 'POST',
        	data: id,//지금은 문자열 {id,pw}처럼 배열로 쓸 수도 있다
            url: 'http://localhost:8080/springtest/signup/dup',
            dataType: 'json',
            contentType:"application/json; charset=UTF-8",
            success: function(data) {
                if(data.dup){
                	alert("이미 사용중인 아이디입니다.");
                }else{
                	alert("사용가능한 아이디입니다.");
                }
            }
        });
    })
</script>
</form>
</body>
</html>