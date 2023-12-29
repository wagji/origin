package test;

import board.BoardDAO;
import board.BoardDTO;

public class Board_updateBoard_Test 
{

	public static void main(String[] args) 
	{
		//1.  BoardDTO 에 title, write, content, seq 값을 
		BoardDTO dto = new BoardDTO(); 
		dto.setTitle("테스트 - 제목");
		dto.setWrite("작성자-수정");
		dto.setContent("테스트 - 내용");
		dto.setId(1);
		
		//2. BoardDAO의 updateBoard(dto) 호출 
		BoardDAO dao = new BoardDAO(); 
		
		dao.updateBoard(dto);
		
		
		
	}

}
