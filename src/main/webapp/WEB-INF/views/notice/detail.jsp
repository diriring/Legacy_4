<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link rel="stylesheet" href="/s1/resources/css/detail.css">
</head>
<body>

	<c:import url="../template/header.jsp"></c:import>

	<h1 class="title">Notice Detail Page</h1>
	<div class="main">
		<table class="table_detail">
			<tr class="head">
				<td class="table_title">${dto.title}</td>
				<td>${dto.hit}</td>
			</tr>
			<tr>
				<td>${dto.writer}</td>
				<td>${dto.regDate}</td>
			</tr>
			<tr class="head">
				<td colspan="2">${dto.contents}</td>
			</tr>
		</table>
	<br>
	<a class="box" href="./list">List</a>
	<a class="box" href="./update?noticeNum=${dto.noticeNum}">Update</a>
	
	</div>

</body>
</html>