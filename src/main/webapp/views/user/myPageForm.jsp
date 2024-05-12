<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 페이지</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<jsp:include page="/header"></jsp:include>
<body>
    <section id="root">
        <h1>${user.name}님 환영합니다!</h1>

        <button class="btn" onclick="location.href='/updateUserForm'">회원정보
            수정</button>
        <button class="btn" onclick="location.href='/deleteForm'">회원
            탈퇴</button>
        <c:forEach items="${myReserve}" var="reserve">
            <div class="reservation-item">
                <p class="car-name">예약한 차량 이름 : ${reserve.carName }</p>
                <p class="reservation-period">예약 기간: ${reserve.startDate} ~ ${reserve.endDate} | 총 ${reserve.use_date }일</p>
                <div class="btn-container"> <!-- 수정 및 삭제 버튼을 감싸는 div -->
                    <form method="POST" action="/UpdateCarInfoNum">
                        <input type="hidden" id="user" name="user" value="${user.id }">
                        <input type="hidden" id="code" name="code" value="${reserve.carCode }">
                        <input type="hidden" id="start" name="start" value="${reserve.startDate}">
                        <input type="hidden" id="end" name="end" value="${reserve.endDate }">
                        <button class="btn">수정</button>
                    </form>
                    <form method="POST" action="/DeleteRes">
                        <input type="hidden" id="user" name="user" value="${user.id }">
                        <input type="hidden" id="code" name="code" value="${reserve.carCode }">
                        <input type="hidden" id="start" name="start" value="${reserve.startDate}">
                        <input type="hidden" id="end" name="end" value="${reserve.endDate }">
                        <button class="btn">삭제</button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>