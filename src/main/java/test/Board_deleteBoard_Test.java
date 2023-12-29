package test;

import board.BoardDAO;
import board.BoardDTO;

public class Board_deleteBoard_Test 
{
	public static void main(String[] args) 
	{
		//1. BoardDTO 에 id 의 값을 할당 
		BoardDTO dto = new BoardDTO(); 
		dto.setId(1);
		
		//2. BoardDAO 의 deleteBoard(dto)  
		BoardDAO dao = new BoardDAO(); 
		dao.deleteBoard(dto);

		
		
	}

}
