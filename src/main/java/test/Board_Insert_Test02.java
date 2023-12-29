package test;

import board.BoardDAO;
import board.BoardDTO;

public class Board_Insert_Test02 
{
	public static void main(String[] args) 
	{
	
	//Board 테이블에 값이 잘 들어가는지 테스트 : BoardDTO, BoardDAO : insertBoard(dto) 
	
	//1. BoardDTO 에 setter 를 사용해서 각 필드의 값을 insert 
	BoardDTO dto = new BoardDTO(); 
	dto.setTitle("제목입니다 - 26일");
	dto.setContent("내용입니다 - 26일");
	dto.setWrite("김길동");
	
	//2. BoardDAO의 intsertBoard(dto) 메소드 테스트 
	BoardDAO dao = new BoardDAO(); 
	dao.insertBoard(dto);
	
	}
}
