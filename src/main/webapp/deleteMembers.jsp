<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맴버 삭제</title>
</head>
<body>
<h1>맴버 삭제</h1>
<form method = "post" action ="deleteMembers.us"> 
<tr> <td> 삭제할 맴버 id 입력 :  </td> 
<td> <input type = "text" name = "id"> </td>

<tr> <td colspan ="2" align = "center">
<input type="submit" value="삭제"> </td> 
</tr>
</form>

<br> <a href="http://localhost:8181/JSP_MY_PROJJ"> 홈으로 </a>
<p /> <a href= "getMembersList.us"> 맴버 목록 </a>
</body>
</html>