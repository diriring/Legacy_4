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
	
	<h1>List Page</h1>
	
	<table>
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
	
	<a href="./add">ADD</a>

</body>
</html>