<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="/Hr_dpt_app/styles/style.css">
<title>社員名簿</title>
</head>
<body>
	<p class="title">社員名簿</p>
	<div class="list_box">
		<%
		String rank = String.valueOf(session.getAttribute("user_rank"));
		int user_rank = Integer.parseInt(rank);
		String id = String.valueOf(session.getAttribute("user_id"));
		int user_id = Integer.parseInt(id);
		if (session.getAttribute("user_name") != null) {
		%>
		<p>
			Welcome
			<%=session.getAttribute("user_name")%>
			!
			<%=user_id%>
		</p>
		<%
		}
		%>

		<%
		if (user_rank <= 5) {
		%>
		<table class="meibo">
			<tr>
				<th>番号</th>
				<th>名前</th>
				<th>役職</th>
				<th>部署</th>
				<th>編集</th>
			</tr>
			<%
			ArrayList<HashMap<String, String>> rows = (ArrayList<HashMap<String, String>>) request.getAttribute("rows");
			int i = 0;
			%>
			<%
			for (HashMap<String, String> columns : rows) {
				i = i + 1;
			%>
			<tr>
				<td><%=i%></td>
				<td><%=columns.get("name")%></td>
				<td><%=columns.get("department")%></td>
				<td><%=columns.get("position")%></td>
				<td class="edit_btn_box">
					<form action="move" method="post" class="edit_btn">
						<input type="hidden" name="id" value="<%=columns.get("id")%>">
						<input type="hidden" name="dpt_id"
							value="<%=columns.get("dpt_id")%>"> <input type="hidden"
							name="position_id" value="<%=columns.get("position_id")%>">
						<input type="hidden" name="name" value="<%=columns.get("name")%>">
						<input type="hidden" name="goal" value="edit"> <input
							type="submit" value="編集">
					</form>
				</td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		} else {
		%>
		<table class="meibo">
			<tr>
				<th>番号</th>
				<th>名前</th>
				<th>役職</th>
				<th>部署</th>
				<th>編集</th>
			</tr>
			<%
			ArrayList<HashMap<String, String>> rows = (ArrayList<HashMap<String, String>>) request.getAttribute("rows");
			int i = 1;
			%>
			<%
			for (HashMap<String, String> columns : rows) {
			%>
			<%
			int	id_from_column=Integer.parseInt(columns.get("id"));
			if (user_id == id_from_column) {
			%>
			<tr>
				<td><%=i%></td>
				<td><%=columns.get("name")%></td>
				<td><%=columns.get("department")%></td>
				<td><%=columns.get("position")%></td>
				<td class="edit_btn_box">
					<form action="move" method="post" class="edit_btn">
						<input type="hidden" name="id" value="<%=columns.get("id")%>">
						<input type="hidden" name="dpt_id"
							value="<%=columns.get("dpt_id")%>"> <input type="hidden"
							name="position_id" value="<%=columns.get("position_id")%>">
						<input type="hidden" name="name" value="<%=columns.get("name")%>">
						<input type="hidden" name="goal" value="edit"> <input
							type="submit" value="編集">
					</form>
				</td>
			</tr>
			<%
			}
			%>
			<%
			}
			%>
		</table>

		<%
		}
		%>
	</div>



	<div class="btn_box">
		<% if(user_rank<=5) {%>
		<div class="each_btn_box">
			<form action="move" method="POST">
				<input type="hidden" name="goal" value="create"> <input
					type="submit" value="名簿追加" class="red_btn">
			</form>
		</div>
		<% } %>
		<div class="each_btn_box">
			<form action="logout" method="POST">
				<input type="submit" value="ログアウト" class="blue_btn">
			</form>
		</div>
	</div>
</body>
</html>