<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "product.ProductDTO" %>

<%
ProductDTO product = new ProductDTO();
product = (ProductDTO) session.getAttribute("product");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>
</head>
<body>

<h1>상품 수정하기</h1>
<hr><br><br>
<form method = "post" action = "updateProduct.pr">
<input type = "hidden" name = "id" value = "<%= product.getId() %>">
<table border="1" width = "700px" cellpadding="5px" >

<tr>
 <td bgcolor="orange" align="center">상품 이름</td>
 <td><input type="text" name="title" value="<%= product.getName() %>"></td>
</tr>

<tr>
 <td bgcolor="orange" align = "center"> 가격 </td> 
 <td> <input type="text" name = "write" value="<%= product.getPrice() %>"></td>
</tr>

<tr>
 <td  bgcolor="orange" align = "center"> 상품 정보 </td> 
 <td> <textarea name="content" rows="10" cols="70"> <%= product.getContent() %> </textarea></td>
 </tr>

<tr>
 <td bgcolor="orange" align = "center"> 등록일 </td> 
 <td> <%= product.getRegdate() %></td>
</tr>


<tr>
<td colspan = "2" align = "center"> 
<input type="submit" value="상품 수정하기"></td> 
</tr>
</table>
</form>

<br><br>
<a href="deleteProduct.pr?id=<%= product.getId() %>">상품 삭제</a>

<p /> <a href="http://localhost:8181/JSP_MY_PROJJ">홈으로</a>
<p /> <a href= "getProductList.jsp"> 상품 목록</a>
<p /> <a href= "insertProduct.jsp"> 상품 등록</a>
<p /> <a href= "deleteProduct.jsp"> 상품 삭제</a>



</body>
</html>