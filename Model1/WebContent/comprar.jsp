<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="carrinho" scope="session" class="meupacote.CarrinhoDeCompras"/>
<jsp:setProperty property="*" name="carrinho"/>

<%
	String[] livro = request.getParameterValues("livro");
	if (livro != null) {
		carrinho.process(livro);
	}
	String[] prods = carrinho.getProds();
	if (prods.length > 0){
%>

<table border="1">
	<tr>
		<th colspan="2">Carrinho de Compras</th>
	</tr>
	<%
	for (int i=0;i<prods.length;i++){
	%>
	<tr>
		<td><%=prods[i]%></td>
		<td><a href="?livro=<%=prods[i]%>&cmd=r">Excluir</a></td>
	</tr>
	<%
	}
	%>
	<tr>
		<td colspan="2"><a href="produtos.jsp">Comprar mais</a></td>
	</tr>
</table>
<%
	} else {
		out.println("<h2>Você não tem produtos no seu carrinho</h2>"
				+"<a href=\"produtos.jsp\">Comprar mais</a>");
	}
%>

</body>
</html>