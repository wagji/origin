package member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import board.BoardDTO;
import util.JDBCUtil;


public class MembersDAO 
{
	//SQL 쿼리를 접근하는 객체 선언 
	Connection conn = null ; 
	PreparedStatement pstmt = null; 
	ResultSet rs = null; 
	
	//sql 쿼리를 적용하는 상수 선언 
	private final String MEMBERS_LOGIN = "select * from member where id = ? and password = ?"; 
	
	private final String MEMBERS_INSERT = 
	"insert into member (id, password, phone, email, addr, role) "
	+ "values (?, ? , ? , ?, ?, ?)";
	    
	// DB의 Member 테이블의 모든 레코드를 출력 쿼리 : 레코드가 여러개 : dto ==> ArrayList 리턴 
	private final String MEMBERS_LIST = "select * from member order by id desc" ; 
		
	// DB의 Member 테이블의 글 상세 조회 : 레코드 1개  <== dto
	private final String MEMBERS_GET = "select id, phone, email, regdate, addr, role from member where id = ?" ; 
		
	// DB의 Member 테이블의 업데이트 쿼리 
	private final String MEMBERS_UPDATE = "update member set phone= ?, email= ? , addr = ?, role = ? where id = ?"; 
		
	// DB의 Member 테이블의 레코드를 삭제 
	private final String MEMBERS_DELETE = "delete member where id = ?";

	
	//메소드 - 계정 추가
	//insertMember(MemberDTO dto) 메소드  
	public void insertMembers (MembersDTO dto) 
	{
		System.out.println("= insertMember 기능 처리 =");
			
		try 
		{
				
			//conn, pstmt 객체 활성화 
			conn = JDBCUtil.getConnection() ;
			// MEMBERS_INSERT = "insert into member (id, password, phone, email, addr, role) "
			// + "values (?, ? , ? , ?, ?, ?)";
			pstmt= conn.prepareStatement(MEMBERS_INSERT); 
				
			//pstmt 객체의 ? 변수의 값 할당. 
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getAddr());
			pstmt.setString(6, dto.getRole());
				
			//pstmt 를 실행해서 DB에 저장 
			pstmt.executeUpdate(); 
				
			System.out.println("Member 테이블에 값이 잘 insert 되었습니다. ");
				
		}
			
		catch (Exception e) 
		{
			System.out.println("Member 테이블에 값이 insert에 실패 했습니다. ");
			e.printStackTrace();
		} 
			
		finally 
		{
			//사용한 객체 제거 
			JDBCUtil.close(pstmt, conn);
		}
	}

	
	//Member 테이블의 전체 레코드를 출력 하는 메소드 
	//DB의 레코드 하나를 MembersDTO에 담는다. 각각의 MembersDTO 를 ArrayList에 담아서 리턴 
	//rs, pstmt, conn
	public List<MembersDTO> getMembersList(MembersDTO dto) 
	{
		//중요 : ArryList 는 While 블락 밖에서 선언
		//      ArryList에 저장되는  BoardDTO 선언은 while 블락 내부에서 선언 
		
		List<MembersDTO> MembersList = new ArrayList<>(); 
		
		try 
		{
			conn = JDBCUtil.getConnection(); 	//conn 객체 활성화 : Oracle , XE , HR12 , 1234 
			//BOARD_LIST = "select * from board order by seq desc" 
			pstmt = conn.prepareStatement(MEMBERS_LIST) ; 
			
			// pstmt 를 실행후 rs 에 레코드를 저장 
			rs = pstmt.executeQuery(); 
			
			//System.out.println("DB Select 성공");
			
			// rs의 각 레코드를 BoardDTO에 저장 ==> 각 각의 DTO를 ArrayList에 저장 
				// if , do ~ while   <===>  while
				//rs.next() : 다음 레코드가 존재하면 true, 커서가 다음레코드로 이동 
				
			while (rs.next()) 
			{
				// BoardDTO 객체 생성 
				MembersDTO member = new MembersDTO();
				    // 루프 블락 내에 선언 
				member.setId(rs.getString("ID"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setPhone(rs.getString("PHONE"));
				member.setEmail(rs.getString("EMAIL"));
				member.setRegdate(rs.getDate("REGDATE"));
				member.setAddr(rs.getString("ADDR"));
				member.setRole(rs.getString("ROLE"));
				
				//MembersList : ArrayList의 add 메소드를 사용해서 MembersDTO를 저장함. 
				MembersList.add(member); 	
			}
			
					
		}
		
		catch (Exception e) 
		{
			System.out.println("DB Select 실패");
			e.printStackTrace();     // 실패 할 경우 콘솔에 오류 정보 출력 
		}
		
		finally 
		{
			//사용한 객체 반납 : rs, pstmt, conn 
			JDBCUtil.close(rs, pstmt, conn);
		}
			
		return MembersList; 	
	}


	//Member 상세 조회 : getMembers(dto) 
	public MembersDTO getMembers(MembersDTO dto) 
	{
		System.out.println("getMembers 메소드 호출 성공");
				
		MembersDTO member = new MembersDTO(); 
		
		try 
		{
			conn = JDBCUtil.getConnection();
			//"select id, phone, email, addr, role from member where id = ?" ;
			pstmt = conn.prepareStatement(MEMBERS_GET); 
			pstmt.setString(1, dto.getId());
			
			// rs : 레코드 1개 
			rs = pstmt.executeQuery(); 
			
			//rs의 값이 존재할때 
			while ( rs.next()) 
			{
				
				member.setId(rs.getString("ID"));
				member.setPhone(rs.getString("PHONE"));
				member.setEmail(rs.getString("EMAIL"));
				member.setRegdate(rs.getDate("REGDATE"));
				member.setAddr(rs.getString("ADDR"));
				member.setRole(rs.getString("ROLE"));
				
				System.out.println("RS 의 레코드를 dto 저장 성공 ");
			}
			
		}
		
		catch (Exception e) 
		{
			System.out.println("글 상세조회 실패  ");
			e.printStackTrace();
		}
		
		finally 
		{
			JDBCUtil.close(rs, pstmt, conn);
		}
				
		return  member; 
	}


	// 회원 정보 수정 메소드 : updateMembers(dto)
	public void updateMembers(MembersDTO dto) 
	{
		System.out.println("updateMembers 메소드 호출됨");
		
		try 
		{
			conn = JDBCUtil.getConnection(); 
			//BOARD_UPDATE = "update member set title= ?, write= ? , content = ? where id = ?"
			pstmt = conn.prepareStatement(MEMBERS_UPDATE); 
			
			// ? 변수에 값을 할당 
			pstmt.setString(1, dto.getPhone());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getAddr());
			pstmt.setString(4, dto.getRole());
			pstmt.setString(5, dto.getId());
			
			//쿼리를 실행
			pstmt.executeUpdate(); 		//insert, update, delete 구문일때 실행 
			
			System.out.println("DB 업테이트 성공 ");
			
		}
		
		catch (Exception e) 
		{
			System.out.println("DB 업테이트 실패 ");
			e.printStackTrace();
			
		}
		
		finally 
		{
			JDBCUtil.close(pstmt, conn);
		}
		
	}


	// 회원 삭제 메소드 : deleteMembers(dto) 
	public void deleteMembers(MembersDTO dto) 
	{
		
		try 
		{
			conn = JDBCUtil.getConnection(); 
			// BOARD_DELETE = "delete board where seq = ?"
			pstmt = conn.prepareStatement(MEMBERS_DELETE); 
			
			// ? 변수값 할당. 
			pstmt.setString(1, dto.getId());
			
			// 쿼리 실행 
			pstmt.executeUpdate();   // insert, update, delete 
			
			System.out.println("DB의 레코드 삭제 성공");
			
		}
		
		catch (Exception e) 
		{
			System.out.println("DB의 레코드 삭제 실패");
			e.printStackTrace();
			
		}
		
		finally 
		{
			JDBCUtil.close(pstmt, conn);
		}
		
	}
	
	
	//메소드 - 로그인
	public MembersDTO login(MembersDTO dto) 
	{
		System.out.println("login 메소드 호출");
		
		//리턴으로 돌려줄 UserDTO  <== null, dto 
		MembersDTO Member = null; 
		
		try
		{
			conn = JDBCUtil.getConnection(); 
			// USERS_LOIN = "select * from users where id = ? and password = ?"
			pstmt = conn.prepareStatement(MEMBERS_LOGIN); 
			
			// ? 변수의 값할당 
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			
			// pstmt 실행후 rs 로 쿼리한 레코드 저장 
			rs = pstmt.executeQuery();   //select 
			
			// rs의 값이 존재할때 인증 성공 : 레코드 1개가 출력 
			while ( rs.next()) 
			{
				// 리턴으로 돌려줄 dto 선언 
				Member = new MembersDTO(); 
				
				Member.setId(rs.getString("ID"));
				Member.setPassword(rs.getString("PASSWORD"));
				Member.setPhone(rs.getString("PHONE"));
				Member.setEmail(rs.getString("EMAIL"));
				Member.setRegdate(rs.getDate("REGDATE"));
				Member.setAddr(rs.getString("ADDR"));
				Member.setRole(rs.getString("ROLE"));
				
				System.out.println(" - 인증 성공 : 해당 ID와 Password가 DB에 존재합니다.  ");				
			}
					
		}
		
		catch (Exception e) 
		{
			System.out.println("인증시 문제가 발생 했습니다. ");
			e.printStackTrace();
		}
		
		finally 
		{
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return Member; 
	}
	
	//메소드 - 로그아웃
		public MembersDTO logout(MembersDTO dto) 
		{
			System.out.println("logout 메소드 호출");
			
			//리턴으로 돌려줄 UserDTO  <== null, dto 
			MembersDTO Member = null; 
			
			try
			{
				conn = JDBCUtil.getConnection(); 
				// USERS_LOIN = "select * from users where id = ? and password = ?"
				pstmt = conn.prepareStatement(MEMBERS_LOGIN); 
				
				// ? 변수의 값할당 
				pstmt.setString(1, dto.getId());
				pstmt.setString(2, dto.getPassword());
				
				// pstmt 실행후 rs 로 쿼리한 레코드 저장 
				rs = pstmt.executeQuery();   //select 
				
				// rs의 값이 존재할때 인증 성공 : 레코드 1개가 출력 
				while ( rs.next()) 
				{
					// 리턴으로 돌려줄 dto 선언 
					Member = new MembersDTO(); 
					
					Member.setId(rs.getString("ID"));
					Member.setPassword(rs.getString("PASSWORD"));
					Member.setPhone(rs.getString("PHONE"));
					Member.setEmail(rs.getString("EMAIL"));
					Member.setRegdate(rs.getDate("REGDATE"));
					Member.setAddr(rs.getString("ADDR"));
					Member.setRole(rs.getString("ROLE"));
					
					System.out.println(" - 인증 성공 : 해당 ID와 Password가 DB에 존재합니다.  ");				
				}
						
			}
			
			catch (Exception e) 
			{
				System.out.println("인증시 문제가 발생 했습니다. ");
				e.printStackTrace();
			}
			
			finally 
			{
				JDBCUtil.close(rs, pstmt, conn);
			}
			
			return Member; 
		}

}
