<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Detail Page</h1>
	
	<h1>NAME : ${dto.bookName}</h1>
	<h1>CONTENTS : ${dto.bookContents}</h1>
	
	<a href="./list">List</a>
	<a href="./update">Update</a>
	<a href="./delete?bookNumber=${dto.bookNumber}">Delete</a>
	
</body>
</html>