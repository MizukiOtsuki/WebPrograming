<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Sign Up</title>
</head>
<body>
<br>
${userInfo.name} さん　　<a href="LogoutServlet">ログアウト</a>

<br><br>
<h1 class="center">ユーザー新規登録</h1>

<form action="SignUpServlet" method="post">

ログインID　　　　　　<input type="text" name="loginId">
<br><br>

パスワード　　　　　　<input type="password" name="password">
<br><br>

パスワード(確認)　　　<input type="password" name="password2">
<br><br>

ユーザー名　　　　　　<input type="text" name="name">
<br><br>

生年月日　　　　　　　<input type="date" name="birthDate">
<br><br>

<input type="submit" name="submit1" value="　登録　">

</form>
<br>

<c:if test="${errMsg != null}" >

		  ${errMsg}

	</c:if>

<br><br>
<a href="UserListServlet">戻る</a>
</body>
</html>