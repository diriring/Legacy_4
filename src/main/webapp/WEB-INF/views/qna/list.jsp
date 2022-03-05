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

	<h1>QNA List Page</h1>
	
	<table>
	
		<tr>
			<td>제목</td>
			<td>작성자</td>
			<td>작성 날짜</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${qna}" var="qna">
			
			<tr>
				<td><a href="./detail?num=${qna.num}">${qna.title}</a></td>
				<td>${qna.writer}</td>
				<td>${qna.regDate}</td>
				<td>${qna.hit}</td>
			</tr>
			
		</c:forEach>
	</table>
	
	<a href="./add">ADD</a>
</body>
</html>