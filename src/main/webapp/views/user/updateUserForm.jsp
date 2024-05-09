<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/style/style.css">
</head>
<jsp:include page="/header"></jsp:include>
<script src="/resources/script/validation-join.js"></script>
<body>
	<section id="root">
		<h2>회원정보 수정</h2>
		<form method="POST" action="/updateFormAction">
			<div>
				<input type="text" id="id" name="id" value="${user.id }" readonly>
				<input type="password" id="password" name="password"
					placeholder="비밀번호"> <input type="password"
					id="new-password" name="new-password" placeholder="새 비밀번호">
				<input type="text" id="email" name="email" value="${user.mail }">
			</div>
			<div class="error-container">
				<p class="error-msg" id="error-msg-id">* 아이디: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-password">* 비밀번호: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-email">* 이메일: 이메일 주소가 정확한지
					확인해 주세요.</p>
			</div>
			<div>
				<input type="text" id="name" name="name" value="${user.name }">
				<select id="telecom" name="telecom">
					<option selected>통신사 선택</option>
					<option value="SKT" ${user.telecom eq 'SKT' ? 'selected' : ''}>SKT</option>
					<option value="KT" ${user.telecom eq 'KT' ? 'selected' : ''}>KT</option>
					<option value="LGU+" ${user.telecom eq 'LGU+' ? 'selected' : ''}>LGU+</option>
				</select> <input type="text" id="phone" name="phone" value="${user.phone }">
			</div>
			<div class="error-container">
				<p class="error-msg" id="error-msg-name">* 이름: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-telecom">* 통신사: 이용하는 통신사를 선택해
					주세요.</p>
				<p class="error-msg" id="error-msg-phone">* 휴대전화번호: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-phone-pattern">* 휴대전화번호:
					휴대전화번호가 정확한지 확인해 주세요.</p>
			</div>
			<input type="submit" value="회원정보 수정완료">
		</form>
	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>