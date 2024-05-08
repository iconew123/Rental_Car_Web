<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/style/style.css">
</head>
<jsp:include page="/header"></jsp:include>
<script src="/resources/script/validation-join.js"></script>
<body>
	<section id="root">
		<h2>회원가입</h2>
		<form method="POST" action="/joinFormAction">
			<div>
				<input type="text" id="id" name="id" placeholder="아이디">
				<input type="password" id="password" name="password" placeholder="비밀번호">
				<input type="text" id="email" name="email" placeholder="[선택] 이메일주소 (비밀번호 찾기 등 본인 확인용)">
			</div>
			<div class="error-container">
				<p class="error-msg" id="error-msg-id">* 아이디: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-password">* 비밀번호: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-email">* 이메일: 이메일 주소가 정확한지 확인해 주세요.</p>
			</div>
			<div>
				<input type="text" id="name" name="name" placeholder="이름">
				<input type="text" id="birth1" name="birth1" placeholder="생년월일 8자리">
				<input type="password" id="birth2" name="birth2" placeholder="주민번호 뒷자리">				
				<select id="telecom" name="telecom">
					<option selected disabled>통신사 선택</option>	
					<option value="SKT">SKT</option>
					<option value="KT">KT</option>
					<option value="LGU+">LGU+</option>
				</select>
				<input type="text" id="phone" name="phone" placeholder="휴대전화번호">
			</div>
			<div class="error-container">
				<p class="error-msg" id="error-msg-name">* 이름: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-birth1">* 생년월일: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-birth2">* 주민 뒷자리: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-telecom">* 통신사: 이용하는 통신사를 선택해 주세요.</p>
				<p class="error-msg" id="error-msg-phone">* 휴대전화번호: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-phone-pattern">* 휴대전화번호: 휴대전화번호가 정확한지 확인해 주세요.</p>
			</div>
			<input type="submit" value="회원가입">
		</form>
	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>