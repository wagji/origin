<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "member.MembersDTO" %>

<%
MembersDTO members = new MembersDTO();
members = (MembersDTO) session.getAttribute("member");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 상세 페이지</title>
</head>
<body>


<h1>멤버 수정하기</h1>
<hr><br><br>
<form method = "post" action = "updateMembers.us">

<input type = "hidden" name = "id" value = "<%= members.getId() %>">
<table border="1" width = "700px" cellpadding="5px" >


<tr>
 <td bgcolor="orange" align="center">phone</td>
 <td><input type="text" name="phone" value="<%= members.getPhone() %>"></td>
</tr>


<tr>
 <td bgcolor="orange" align="center">email</td>
 <td><input type="text" name="email" value="<%= members.getEmail() %>"></td>
</tr>

<tr>
 <td bgcolor="orange" align = "center"> address </td> 
 <td> <input type="text" name = "addr" value="<%= members.getAddr() %>"></td>
</tr>

<tr>
 <td  bgcolor="orange" align = "center"> role </td> 
 <td> <textarea name="role" rows="10" cols="70"> <%= members.getRole() %> </textarea></td>
 </tr>

<tr>
 <td bgcolor="orange" align = "center"> 등록일 </td> 
 <td> <%= members.getRegdate() %></td>
</tr>


<tr>
<td colspan = "2" align = "center"> 
<input type="submit" value="정보 수정하기"></td> 
</tr>
</table>
</form>

<br><br>
<a href="deleteMembers.us?id=<%= members.getId() %>">멤버 삭제</a>

<p /> <a href="http://localhost:8181/JSP_MY_PROJJ">홈으로</a>
<p /> <a href= "getMembersList.jsp"> 맴버 목록</a>
<p /> <a href= "insertMembers.jsp"> 맴버 추가</a>
<p /> <a href= "deleteMembers.jsp"> 맴버 삭제</a>


</body>
</html>