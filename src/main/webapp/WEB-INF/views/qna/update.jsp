<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>QNA Update Page</h1>
	<form action="./update" method="post">
		<input type="hidden" readonly="readonly" name="num" value="${dto.num}">	
		Title<input type="text" name="title" value="${dto.title}">
		Content<textarea name="contents" rows="10" cols="">${dto.contents}</textarea>
		<button type="submit">UPDATE</button>
	</form>

</body>
</html>