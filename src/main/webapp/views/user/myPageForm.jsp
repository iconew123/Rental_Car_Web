<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<section id="root">
		<h1>${user.name}님환영합니다!</h1>

		<button onclick="location.href='/updateUserForm'">회원정보 수정</button>
		<button onclick="location.href='/deleteForm'">회원 탈퇴</button>
	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>