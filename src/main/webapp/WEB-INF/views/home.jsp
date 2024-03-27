<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"	href="/Hr_dpt_app/styles/style.css">
<title>ログイン</title>
</head>
<body>
	<p class="title">ログイン</p>
	<%
	if (request.getAttribute("Message") != null) {
	%>
	<div class="message">
		<%=request.getAttribute("Message")%>
	</div>
	<%
	}
	%>
	<div class="content_box">
		<div class="login_box">
			<form action="home" method="POST">
				<label for="login_id"> ログインID</label> <input type="text"
					name="login_id" id="login_id"> <br> <label
					for="login_pw"> パスワード</label> <input type="password"
					name="login_pw" id="login_pw"><br> <input
					type="submit" value="ログイン" class="blue_btn">
			</form>
		</div>
	</div>

</body>
</html>