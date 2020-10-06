<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>Home</title>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
</head>
<body>
<h1>
	Hello world!  
</h1>
<P>  The time on the server is ${serverTime}. </P>

	<input type="file" name="file1" id="file1">
	소환사 이름 : <input type="text" name="writer" id="writer">
	<button onclick="upload2()">전송</button>
<div id="rDiv"></div>
<script>
function upload2(){
	
	$.ajax({
	url:'/riot/' + document.querySelector('#writer').valued
	success:function(res){
		$('#rDiv').html(JSON.stringify(res));
	},
	error:function(err){
		
	}
})
}
function upload(){
	var data = new FormData();
	data.append('file1',document.querySelector('#file1').files[0]);
	data.append('writer',document.querySelector('#writer').value);
	$.ajax({
		url:'/upload',
		enctype:'multipart/form-data',
		data:data,
		method:'post',
		processData: false,
		contentType: false,
		success:function(res){
			
		},
		error:function(err){
			
		}
	})
}
</script>
</body>
</html>



