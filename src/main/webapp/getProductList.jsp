<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import = "java.util.*" %>
<%@ page import = "product.ProductDTO" %>

<%
 List<ProductDTO> productList = new ArrayList<>();
 try
 {
	productList = (List<ProductDTO>) session.getAttribute("productList");
 
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 페이지 리스트</title>
</head>
<body>

<h1>list</h1>
<table border = "1" width = "700px">
<tr>
<th bgcolor="orange" width = "100px">번호</th>
<th bgcolor="orange" width = "100px">상품 이름</th>
<th bgcolor="orange" width = "100px">가격</th>
<th bgcolor="orange" width = "100px">상품 설명</th>
<th bgcolor="orange" width = "100px">등록일</th>
</tr>
<% for(ProductDTO k : productList) { %>

<tr>
<td align = "center"><%=k.getId() %>></td>
<td><a href = "getProduct.pr?id=<%=k.getId()%>"><%= k.getName() %></a></td>
<td><%=k.getPrice() %></td>
<td><%=k.getContent() %></td>
<td><%=k.getRegdate() %></td>
</tr>
<%
}
session.removeAttribute("productList");
}

catch(Exception e)
{
	response.sendRedirect("getProductList.pr");
}
%>
</table>

<br> <a href="http://localhost:8181/JSP_MY_PROJJ">홈으로</a>
<p /> <a href= "insertProduct.jsp"> 상품 추가</a>
<p /> <a href= "deleteProduct.jsp"> 상품 삭제</a>



</body>
</html>