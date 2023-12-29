<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import = "java.util.*" %>
<%@ page import = "board.BoardDTO" %>

<%
 List<BoardDTO> boardList = new ArrayList<>();
 try
 {
	boardList = (List<BoardDTO>) session.getAttribute("boardList");
 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 페이지 리스트</title>
</head>
<body>

 <center>
 
 


<h1>글목록</h1>
<hr>
<!--  검색 기능 추가 -시작  -->
  
  <table border = "1" width = "700px">
    <tr> <td>
    
       <form method = "post" action = "getBoardList.do">
           <select name = "searchCondition" >
               <option values = "TITLE" > 제목 검색 </option>
               <option values = "WRITE" > 글쓴이 검색 </option>
               <option values = "CONTENT" > 내용 검색 </option>
               <option values = "REGDATE" > 날짜 검색 </option>
          </select>
      
         <input type = "text" name = "searchKeword" size = "40 " >
        <input type = "submit"  value = "검색시작" >
  
  </form>
  
</tr> </td>
</table>

<table border = "1" width = "700px">

<tr>
<th bgcolor="orange" width = "100px">번호</th>
<th bgcolor="orange" width = "100px">제목</th>
<th bgcolor="orange" width = "100px">작성자</th>
<th bgcolor="orange" width = "100px">등록일</th>
<th bgcolor="orange" width = "100px">조회수</th>
</tr>
<% for(BoardDTO k : boardList) { %>

<tr>
<td align = "center"><%=k.getId() %>></td>
<td><a href = "getBoard.do?id=<%=k.getId()%>"><%= k.getTitle() %></a></td>
<td><%=k.getWrite() %></td>
<td><%=k.getRegdate() %></td>
<td><%=k.getCnt() %></td>
</tr>
<%
}
session.removeAttribute("boardList");
}

catch(Exception e)
{
	response.sendRedirect("getBoardList.do");
	e.printStackTrace();
}
%>
</table>
       <!-- 검색 기능 추가 끝  -->
<p/>
<table border = "1" width = "700px"> 
</table>


<br> <a href="http://localhost:8181/JSP_MY_PROJJ">홈으로</a>
<p /> <a href= "insertBoard.jsp"> 새 글쓰기</a>
<p /> <a href= "deleteBoard.jsp"> 글 삭제</a>

 </center>

</body>
</html>