<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>login</title>
</head>
<body>

<h1 class="center">ログイン画面</h1>

<br><br>

<c:if test="${errMsg != null}" >

		  ${errMsg}

	</c:if>


<form action="loginServlet" method="post">

ログインID　　　<input type="text" name="loginId">

<br><br>

パスワード　　　<input type="password" name="password">

<br><br><br>

<input type="submit" value="ログイン">


</form>

</body>
</html>