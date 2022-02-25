<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link rel="stylesheet" href="../resources/css/list.css">
<link rel="stylesheet" href="../resources/css/table.css">
</head>
<body>
	
	<c:import url="../template/header.jsp"></c:import>
	
	<div class="table-container">	
		<h1 class="title">List Page</h1>
		
		<div>
			<fieldset>
				<form action="./list" method="get">
					<select name="kind">
						<option value="col1">제목</option>
						<option value="col2">내용</option>
						<option value="col3">작성자</option>
					</select>
					<input type="text" name="search" value="${pager.search}">
					<button type="submit">검색</button>
				</form>
			</fieldset>
		</div>
		<table class="table-basic">
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
		
		<div>
			<c:if test="${pager.pre}">
				<a href="./list?page${pager.startNum-1}">PREVIEW</a>
			</c:if>
			
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			<a href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
			</c:forEach>
			
			<c:if test="${pager.next}">
				<a href="./list?page=${pager.lastNum+1}">NEXT</a>
			</c:if>
		</div>
		
		<a href="./add">ADD</a>
	</div>

</body>
</html>