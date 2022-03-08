<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
</head>
<body>

	<c:import url="../template/header.jsp"></c:import>

	<h1>${board} Update Page</h1>
	
	<form action="./update" method="post">
		<input type="hidden" readonly="readonly" name="num" value="${dto.num}">	
		Title<input type="text" name="title" value="${dto.title}">
		<input type="text" name="writer" value="${dto.writer}" disabled="disabled">
		Content<textarea name="contents" rows="10" cols="">${dto.contents}</textarea>
		<button type="submit">UPDATE</button>
	</form>

</body>
</html>