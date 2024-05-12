<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<div class="reservation-form">
		<div class="info-form">
			<img src="${carInfo.img }">
			<h2>${carInfo.carName }</h2>
			<p>brand: ${carInfo.brand }&nbsp; |&nbsp; ${carInfo.type }&nbsp;|&nbsp; ${carInfo.model }형</p>
			<p>carNum : ${carInfo.carNum }</p>
			<p>Seater: ${carInfo.seater }</p>
			<p>Score: ${carInfo.score } / 5</p>
			<p>Price: ${carInfo.price }원 (일당)</p>
			<c:choose>
				<c:when test="${empty totalResDate}">
					<p>예약된 정보가 없습니다.</p>
				</c:when>
				<c:when test="${not empty totalResDate }">
					<p>해당 차량의 예약정보 : &nbsp;${totalResDate.startDate } ~ ${totalResDate.endDate }&nbsp;예약중</p>
				</c:when>
			</c:choose>
		</div>
		<form method="POST" action="/CreateResAction">
			<div id="date-form">
				<input type="hidden" id="userid" name="userid" value="${user.id }">
				<input type="hidden" id="carCode" name="carCode"  value="${carInfo.code}">
				<input type="hidden" id="h-startDate" value="${totalResDate.startDate }">
				<input type="hidden" id="h-endDate" value="${totalResDate.endDate }">				
				<label for="startDate">시작 날짜:</label> 
				<input type="date" id="startDate" name="startDate">
				<label for="endDate">종료 날짜:</label> 
				<input type="date" id="endDate" name="endDate">
			</div>
			<div id="result-wrapper">
				<p class="correct">선택한 기간:</p>
				<p id="result" class="correct"></p>
				<p class="incorrect" style="display: none;">해당 날짜는 이미 예약되어있습니다.</p>
			</div>
			<button class="btn">예약하기</button>
		</form>
	</div>
	<script src="k.js"></script>
</body>
<jsp:include page="/footer"></jsp:include>
</html>