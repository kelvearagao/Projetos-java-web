<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="livro" scope="session" class="meupacote.Livros"/>
<%
	String publicacao = livro.getPublicacao();
%>
<form action="LivrariaServlet?cmd=atualizar" method="post">
<table>
	<tr>
		<td>ISBN:</td>
		<td><input type="text" name="isbn" value="${livro.isbn}" readonly="readonly"/></td>
	</tr>
	<tr>
		<td>Título:</td>
		<td><input type="text" name="titulo" value="${livro.titulo}"/></td>
	</tr>
	<tr>
		<td>Edição:</td>
		<td><input type="text" name="edicao" value="${livro.edicao}"/></td>
	</tr>
	<tr>
		<td>Publicação:</td>
		<td><input type="text" name="publicacao" value="${livro.publicacao}"/></td>
	</tr>
	<tr>
		<td>Descrição:</td>
		<td><textarea rows="5" cols="31" name="descricao">${livro.descricao}</textarea></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Enviar" name="btCadastrar"/></td>
	</tr>
</table>	
</form>

</body>
</html>