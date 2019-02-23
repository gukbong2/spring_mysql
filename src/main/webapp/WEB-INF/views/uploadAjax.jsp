<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.fileDrop {
	width: 100%;
	height: 200px;
	border: 1px dotted blue;
}

small {
	margin-left: 3px;
	font-weight: bold;
	color: gray;
}
</style>

</head>
<body>

<h3>Ajax File Upload</h3>
	<div class='fileDrop'></div>

	<div class='uploadedList'></div>

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>

<script>
	$(".fileDrop").on("dragenter dragover", function(event) {
		event.preventDefault();
	});

	$(".fileDrop").on("drop", function(event){
		event.preventDefault();
		
		var files = event.originalEvent.dataTransfer.files;
		
		var file = files[0];

		console.log(file);
		
		var formData = new FormData();
		
		formData.append("file", file);
		
		$.ajax({
			
			url:"/uploadAjax",
			data : formData, 
			dataType : "text",
			processData : false,
			contentType : false,
			type : "post",
			success : function(data) {
				alert(data);
			}
		});
		/* 
		================ ajax로 파일 데이터를 전송하기 위해서는 processData, contentType 을 false로 지정해야함. ================ 
		
		* processData : 데이터를 일반적인 querty String으로 변환할 것인지를 결정. 기본값은 true.
		* 	다른형식으로 데이터를 보내기 위하여 자동 변환하고 싶지 않은 경우에는 false로 지정
		* 
		* contentType : multipart/form-data 방식으로 전송하기 위해 false로 지정
		*
		*/
		
		
	});
</script>
	
	
</body>
</html>