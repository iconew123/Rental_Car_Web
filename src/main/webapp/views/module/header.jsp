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
			<a href="#">logo</a>
			<ul>
				<li><a href="#">렌트카</a></li>
				<li><a href="#">게시판</a></li>
				<c:choose>
					<c:when test="${session.getAttribute('id') == null }">
						<li><a href="#">로그인</a></li>
					</c:when>
					<c:when test="${session.getAttribute('id') != null }">
						<li><a href="#">로그아웃</a></li>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${session.getAttribute('id') == null }">
						<li><a href="#">회원가입</a></li>
					</c:when>
					<c:when test="${session.getAttribute('id') != null }">
						<li><a href="#">마이페이지</a></li>
					</c:when>
				</c:choose>
			</ul>
		</nav>
	</header>
</body>
</html>