package test;

import java.util.ArrayList;
import java.util.List;

import board.BoardDAO;
import board.BoardDTO;
import member.MembersDAO;
import member.MembersDTO;

public class Member_login_Test 
{

	public static void main(String[] args) 
	{
		//user 정보 입력 1
		//1. DTO 객체를 생성후 값 입력 
		MembersDTO dto = new MembersDTO(); 
				
		// dto 에 setter를 사용해서 값을 입력 
		dto.setId("aa");
		dto.setPassword("1234");
		dto.setPhone("010-0000-0000");
		dto.setEmail("aa@aa.com");
		dto.setAddr("Seoul");
		dto.setRole("user");

		//2. DAO 객체에 insertBoard(dto) 
		MembersDAO dao = new MembersDAO(); 
				
		dao.insertMembers(dto);


		//user 정보 입력 1
		//1. DTO 객체를 생성후 값 입력 
		MembersDTO dto4 = new MembersDTO(); 
						
		// dto 에 setter를 사용해서 값을 입력 
		dto4.setId("bb");
		dto4.setPassword("5678");
		dto4.setPhone("010-2222-2222");
		dto4.setEmail("bb@bb.com");
		dto4.setAddr("UK");
		dto4.setRole("Extra");

		//2. DAO 객체에 insertBoard(dto) 
		MembersDAO dao4 = new MembersDAO(); 
					
		dao4.insertMembers(dto4);
		
		
		// 1. MembersDTO : id, password 
		MembersDTO dto1 = new MembersDTO(); 
		dto1.setId("aa");
		dto1.setPassword("1234");
		
		// 2. MembersDAO : login (dto)  리턴된 값이 null 이라면 인증 실패, 그렇지 않으면 인증 성공 
		MembersDAO dao1 = new MembersDAO(); 
		
		// 리턴 받을 MembersDTO 선언 
		MembersDTO user = new MembersDTO(); 
		
		user = dao1.login(dto1); 
		
		if ( user != null) 
		{
			System.out.println("인증 성공함. ");
			System.out.println(user);
		}
		
		else 
		{
			System.out.println("인증 실패. ");
			System.out.println(user);
		}


		//Member 정보 수정
		//1.  MembersDTO 에 phone, email, addr role 값을 
		MembersDTO dto3 = new MembersDTO(); 
		dto3.setPhone("010-1111-1111");
		dto3.setEmail("a1a@a1a.com");
		dto3.setAddr("USA");
		dto3.setRole("Master");
		dto3.setId("aa");
		
		//2. MembersDAO의 updateMembers(dto) 호출 
		MembersDAO dao3 = new MembersDAO(); 
		
		dao3.updateMembers(dto3);
		
		
		//정보 1명만 확인
		//1. dto 에 조회할 id 값만 할당후 dao.getMembers(dto) 
		MembersDTO dto5 = new MembersDTO(); 
		dto5.setId("aa");
		
		//2. dao 메소드 호출 getBoard(dto) 
		MembersDAO dao5 = new MembersDAO(); 
		
		//리턴으로 돌려 받는 변수 선언 
		MembersDTO member = new MembersDTO(); 
		
		member = dao5.getMembers(dto5); 
		
		System.out.println(member);		
		

		//정보 모두 확인 - MembersDAO의 getMembersList(dto) 메소드 테스트 
		// 1.MembersDTO 객체 생성
		MembersDTO dto6 = new MembersDTO(); 
		
		// 2. BoardDAO 객체 생성 후 메소드 호출 
		MembersDAO dao6 = new MembersDAO();
				
		//ArrayList 선언 : <MembersDTO> 객체가 각 방에 들어 있음. 
		List<MembersDTO> MembersList = new ArrayList<>();
				
		//MembersList DB의 각 레코드를 DTO에 담아서 저장 
		MembersList = dao.getMembersList(dto); 
				
		//ArrayList : MembersList 의 각방의 BoardDTO 객체를 순환하면서 객체를 출력 
		// FOR 문을 사용해서 출력 
		System.out.println("===========FOR 문으로 출력 ===========");
		for (int i = 0 ; i < MembersList.size(); i++)
		{
			System.out.println(MembersList.get(i));
		}
				
		System.out.println("===========Enhanced For 문으로 출력 =====================");
		for (MembersDTO m : MembersList) 
		{   // boardList : ArrayList 의 각방의 저장된것을 b 변수로 끄집어내서 출력
			System.out.println(m);
		}

		//member 지우기
		//1. MembersDTO 에 id 의 값을 할당 
		MembersDTO dto2 = new MembersDTO(); 
		dto2.setId("aa");
				
		//2. MembersDAO 의 deleteMembers(dto)  
		MembersDAO dao2 = new MembersDAO(); 
		dao2.deleteMembers(dto2);
		

		//member 지우기
		//1. MembersDTO 에 id 의 값을 할당 
		MembersDTO dto7 = new MembersDTO(); 
		dto7.setId("bb");
				
		//2. MembersDAO 의 deleteMembers(dto)  
		MembersDAO dao7 = new MembersDAO(); 
		dao7.deleteMembers(dto7);

	}

}
