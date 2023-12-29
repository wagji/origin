<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 등록</title>
</head>
<body>
<h1>새 글 등록</h1>
<form method = "post" action = "insertBoard.do">
<table border="1" cellpadding="10" cellspacing="0">

<tr>
 <td bgcolor="orange" align="center">제목</td>
 <td><input type="text" name="title" ></td>
</tr>

<tr>
 <td bgcolor="orange" align = "center"> 작성자 </td> 
 <td> <input type="text" name = "write" size="10"></td>
</tr>

<tr>
 <td  bgcolor="orange" align = "center"> 내용 </td> 
 <td> <textarea name="content" rows="10" cols="40"></textarea></td>
 </tr>
<tr>
<td colspan = "2" align = "center"> <input type="submit" value="새 글 등록"></td> 
</tr>
</table>
</form>

<br> <a href="http://localhost:8181/JSP_MY_PROJJ"> 홈으로 </a>
<p /> <a href= "getBoardList.do"> 글 목록 </a>

</body>
</html>