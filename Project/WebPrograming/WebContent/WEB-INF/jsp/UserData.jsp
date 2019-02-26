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

<input type="hidden" name="id" value="${userData.loginId}">
ログインID　　　　　${userData.loginId}
<br><br>

ユーザー名　　　　　${userData.name}
<br><br>
生年月日　　　　　　${userData.birthDate}
<br><br>
登録日時　　　　　　${userData.createDate}
<br><br>
更新日時　　　　　　${userData.updateDate}
<br><br>
<a href="UserListServlet">戻る</a>


</body>
</html>