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
		
	<form action="./add" method="POST" id="frm" enctype="multipart/form-data">
		Title <input type="text" id="title" name="title">
		Writer <input type="text" id="writer" name="writer" value="${member.id}" readonly="readonly">
		Contents <textarea name="contents" rows="10" cols=""></textarea>
		
		<div>
			<input type="file" name="files">
			<input type="file" name="files">
			<input type="file" name="files">
		</div>
		<button type="button" id="btn">ADD</button>
	</form>
	<script src="../resources/js/noticeAdd.js"></script>
</body>
</html>