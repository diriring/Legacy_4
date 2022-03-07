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
	
	<form action="./list" method="get">
		<select name="kind">
			<option value="col1">제목</option>
			<option value="col2">내용</option>
			<option value="col3">작성자</option>
		</select>
		<input type="text" name="search" value="${pager.search}">
		<button type="submit">검색</button>
	</form>
	
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
	
	<div>
		<c:if test="${pager.pre}">
		<a href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">PREVIEW</a>
		</c:if>
		
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			<a href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
		</c:forEach>
		
		<c:if test="${pager.next}">
		<a href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">NEXT</a>
		</c:if>
	</div>
	
	<a href="./add">ADD</a>
</body>
</html>