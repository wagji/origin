<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "board.BoardDTO" %>

<%
BoardDTO board = new BoardDTO();
board = (BoardDTO) session.getAttribute("board");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세 페이지</title>
</head>
<body>
<h1>글 수정하기</h1>
<hr><br><br>
<form method = "post" action = "updateBoard.do">
<input type = "hidden" name = "id" value = "<%= board.getId() %>">
<table border="1" width = "700px" cellpadding="5px" >

<tr>
 <td bgcolor="orange" align="center">제목</td>
 <td><input type="text" name="title" value="<%= board.getTitle() %>"></td>
</tr>

<tr>
 <td bgcolor="orange" align = "center"> 작성자 </td> 
 <td> <input type="text" name = "write" value="<%= board.getWrite() %>"></td>
</tr>

<tr>
 <td  bgcolor="orange" align = "center"> 내용 </td> 
 <td> <textarea name="content" rows="10" cols="70"> <%= board.getContent() %> </textarea></td>
 </tr>

<tr>
 <td bgcolor="orange" align = "center"> 등록일 </td> 
 <td> <%= board.getRegdate() %></td>
</tr>


<tr>
<td bgcolor="orange" align = "center"> 조회수 </td> 
<td> <%= board.getCnt() %> </td>
</tr>

<tr>
<td colspan = "2" align = "center"> 
<input type="submit" value="글 수정하기"></td> 
</tr>
</table>
</form>

<br><br>
<a href="deleteBoard.do?id=<%= board.getId() %>">글 삭제</a>

<p /> <a href="http://localhost:8181/JSP_MY_PROJJ">홈으로</a>
<p /> <a href= "getBoardList.jsp"> 글 목록</a>
<p /> <a href= "insertBoard.jsp"> 새 글쓰기</a>
<p /> <a href= "deleteBoard.jsp"> 글삭제</a>


</body>
</html>