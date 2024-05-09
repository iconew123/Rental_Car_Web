<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js" ></script>
<link rel="stylesheet" href="/resources/style/style.css">
<title>기간 계산</title>
<style>
/* 스타일 적용 */
</style>
</head>
<body>
	<h1>두 날짜 사이 기간 계산</h1>
	<div id="input-wrapper">
		<label for="startDate">시작 날짜:</label> <input type="date"
			id="startDate" name="startDate"> <label for="endDate">종료
			날짜:</label> <input type="date" id="endDate" name="endDate">

		<button id="calculate-button">기간 계산</button>
	</div>

	<div id="result-wrapper">
		<p>선택한 기간:</p>
		<p id="result"></p>
	</div>
	<script src="k.js"></script>
</body>
</html>
