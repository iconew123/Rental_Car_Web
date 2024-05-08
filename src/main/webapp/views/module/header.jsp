<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript"></script>
<link rel="stylesheet" href="/resources/style/style.css">
<title>Rental Car</title>
</head>
<body>
	<header>
		<nav id="nav2">
			<a href="/home">logo</a>
			<ul>
				<li><a href="#">렌트카</a></li>
				<li><a href="#">게시판</a></li>
				<c:choose>
					<c:when test="${user == null }">
						<li><a href="/loginForm">로그인</a></li>
					</c:when>
					<c:when test="${user != null }">
						<li><a href="/logoutFormAction">로그아웃</a></li>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${user == null }">
						<li><a href="/joinForm">회원가입</a></li>
					</c:when>
					<c:when test="${user != null }">
						<li><a href="/myPage">마이페이지</a></li>
						<li>${user.name}님로그인중</li>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${user.is_admin == true }">
						<li>어드민</li>
					</c:when>
					<c:when test="${user.is_admin == false  }">
						<li>일반회원</li>
					</c:when>
				</c:choose>
			</ul>
		</nav>
	</header>
</body>
</html>