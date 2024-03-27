<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/Hr_dpt_app/styles/style.css">
<title>名簿追加</title>
</head>
<body>
<form action="create" method="POST">
	<label for="name"> 名前 </label> <input type="text" id="name" name="name"> <br>
	<label for="dpt_id"> 部署 </label> 
		<select name="dpt_id" id="dpt_id">
			<option value="1">人事部</option>
			<option value="2">総務部</option>
			<option value="3">法務部</option>
			<option value="4">経営企画部</option>
			<option value="5">事業部</option>
			<option value="6">IT部</option>
			<option value="7">資本設計部</option>
			<option value="8">マーケティング部</option>
			<option value="9">情報・セキュリティ部</option>
			<option value="10">その他</option>
		</select> <br>
	<label for="position_id"> 役職 </label> 
		<select name="position_id" id="position_id">
			<option value="1">社長</option>
			<option value="2">副社長</option>
			<option value="3">部長</option>
			<option value="4">課長</option>
			<option value="5">係長</option>
			<option value="6">平社員</option>
			<option value="7">アシスタント</option>
			<option value="8">インターン</option>
		</select><br> 
	<label for="login_id"> ログインID:</label> <input type="text" id="login_id" name="login_id"> <br>
	<label for="login_pw"> ログインPW:</label> <input type="password" id="login_pw" name="login_pw"> <br>
			<input type="submit" value="登録" class="red_btn">
</form>
	       	<form action="list" method="POST">
    	   		<input type="submit" value="取り消し" class="blue_btn"> 
       		</form>

</body>
</html>