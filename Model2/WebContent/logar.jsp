<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="Logar" method="post">
	Usuário:<input type="text" name="usuario"/><br/>
	Senha:<input type="password" name="senha"/><br/>
	<input type="submit" name="btLogar" value="Logar"/>
</form>
<%
	String msg = (String) request.getAttribute("msg");
	if (msg != null)
		out.println(msg);
	msg = null;
%>
</body>
</html>