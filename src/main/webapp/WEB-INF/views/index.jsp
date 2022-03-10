<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./template/header_css.jsp"></c:import>
</head>
<body>
	
	<c:import url="./template/header.jsp"></c:import>
	
	<div>
		<img alt="" src="./resources/images/cat-gf27433bcc_1920.jpg">
	</div>

	<h1>Index Page</h1>
	
	<h3>${member.name}님 환영합니다!
	<span class="material-icons-outlined">
	account_circle
	</span>	
	</h3>
	
	
	<div>
		<c:if test="${not empty member}">
		<a href="./member/mypage">MyPage</a>
		<a href="./member/logout">LogOut</a>		
		</c:if>
		
		<c:if test="${empty member}">
		<a href="./member/login">LogIn</a>
		<a href="./member/join">Join</a>		
		</c:if>
	</div>
	
	<img alt="" src="./resources/upload/member/9e446b6f-2452-48fd-a6bd-8a8cfb59e217_AMjTNO3t_400x400.jpg">
	
</body>
</html>