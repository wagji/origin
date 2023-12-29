package controller;

import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import member.MembersDAO;
import member.MembersDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import board.BoardDAO;
import board.BoardDTO;

// http://localhost:8181/JSP_MVC_M2/*.us
@WebServlet ("*.us")
public class MembersController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
   public MembersController() 
   {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		//한글이 깨어지지 않도록 처리 ( client ==> server ) 
		request.setCharacterEncoding("UTF-8");
	
		//1. 
		String uri = request.getRequestURI(); 
		//System.out.println(uri);
		String path = uri.substring(uri.lastIndexOf("/")); 
		//System.out.println(path);
		
		
		if (path.equals("/login.us")) 
		{
			System.out.println("login.us 요청 처리");
			
			//1. client에서 넘긴 파라미터 변수값을 받아서 변수에 저장 
			String id = request.getParameter("id"); 
			String password = request.getParameter("password"); 
			
			//2. 넘겨받은 값을 MembersDTO에 저장
			MembersDTO dto = new MembersDTO(); 
			dto.setId(id); 
			dto.setPassword(password); 
			
			//3. MembersDAO의 login(dto) 
			MembersDAO dao = new MembersDAO(); 
			
			//리턴 받을 MembersDTO 선언 
			MembersDTO user = new MembersDTO(); 
			
			user = dao.login(dto); 
			//user 가 null 경우 : 인증 실패 , 그렇지 않을 경우 인증 성공 
			
			
			if (user == null) 
			{	//인증 실패
				System.out.println("인증 실패 했습니다.");
				response.sendRedirect("LoginForm.jsp"); 
				
			}
			
			
			else 
			{ // 인증 성공 
				// 세션의 변수의 값을 할당 하고 view 페이지로 전송 
				System.out.println("인증 성공 했습니다. ");
				HttpSession session = request.getSession(); 
				session.setAttribute("id", user.getId()); 
				session.setAttribute("role", user.getRole()); 
				
				response.sendRedirect("LoginForm.jsp"); 
			}
		}
		
		
		else if (path.equals("/logout.us")) 
		{
			System.out.println("/logout.us 요청 처리 ");
			
			//1 사용자 세션 변수의 모든 값을 삭제함. 
			HttpSession session = request.getSession(); 
			
			//세션 변수에 담긴 모든 변수의 값을 삭제 
			session.invalidate(); 
			
			//뷰페이지로 이동 (처음 페이지로 이동)
			response.sendRedirect("http://localhost:8181/JSP_MY_PROJJ"); 
		}
		
		
		else if (path.equals("/insertMembers.us")) 
		{
			System.out.println("insertMembers.us 요청 처리");
			//로직 처리 
			
			//1. 클라이언트의 넘어오는 변수가 잘 들어 오는지 확인  (클라이언트 요청) 
			String id = request.getParameter("id"); 
			String password = request.getParameter("password"); 
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String addr = request.getParameter("addr");
			String role = request.getParameter("role");
			/*
			System.out.println("title : " + title);
			System.out.println("write : " + write);
			System.out.println("content : " + content);
			*/ 
			
			//2. 클라이언트에서 넘어오는 변수의 값을 DTO에 Setter 주입 
			MembersDTO dto = new MembersDTO(); 
			dto.setId(id); 
			dto.setPassword(password); 
			dto.setPhone(phone);
			dto.setEmail(email);
			dto.setAddr(addr);
			dto.setRole(role);
			dto.setId(id);
			
			//3. DAO 에 insertBoard (dto)
			MembersDAO dao = new MembersDAO(); 
			dao.insertMembers(dto); 			//insert 성공 
			
			//System.out.println("DB 저장 성공 ");
			
			//비즈니스 로직 완료 : DTO , DAO   
			
			// 4. 뷰 페이지 전송 : 값을 insertBoard 후 DB의 전체 레코드를 출력 페이지로 이동 
				// 클라이언트가 getBoardList.do 요청을 새롭게 요청함. 
				//주의 : http://localhost:8181/getBoardList.do   <== 오류 
				    //  http://localhost:8181/JSP_MVC_M2/getBoardList.do   <== 정상  
			response.sendRedirect("getMembersList.us"); 
			
		}
		
		else if (path.equals("/getMembersList.us")) 
		{		// DB의 레코드를 출력 하는 페이지 
			System.out.println("/getMembersList.us 요청");
			//로직 처리 
			
			//1. BoardDTO 객체 생성 
			MembersDTO dto = new MembersDTO(); 
			
			//2. BoardDAO 객체의 getBoardList(dto) 
			MembersDAO dao = new MembersDAO (); 
			
			//리턴 받을 변수 선언 
			List<MembersDTO> membersList = new ArrayList<>(); 
			
			//boardList : DB의 Board 테이블의 레코드를 dto 로 저장후 ArrayList 내의 각 방에 저장된 상태 
			membersList = dao.getMembersList(dto); 
			
			//boardList 클라이언트 view 페이지로 전송 : Session 변수에 담아서 client 뷰페이지로 전송
			//client 의 session 정보를 가져와서 session 변수에 할당. 
			HttpSession session = request.getSession(); 
			
			//세션에 boardList 를 추가
			session.setAttribute("membersList", membersList); 
			
			//클라이언트 뷰 페이지 
			response.sendRedirect("getMembersList.jsp"); 
			
			
		}
		
		else if (path.equals("/getMembers.us")) 
		{
			System.out.println("/getMembers.us 요청");
			//로직 처리 
			
			//1. clinet 넘어오는 파라미터 seq 변수의 값을 읽어서 dto에 저장후 dao.getBoard(dto) 
			//http://localhost:8181/JSP_MVC_M2/getBoard.do?seq=5 
			
			String id = request.getParameter("id"); 
			
			//2. dto에 seq 값을 setter 주입 
			MembersDTO dto = new MembersDTO(); 
			dto.setId(id); 
			
			//3. DAO의 getBoard(dto) 호출후 리턴 값을 받아서 저장 
			MembersDAO dao = new MembersDAO(); 
			
			//리턴값을 받을 DTO 선언 
			MembersDTO member = new MembersDTO(); 
			member = dao.getMembers(dto); 
			
			//4. 세션 변수에 저장후 뷰 페이지로 전송 , 
			HttpSession session = request.getSession(); 
			
			session.setAttribute("member", member); 
			
			//5. 뷰 페이지 
			response.sendRedirect("getMembers.jsp"); 
			
			
		}
		
		else if (path.equals("/updateMembers.us")) 
		{
			System.out.println("/updateMembers.us 요청");
			//로직 처리 
			//1. 클라이언트의 파라미터의 변수를 받아서 새로운 변수에 저장 
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String addr = request.getParameter("addr");
			String role = request.getParameter("role");
			String id = request.getParameter("id"); 
			
			// 변수값 출력 :
			/*
			System.out.println(title);
			System.out.println(write);
			System.out.println(content);
			System.out.println(seq);
			*/ 
			
			//2. 변수를 BoardDTO에 setter 주입 
			MembersDTO dto = new MembersDTO(); 
			dto.setPhone(phone);
			dto.setEmail(email);
			dto.setAddr(addr);
			dto.setRole(role);
			dto.setId(id); 
			
			//3. BoardDAO 에 updateBoard(dto)  
			MembersDAO dao = new MembersDAO (); 
			dao.updateMembers(dto); 
			
			//4. 뷰 페이지로 이동 ( 업데이트 후 리스트 페이지로 이동  
			response.sendRedirect("getMembersList.us");
					
		}
		
		else if (path.equals("/deleteMembers.us")) 
		{
			System.out.println("/deleteMembers.us 요청");
			//로직 처리 
			
			//1. 클라이언트의 파라미터 변수의 값 할당 : seq 
			String id = request.getParameter("id"); 
			
			//2. 변수의 값을 BoardDTO에 주입 
			MembersDTO dto = new MembersDTO(); 
			dto.setId(id); 
			
			//3. BoardDAO의 메소드 호출 : deleteBoard(dto) 
			MembersDAO dao = new MembersDAO(); 
			
			dao.deleteMembers(dto); 
			
			//4. 뷰 페이지 이동 
			response.sendRedirect("getMembersList.us"); 

		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		doGet(request, response);
	}

}