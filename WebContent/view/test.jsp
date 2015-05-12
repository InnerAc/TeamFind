<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.challenge.teamfind.util.DBCon"	%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="mydb" class="com.challenge.teamfind.util.DBCon" scope="session" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hello World!!
	<%
		String id = request.getParameter("id");
		String item = request.getParameter("item");
		String value = request.getParameter("value");
		ResultSet rs;
		String sql = "insert into test values('"+id+"','"+item+"','"+value+"')";
		out.print(sql);
		try{
			mydb.excuteUpdate(sql);	
		}catch(Exception e){
			out.print(e);
		}
	%>
	<table border=1 style="font-size:30px;">
		<tr>
			<td>ID</td>
			<td>item</td>
			<td>value</td>
		</tr>
	<%
			//ResultSet rs;
			try{
				rs = mydb.excuteQuery("select * from test");
				while(rs.next()){
					out.print("<tr>");
					out.print("<td>"+rs.getString(1)+"</td>");
					out.print("<td>"+rs.getString(2)+"</td>");
					out.print("<td>"+rs.getString(3)+"</td>");
					out.print("</tr>");
				}
				out.print("</table>");
				mydb.close();
			}catch(Exception e){
				out.print(e);
			}
		%>
</body>
</html>