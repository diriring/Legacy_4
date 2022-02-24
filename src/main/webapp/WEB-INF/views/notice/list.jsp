<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link rel="stylesheet" href="/s1/resources/css/table.css">
</head>
<body>
	
	<c:import url="../template/header.jsp"></c:import>
	
	<h1 class="title">List Page</h1>
	
	<div class="main">	
	<table class="notice_list">
		<tr>
			<th>제목</th><th>작성자</th><th>작성날짜</th><th>조회수</th>
		</tr>
		<c:forEach items="${list}" var="notice">
			<tr>
				<td><a href="./detail?noticeNum=${notice.noticeNum}">${notice.title}</a></td>
				<td>${notice.writer}</td>
				<td>${notice.regDate}</td>
				<td>${notice.hit}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a class="box" href="./add">ADD</a>
	</div>

</body>
</html>