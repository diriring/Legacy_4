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
	
	<h1 class="title">Detail Page</h1>
	
	<div class="main">
		<table>
			<tr>
				<td class="table_title">${dto.bookName}</td>
				<td>이자율</td>
				<td>${dto.bookRate}</td>
			</tr>
			<tr>
				<td colspan="3">${dto.bookContents}</td>
			</tr>
		</table>	
		<br>
		<a class="box" href="./list">List</a>
		<a class="box" href="./update?bookNumber=${dto.bookNumber}">Update</a>
		<a class="box" href="./delete?bookNumber=${dto.bookNumber}">Delete</a>
	</div>
</body>
</html>