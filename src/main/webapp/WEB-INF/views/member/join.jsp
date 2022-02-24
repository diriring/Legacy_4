<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Join Page</h1>
	
	<div class=join_main>
		<form action="./join" method="post">
			<fieldset>
				<legend>ID</legend>
				<input type="text" name="id">
			</fieldset>
			
			<fieldset>
				<legend>Password</legend>
				<input type="password" name="pw">
			</fieldset>
			
			<fieldset>
				<legend>이름</legend>
				<input type="text" name="name">
			</fieldset>
			
			<fieldset>
				<legend>전화번호</legend>
				<input type="text" name="phone">
			</fieldset>
			
			<fieldset>
				<legend>Email</legend>
				<input type="text" name="email">
			</fieldset>
			
			<fieldset>
				<button type="submit">JOIN</button>
			</fieldset>
			</form>
	</div>
</body>
</html>