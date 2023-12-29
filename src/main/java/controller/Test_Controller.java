package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// http://localhost:8181/JSP_MVC_M2/*.my
@WebServlet("*.my")
public class Test_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test_Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// client 보내는 get 요청도 처리 
		// client 보내는 post 요청도 처리 
		
		// 한글이 깨어지지 않도록 처리 
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("Test Controller 잘 호출됨 ");
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
