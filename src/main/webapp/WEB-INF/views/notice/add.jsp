<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Notice Add Page</h1>
		
	<form action="./add" method="POST" id="frm">
		Title <input type="text" id="title" name="title">
		Writer <input type="text" id="writer" name="writer">
		Contents <textarea name="contents" rows="10" cols=""></textarea>
		<button type="button" id="btn">ADD</button>
	</form>
	<script src="../resources/js/noticeAdd.js"></script>
</body>
</html>