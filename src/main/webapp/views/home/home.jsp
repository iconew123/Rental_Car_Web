<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rental Car Web</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<div class="car-list">
		<c:forEach var="car" items="${randomCarList }">
			<div class="car-item">
				<a href="/CarInfoByCarNum?code=${car.code}&user=${user.id}"> 
					<img src="${car.img}">
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