<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/Hr_dpt_app/styles/style.css">
<title>名簿修正/削除</title>
</head>
<body>
    <p class="title">名簿修正/削除</p>
<% String id_str    	 = request.getAttribute("id").toString(); %> 
<% String name    	     = 	(String)request.getAttribute("name"); %> 
<% String dpt_id_str     = request.getAttribute("dpt_id").toString(); %> 
<% String position_id_str= request.getAttribute("position_id").toString(); %> 
<p> id : <%= id_str %> </p>

<form action="edit" method="POST">
<label for="name"> 名前 </label> <input type="text" name="name" id="name" value="<%= name %>" >
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
		<input type="hidden" name="id" value="<%= id_str %>">
		<input type="submit" value="変更" class="red_btn">
</form>
	       	<form action="list" method="POST">
    	   		<input type="submit" value="取り消し" class="blue_btn"> 
       		</form>
	       	<form action="delete" method="POST">
	       		<input type="hidden" name="id" value="<%= id_str %>">
	       		<input type="hidden" name="del_flag" value="1">
    	   		<input type="submit" value="削除" class="red_btn"> 
       		</form>

<script>
    var dpt_id_str = "<%= dpt_id_str %>"; // Java 코드에서 받은 값
    if (dpt_id_str !== null && dpt_id_str !== "") {
        document.getElementById("dpt_id").value = dpt_id_str;}
    var position_id_str = "<%= position_id_str %>"; // Java 코드에서 받은 값
    if (position_id_str !== null && position_id_str !== "") {
        document.getElementById("position_id").value = position_id_str;}
</script>
</body>
</html>