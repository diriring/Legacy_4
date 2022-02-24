<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link rel="stylesheet" href="/s1/resources/css/form.css">
</head>
<body>

	<c:import url="../template/header.jsp"></c:import>

	<h1 class="title">Notice Add Page</h1>
	
	<div class="main">	
		<form action="./add" method="POST">
			<table>
				<tr>
					<td>Title</td>
					<td><input type="text" name="title"></td>
					<td>Writer</td>
					<td><input type="text" name="writer"></td>
				</tr>
				<tr>
					<td>Contents</td>
					<td colspan="3"><textarea name="contents" rows="20" cols="170"></textarea></td>
				</tr>
			</table>
			<button type="submit">ADD</button>
		</form>
	</div>	
</body>
</html>