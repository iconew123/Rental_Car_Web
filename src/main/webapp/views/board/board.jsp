<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD</title>
</head>
<body>
	<jsp:include page="/header"></jsp:include>

	<section class="container">
		<h2 style="margin-top: 20px;">게시판</h2>
		<form method="GET" action="/FindBoardList">
			<section class="s">
				<!-- 여기에 검색 옵션 -->
				<select id="type" name="type">
					<option selected disabled>검색 옵션</option>
					<option value="공지글">공지글</option>
					<option value="리뷰글">리뷰글</option>
					<option value="자유글">자유글</option>
				</select>
				<button class="btn">검색</button>
			</section>
		</form>
		<c:forEach var="board" items="${boardList}">
			<section class="board-section">
				<div class="board-card">
					<div class="board-header">
						<h3>
							<span>글 번호 :</span> ${board.getBoard_num()}
						</h3>
						<h3>
							<span>글 제목 :</span> ${board.getTitle()}
						</h3>
						<h3>
							<span>글 작성자 :</span> ${board.getUser_id()}
						</h3>
					</div>
					<div class="board-info">
						<p>
							<span>글 타입:</span> ${board.getType()}
						</p>
						<p>
							<span>작성일:</span> ${board.getRecord()} | <span>수정일:</span>
							${board.getMod_time()}
						</p>
					</div>
				</div>
				<div class="board-item content-${board.getBoard_num()}">
					<div class="board-card">
						<p>
							<span>내용:</span> ${board.getContent()}
						</p>
					</div>
				</div>
				<button class="btn" onclick="toggleContent(this)">내용 읽기</button>
				<c:choose>
					<c:when test="${board.getUser_id() eq user.id }">
						<!-- 각각의 글 수정 -->
						<button class="btn writeBtn">수정</button>
						<div class="modalWrap" id="modalWrap-${board.getBoard_num()}">
							<div class="modalBody" id="modalBody-${board.getBoard_num()}">
								<span class="closeBtn" id="closeBtn-${board.getBoard_num()}">&times;</span>
								<p>글 작성하기</p>
								<form method="POST" action="/UpdateBoardAction">
									<input type="hidden" id="userId" name="userId"
										value="${user.id }"> <input type="hidden"
										id="boardNum" name="boardNum" value="${board.getBoard_num() }">
									<select id="wtype" name="wtype" onchange="showRating(this)">
										<option selected disabled>글 종류</option>
										<c:if test="${user.name eq 'ADMIN' }">
											<option value="공지글">공지글</option>
										</c:if>
										<option value="리뷰글">리뷰글</option>
										<option value="자유글">자유글</option>
									</select>
									<div class="ratingContainer" style="display: none;">
										<label for="rating">평점:</label> <select id="rating"
											name="rating">
											<option value="0">0</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
										</select>
									</div>
									<input type="text" id="title" name="title"
										value="${board.getTitle() }">
									<textarea rows="20" cols="40" style="resize: none;"
										id="content" name="content">${board.getContent()}</textarea>
									<button type="submit" class="btn">수정</button>
								</form>
							</div>
						</div>
						<form method="POST" action="/DeleteBoardAction">
							<input type="hidden" id="userId" name="userId"
								value="${user.id }"> <input type="hidden" id="boardNum"
								name="boardNum" value="${board.getBoard_num() }">
							<button type="submit" class="btn">삭제</button>
						</form>

					</c:when>
				</c:choose>
			</section>
		</c:forEach>
	</section>

	<c:if test="${user != null}">
		<div id="btnWrap">
			<button class="btn writeBtn">글쓰기</button>
		</div>

		<div class="modalWrap" id="modalWrap-new">
			<div class="modalBody" id="modalBody-new">
				<span class="closeBtn" id="closeBtn-new">&times;</span>
				<p>글 작성하기</p>
				<form method="POST" action="/CreateBoardAction">
					<input type="hidden" id="userId" name="userId" value="${user.id }">
					<select id="wtype" name="wtype" onchange="showRating(this)">
						<option selected disabled>글 종류</option>
						<c:if test="${user.name eq 'ADMIN' }">
							<option value="공지글">공지글</option>
						</c:if>
						<option value="리뷰글">리뷰글</option>
						<option value="자유글">자유글</option>
					</select>
					<div class="ratingContainer" style="display: none;">
						<label for="rating">평점</label> <select id="rating" name="rating">
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</div>
					<input type="text" id="title" name="title" placeholder="제목을 입력하세요">
					<textarea rows="20" cols="40" style="resize: none;" id="content"
						name="content" placeholder="내용을 입력하세요"></textarea>
					<button type="submit" class="btn">제출</button>
				</form>
			</div>
		</div>
	</c:if>
	<script src="/resources/script/validation-board.js"></script>
	<jsp:include page="/footer"></jsp:include>
</body>
</html>