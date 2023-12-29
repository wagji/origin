package test;

import board.BoardDAO; 
import board.BoardDTO;

public class Board_Insert_Test 
{

	public static void main(String[] args) 
	{

		//1. DTO 객체를 생성후 값 입력 
		BoardDTO dto = new BoardDTO(); 
		
		// dto 에 setter를 사용해서 값을 입력 
		dto.setTitle("테스트제목 1");
		dto.setWrite("user");
		dto.setContent("테스트 글내용");

		//2. DAO 객체에 insertBoard(dto) 
		BoardDAO dao = new BoardDAO(); 
		
		dao.insertBoard(dto);
		
		
		
		//1. DTO 객체를 생성후 값 입력 
		BoardDTO dto1 = new BoardDTO(); 
				
		// dto 에 setter를 사용해서 값을 입력 
		dto1.setTitle("테스트제목 2");
		dto1.setWrite("admin");
		dto1.setContent("테스트 글내용2");
		
		//2. DAO 객체에 insertBoard(dto) 
		BoardDAO dao1 = new BoardDAO();		
		dao1.insertBoard(dto1);
		
		
		
		//1. DTO 객체를 생성후 값 입력 
		BoardDTO dto2 = new BoardDTO(); 
						
		// dto 에 setter를 사용해서 값을 입력 
		dto2.setTitle("테스트제목 3");
		dto2.setWrite("aaa");
		dto2.setContent("테스트 글내용3");
				
		//2. DAO 객체에 insertBoard(dto) 
		BoardDAO dao2 = new BoardDAO();		
		dao2.insertBoard(dto2);
		
		
		//1. DTO 객체를 생성후 값 입력 
		BoardDTO dto3 = new BoardDTO(); 
						
		// dto 에 setter를 사용해서 값을 입력 
		dto3.setTitle("테스트제목 4");
		dto3.setWrite("bbb");
		dto3.setContent("테스트 글내용4");
						
		//2. DAO 객체에 insertBoard(dto) 
		BoardDAO dao3 = new BoardDAO();		
		dao3.insertBoard(dto3);
	}

}
