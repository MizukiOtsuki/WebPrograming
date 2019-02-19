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
<form method="post" action="???">

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
<tr>
<td>jsdlsdj</td>
<td>山田太郎</td>
<td>1996年08月23日</td>
<td>
<input type="submit" name="submit1" value="　詳細　">
<input type="submit" name="submit2" value="　更新　">
<input type="submit" name="submit3" value="　削除　">
</td>
</tr>
<tr>
<td>kdfdsd</td>
<td>大槻瑞貴</td>
<td>1993年11月06日</td>
<td>


<input type="submit" name="submit1" value="　詳細　">
<input type="submit" name="submit2" value="　更新　">
<input type="submit" name="submit3" value="　削除　">
</td>
</tr>
<tr>
<td>kskslssss</td>
<td>佐藤はな子</td>
<td>1988年09月11日</td>
<td>
<input type="submit" name="submit1" value="　詳細　">
<input type="submit" name="submit2" value="　更新　">
<input type="submit" name="submit3" value="　削除　">
</td>
</tr>
</table>

</body>
</html>