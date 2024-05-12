<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error</title>
<script>
    onload = function() {
        const confirmed = confirm("예약에 실패했습니다.");
        if (confirmed) {
            location.href = "/car";
        }
    };
</script>
</head>
<body>
</body>
</html>
