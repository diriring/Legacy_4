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

	<h1 class="title">BankBook List Page</h1>
	<div class="main">	
		<table>
			<tr>
				<th>상품명</th><th>이자율</th><th>판매</th>
			</tr>
			<c:forEach items="${list}" var="book">
				<tr>
					<td><a href="./detail?bookNumber=${book.bookNumber}">${book.bookName}</a></td>
					<td>${book.bookRate}</td>
					<td>${book.bookSale}</td>
				</tr>	
			</c:forEach>	
		</table>
		<br>
		<a class="box" href="./add">ADD</a>
	</div>
	
	

	
</body>
</html>