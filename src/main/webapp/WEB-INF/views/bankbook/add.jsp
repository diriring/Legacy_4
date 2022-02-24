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

	<h1 class="title">Add Page</h1>
	
	<div class="main">	
		<form action="./add" method="POST">
			<table>
				<tr>
					<td>BookName</td>
					<td colspan="3">
					<input type="text" name="bookName" placeholder="통장 이름">
					</td>
				</tr>
				<tr>
					<td>BookRate</td>
					<td>
					<input type="text" name="bookRate" placeholder="이자율">
					</td>
					<td>판매여부</td>
					<td>
					판매<input type="radio" name="bookSale" value="1"> 판매중지<input type="radio" name="bookSale" value="0">
					</td>
				</tr>
				<tr>
					<td>BookContents</td>
					<td colspan="3">
					<textarea name="bookContents" rows="15" cols="140"></textarea>
					</td>
				</tr>
			</table>
			<button type="submit">INSERT</button>
		</form>
	</div>
	
</body>
</html>