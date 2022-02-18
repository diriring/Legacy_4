<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Page</h1>
	
	<form action="./add" method="POST">
		BookName<input type="text" name="bookName" placeholder="통장 이름">
		BookRate<input type="text" name="bookRate" placeholder="이자율">
		BookContents<textarea name="bookContents" rows="10" cols=""></textarea>
		BookSale
		<div>
			판매<input type="radio" name="bookSale" value="1"> 판매중지<input type="radio" name="bookSale" value="0">
		</div>
		<button type="submit">INSERT</button>
	</form>
	
</body>
</html>