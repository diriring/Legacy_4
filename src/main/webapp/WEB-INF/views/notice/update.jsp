<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Notice Update Page</h1>
	
	<form action="./update" method="POST">
		<input type="hidden" readonly="readonly" name="noticeNum" value="${dto.noticeNum}">
		Title <input type="text" name="title" value="${dto.title}">
		Contents <textarea name="contents" rows="10" cols="">${dto.contents}</textarea>
		<button type="submit">ADD</button>
	</form>

</body>
</html>