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

	<h1>${board} Add Page</h1>
		
	<form action="./add" method="POST">
		Title <input type="text" name="title">
		Writer <input type="text" name="writer">
		Contents <textarea name="contents" rows="10" cols=""></textarea>
		<button type="submit">ADD</button>
	</form>
</body>
</html>