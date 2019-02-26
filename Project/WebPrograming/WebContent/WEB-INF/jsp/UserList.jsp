<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>UserList</title>
</head>
<body>
${userInfo.name} さん　　<a href="LogoutServlet">ログアウト</a>
<br>
<h1 class="center">ユーザー覧</h1>

<br><br>
<a href="SignUpServlet">新規登録</a>
<br><br>

<form method="post" action="UserListServlet">

ログインID　　　<input type="text" name="loginId">

<br><br>

ユーザー名　　　<input type="text" name="name">

<br><br>
生年月日　　　　<input type="date" name="example">　～
<input type="date" name="example">

<br><br>
<input type="submit" value="　検索　">
<br><br>


</form>

<table border="1">
<tr>
<th>　ログインID　</th>
<th>　ユーザー名　</th>
<th>　生年月日　</th>
<th>　　　　　　　　　</th>
</tr>

<c:forEach var="user" items="${userList}">

<tr>
<td>${user.loginId}</td>
<td>${user.name}</td>
<td>${user.birthDate}</td>
<td>


<input type="button" name="submit1" value="　詳細　" onclick="location.href='UserDataServlet?id=${user.loginId}'">
<input type="button" name="submit2" value="　更新　" onclick="location.href='updateServlet?id=${user.loginId}'">
<input type="submit" name="submit3" value="　削除　" onclick="location.href='UserDeleteServlet?id=${user.loginId}'">
</td>
</tr>

</c:forEach>


<tr>

</table>

</body>
</html>