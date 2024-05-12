<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error</title>
<script>
    onload = function() {
        const confirmed = confirm("마이페이지를 불러오기 실패");
        if (confirmed) {
            location.href = "/RandomCarList";
        }
    };
</script>
</head>
<body>
</body>
</html>
