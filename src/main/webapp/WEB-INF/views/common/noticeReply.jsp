<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${noticeReply}" var="dto">
	<tr>
		<td>${dto.contents}</td>
		<td>${dto.writer}</td>
		<c:if test="${member.id eq dto.writer}">
			<td>
				<button class="update" type="button" data-num="${dto.replyNum}">Update</button>
				<button class="del" type="button" data-num="${dto.replyNum}">Delete</button>
			</td>
		</c:if>
		
	</tr>
</c:forEach>
    
