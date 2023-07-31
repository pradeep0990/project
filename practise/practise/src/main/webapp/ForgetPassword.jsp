<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/practise/ResetPassword" method="post">
<h1 align="center">Forgot Password</h1><br>
<h4 align="center">Email: <input type="text" name="email" placeholder="Enter your email"></input></h4>
<h6 align="center"><input type="submit" ></h6>
</form>
<h3 align="center">
<%String status=(String)request.getAttribute("status");
String email=(String)request.getAttribute("toEmail");
if(status!=null){
out.print(status +"to"+email);
}
%></h3>
</body>
</html>