<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>User Data</title>
</head>
<body>
<br>
${userInfo.name} さん　　<a href="LogoutServlet">ログアウト</a>
<br><br>
<h1 class="center">ユーザー情報詳細参照</h1>
<br>
ログインID　　　　　kdfdsd
<br><br>

ユーザー名　　　　　大槻瑞貴
<br><br>
生年月日　　　　　　1993年11月06日
<br><br>
登録日時　　　　　　2019年02月05日 15:00
<br><br>
更新日時　　　　　　2019年02月05日 15:30
<br><br>
<a href="UserListServlet">戻る</a>


</body>
</html>