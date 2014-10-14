<%@page import="sun.io.Converters"%>
<%@page import="meupacote.Livros"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trabalhando com DAO e Model 2</title>
</head>
<body>
<table border="1" cellspacing="2" cellpadding="0">
<tr>
	<th>ISBN - Atualizar</th>
	<th>Título</th>
	<th>Publicado</th>
	<th>Excluir livro</th>
</tr>
<%
	List<Livros> livrosList = (List<Livros>) request.getAttribute("livrosList");
	for (Iterator i = livrosList.iterator(); i.hasNext();)
	{
		Livros l = (Livros) i.next();
%>
<tr>
	<td>
		<a href="LivrariaServlet?cmd=atu&isbn=<%=l.getIsbn()%>"><%=l.getIsbn()%></a>
	</td>
	<td>
		<%=l.getTitulo()%>
	</td>
	<td>
		<%=l.getPublicacao()%>
	</td>
	<td>
		<a href="LivrariaServlet?cmd=exc&isbn=<%=l.getIsbn()%>">Excluir</a>
	</td>
</tr>
<%
	} // end for
%>
</table>
<br/>
<a href="formInserindoDados.html">Adicionar um novo livro</a>
<br/>
<a href="index.jsp">Página Principal</a>

</body>
</html>