<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 맴버 등록</title>
</head>
<body>

<h1>새 맴버 등록</h1>
<form method = "post" action = "insertMembers.us">
<table border="1" cellpadding="10" cellspacing="0">

<tr>
 <td bgcolor="orange" align="center">id</td>
 <td><input type="text" name="id" ></td>
</tr>

<tr>
 <td bgcolor="orange" align = "center"> password </td> 
 <td> <input type="text" name = "password" size="10"></td>
</tr>

<tr>
 <td  bgcolor="orange" align = "center"> phone </td> 
 <td> <textarea name="phone" rows="10" cols="40"></textarea></td>
 </tr>
 
 <tr>
 <td  bgcolor="orange" align = "center"> email </td> 
 <td> <textarea name="email" rows="10" cols="40"></textarea></td>
 </tr>
 
 <tr>
 <td  bgcolor="orange" align = "center"> address </td> 
 <td> <textarea name="addr" rows="10" cols="40"></textarea></td>
 </tr>
 
 <tr>
 <td  bgcolor="orange" align = "center"> role </td> 
 <td> <textarea name="role" rows="10" cols="40"></textarea></td>
 </tr>
 
<tr>
<td colspan = "2" align = "center"> <input type="submit" value="새 맴버 등록"></td> 
</tr>
</table>
</form>

<br> <a href="http://localhost:8181/JSP_MY_PROJJ"> 홈으로 </a>
<p /> <a href= "getMembersList.us"> 맴버 목록 </a>


</body>
</html>