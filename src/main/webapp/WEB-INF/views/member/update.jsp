<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Update Page</h1>
	<form action="./update" method="post">
		<input type="hidden" readonly="readonly" name="id" value="${dto.id}">
		<fieldset>
			<legend>이름</legend>
			<input type="text" name="name" value="${dto.name}">
		</fieldset>
			
		<fieldset>
			<legend>전화번호</legend>
			<input type="text" name="phone" value="${dto.phone}">
		</fieldset>
			
		<fieldset>
			<legend>Email</legend>
			<input type="text" name="email" value="${dto.email}">
		</fieldset>
			
		<fieldset>
			<button type="submit">UPDATE</button>
		</fieldset>
			</form>
</body>
</html>