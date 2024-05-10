<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="car-info">
		<h2>${carInfo.carName }</h2>
		<p>Price: ${carInfo.price }원 (일당)</p>
		<p>Brand: ${carInfo.brand }</p>
		<p>Type: ${carInfo.type }</p>
		<p>Seater: ${carInfo.seater }</p>
		<p>Score: ${carInfo.score } / 5</p>
	</div>
</body>
</html>