<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link rel="stylesheet" href="../resources/css/table.css">
<link rel="stylesheet" href="../resources/css/list.css">
</head>
<body>
	
	<c:import url="../template/header.jsp"></c:import>
	
	<div class="table-container">
		<h1>${board} List Page</h1>
		
		<div>
			<!--Controller에 list method가 get방식이기 때문, 그리고 검색할때 넘어가는 param에 보안이 필요한 내요잉 없음-->
			<form action="./list" method="get">
				<fieldset>
					<select name="kind">
						<option value="col1">제목</option>
						<option value="col2">내용</option>
						<option value="col3">작성자</option>
					</select>
					<input type="text" name="search" value="${pager.search}">
					<button type="submit">검색</button>
				</fieldset>
			</form>
		</div>
		
		<table class="table-basic">
			<tr>
				<th>제목</th><th>작성자</th><th>작성날짜</th><th>조회수</th>
			</tr>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td><a href="./detail?num=${dto.num}">
						<c:catch>					
							<c:forEach begin="1" end="${dto.depth}">&nbsp;</c:forEach>
						</c:catch>
					${dto.title}</a></td>
					<td>${dto.writer}</td>
					<td>${dto.regDate}</td>
					<td>${dto.hit}</td>
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
		<c:if test="${not empty member}">
			<a href="./add">ADD</a>
		</c:if>
	</div>
</body>
</html>