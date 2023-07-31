<%@page import = "java.util.ArrayList" %>
<%@page import = "com.practise.model.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<%
ArrayList<Account> viewList=(ArrayList<Account>)request.getAttribute("list");%>
    <center>
<table>
<tr>
<td><h2><b>NAME</b></h2></td>
<td><h2><b>Password</b></h2></td>
<td><h2><b>Email</b></h2></td>
<td><h2><b>Contact</b></h2></td>
<td><h2><b>Room Name</b></h2></td>
</tr>
<%
for(Account acc : viewList){ %>   
<tr>
<td><h2><%out.print(acc.getUserName());%></h2>
<td><h2><%out.print(acc.getPassword());%></h2>
<td><h2><%out.print(acc.getEmail());%></h2>
<td><h2><%out.print(acc.getPhno());%></h2>
<td><h2><%out.print(acc.getRoom_Name());}%></h2>
</tr>
</table>
</center>
</body>
</html>