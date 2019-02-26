<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>User Delete</title>
</head>
<body>
<br>
${userInfo.name} さん　　<a href="LogoutServlet">ログアウト</a>
<br><br>
<h1 class="center">ユーザー削除確認</h1>

<form action="UserDeleteServlet" method="post">

<input type="hidden" name="id" value="${userData.id}">

ログインID：${userData.loginId}
<br>
を本当に削除してよろしいでしょうか。
<br><br>
<input type="button" name="submit1" value="キャンセル"  onclick="location.href='UserListServlet'">
<input type="submit" name="submit2" value="　OK　">

</form>


</body>
</html>