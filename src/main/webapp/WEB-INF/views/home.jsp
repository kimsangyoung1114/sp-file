<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<title>Home</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</head>
<body>
<h1>
	Hello world!
</h1>

<P>  The time on the server is ${serverTime}. </P>
	회원이름 : <input type="text" name="custname" id="custname"><br>
	회원전화 : <input type="text" name="phone" id="phone"><br>
	회원주소 : <input type="text" name="address" id="address"><br>
	가입일자 : <input type="text" name="joindate" id="joindate"><br>
	회원등급 :<input type="text" name="grade" id="grade"><br>
	거주도시 : <input type="text" name="city" id="city"><br>
	파일 :<input type="file" name="file1" id="file1"><br>
	<button onclick="upload()">전송</button>
	테스트 중입니다.
<script>
function upload(){
	var data = new FormData();
	if($('#file1')[0].files[0]){
		data.append('file1', $('#file1')[0].files[0]);
	}
	data.append('custname', $('#custname').val());
	data.append('phone', $('#phone').val());
	data.append('address', $('#address').val());
	data.append('joindate', $('#joindate').val());
	data.append('grade', $('#grade').val());
	data.append('city', $('#city').val());
	$.ajax({
		url:'/upload',
		enctype:'multipart/form-data',
		data:data,
		method:'POST',
		processData : false,
		contentType : false,
		success:function(res){
			if(res === 1){
				alert('회원가입 성공');
			}else {
				alert('회원가입 실패');
			}
		},
		error:function(err){
			
		}
	})
}
</script>
</body>
</html>
