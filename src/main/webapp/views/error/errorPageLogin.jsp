<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error</title>
<script>
    onload = function() {
        const confirmed = confirm("로그인 후 이용해주세요!");
        if (confirmed) {
            location.href = "/car";
        }
    };
</script>
</head>
<body>
</body>
</html>
