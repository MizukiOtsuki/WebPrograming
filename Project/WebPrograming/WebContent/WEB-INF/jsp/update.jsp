<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Update</title>
</head>
<body>
<br>
${userInfo.name} さん　　<a href="LogoutServlet">ログアウト</a>
<br><br>
<h1 class="center">ユーザー情報更新</h1>

ログインID　　　　　　　　kdfdsd
<br><br>

パスワード　　　　　　　　<input type="password" name="pass">
<br><br>

パスワード(確認)　　　　　<input type="password" name="pass">
<br><br>

ユーザー名　　　　　　　　<input type="text" name="name">
<br><br>

生年月日　　　　　　　　　<input type="date" name="example">
<br><br>
<input type="submit" name="submit" value="　更新　">
<br><br>
<a href="UserListServlet">戻る</a>

</body>
</html>