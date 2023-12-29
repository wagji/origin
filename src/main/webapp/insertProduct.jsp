<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 상품 등록</title>
</head>
<body>

<form method = "post" action = "insertProduct.pr">
<table border="1" cellpadding="10" cellspacing="0">

<tr>
 <td bgcolor="orange" align="center">상품이름</td>
 <td><input type="text" name="name" ></td>
</tr>

<tr>
 <td bgcolor="orange" align = "center"> 가격 </td> 
 <td> <input type="text" name = "price" size="10"></td>
</tr>

<tr>
 <td  bgcolor="orange" align = "center"> 상품 설명 </td> 
 <td> <textarea name="content" rows="10" cols="40"></textarea></td>
 </tr>
<tr>
<td colspan = "2" align = "center"> <input type="submit" value="새 상품 등록"></td> 
</tr>
</table>
</form>

<br> <a href="http://localhost:8181/JSP_MY_PROJJ"> 홈으로 </a>
<p /> <a href= "getProductList.pr"> 상품 목록 </a>


</body>
</html>