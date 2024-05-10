<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car Board</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<form method="POST" action="/FindCarList">
		<div id="d">
			<select id="type" name="type">
				<option selected value="%" readonly>TYPE 검색 옵션</option>
				<option value="SUV">SUV</option>
				<option value="밴">밴</option>
				<option value="세단">세단</option>
				<option value="쿠페">쿠페</option>
			</select> 
			<select id="brand" name="brand">
				<option selected value="%" readonly>BRAND 검색 옵션</option>
				<option value="기아">기아</option>
				<option value="르노삼성">르노삼성</option>
				<option value="삼성">삼성</option>
				<option value="쉐보레">쉐보레</option>
				<option value="쌍용">쌍용</option>
				<option value="현대">현대</option>
			</select> 
			<select id="price" name="price">
				<option selected value="%" readonly>PRICE 검색 옵션</option>
				<option value="2%">2만원대 (일)</option>
				<option value="3%">3만원대 (일)</option>
				<option value="4%">4만원대 (일)</option>
				<option value="5%">5만원대 (일)</option>
			</select>
			<button class="btn">검색</button>
		</div>
	</form>


	<div class="car-list">
		<c:if test="${car.size() == 0 }">
			<h1> 조회된 차량이 없습니다. </h1>
		</c:if>
		<c:forEach var="car" items="${car}">
			<div class="car-item">
				<a href="/CarInfoByCarNum?code=${car.code}&user=${user.id}"> <img
					src="${car.img}">
				</a>
				<div class="car-info">
					<h2>${car.carName }</h2>
					<p>Price: ${car.price }원 (일당)</p>
					<p>Brand: ${car.brand }</p>
					<p>Type: ${car.type }</p>
					<p>Seater: ${car.seater }</p>
					<p>Score: ${car.score } / 5</p>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
<jsp:include page="/footer"></jsp:include>
</html>