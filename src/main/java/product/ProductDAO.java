package product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil; 

public class ProductDAO 
{
	// DAO : DataBase의 Board 테이블을 접근 하는 객체 : SQL 쿼리 
	
	Connection conn = null; 
	PreparedStatement pstmt = null ; 
	ResultSet rs = null ; 
		
	//sql 쿼리를 상수로 지정함.
	// insert 쿼리 
	private final String PRODUCT_INSERT = 
		"insert into product (id, name, price, content) "
		+ "values ((select nvl(max(id),0) + 1 from product ), ? , ? , ? )";
    
	// DB의 Product 테이블의 모든 레코드를 출력 쿼리 : 레코드가 여러개 : dto ==> ArrayList 리턴 
	private final String PRODUCT_LIST = "select * from product order by id desc" ; 
	
	// DB의 Product 테이블의 레코드 조회 : 레코드 1개  <== dto
	private final String PRODUCT_GET = "select * from product where id = ?" ; 
	
	// DB의 Product 테이블의 업데이트 쿼리 
	private final String PRODUCT_UPDATE = "update product set name= ?, price= ? , content = ? where id = ?"; 
	
	// DB의 Product 테이블의 레코드를 삭제 
	private final String PRODUCT_DELETE = "delete product where id = ?";

	//insertProduct(ProductDTO dto) 메소드  : 
	public void insertProduct (ProductDTO dto) 
	{
		System.out.println("= insertProduct 기능 처리 =");
		
		try 
		{
			//conn, pstmt 객체 활성화 
			conn = JDBCUtil.getConnection() ; 
			pstmt= conn.prepareStatement(PRODUCT_INSERT); 
			
			//pstmt 객체의 ? 변수의 값 할당. 
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getPrice());
			pstmt.setString(3, dto.getContent());
			
			//pstmt 를 실행해서 DB에 저장 
			pstmt.executeUpdate(); 
			
			System.out.println("Product 테이블에 값이 잘 insert 되었습니다. ");
			
		}
		
		catch (Exception e) 
		{
			System.out.println("Product 테이블에 값이 insert에 실패 했습니다. ");
			e.printStackTrace();
		} 
		
		finally 
		{
			//사용한 객체 제거 
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	// Board 테이블의 전체 레코드를 출력 하는 메소드 
	// DB의 레코드 하나를 BoardDTO에 담는다. 각각의 BoardDTO 를 ArrayList에 담아서 리턴 
	// rs, pstmt, conn
	public List<ProductDTO> getProductList(ProductDTO dto) 
	{
		//중요 : ArryList 는 While 블락 밖에서 선언
		//      ArryList에 저장되는  BoardDTO 선언은 while 블락 내부에서 선언 
		
		List<ProductDTO> productList = new ArrayList<>(); 
		
		try 
		{
			conn = JDBCUtil.getConnection(); 	//conn 객체 활성화 : Oracle , XE , HR12 , 1234 
			//Product_LIST = "select * from product order by id desc" 
			pstmt = conn.prepareStatement(PRODUCT_LIST) ; 
			
			// pstmt 를 실행후 rs 에 레코드를 저장 
			rs = pstmt.executeQuery(); 
			
			//System.out.println("DB Select 성공");
			
			// rs의 각 레코드를 ProductDTO에 저장 ==> 각 각의 DTO를 ArrayList에 저장 
				// if , do ~ while   <===>  while
				//rs.next() : 다음 레코드가 존재하면 true, 커서가 다음레코드로 이동 
				
			while (rs.next()) 
			{
				// ProductDTO 객체 생성 
				ProductDTO product = new ProductDTO();
				    // 루프 블락 내에 선언 
				product.setId(rs.getInt("ID"));
				product.setName(rs.getString("NAME"));
				product.setPrice(rs.getInt("PRICE"));
				product.setContent(rs.getString("CONTENT"));
				product.setRegdate(rs.getDate("REGDATE"));
				
				// productList : ArrayList의 add 메소드를 사용해서 ProductDTO를 저장함. 
				productList.add(product); 	
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
			
		return productList ; 
		
	}
	
	// 글 상세 조회 : getProduct(dto) 
	public ProductDTO getProduct(ProductDTO dto) 
	{
		System.out.println("getProduct 메소드 호출 성공");		
		
		ProductDTO product = new ProductDTO(); 
		
		try 
		{
			conn = JDBCUtil.getConnection();
			// PRODUCT_GET = "select * from product where id = ?"
			pstmt = conn.prepareStatement(PRODUCT_GET); 
			pstmt.setInt(1, dto.getId());
			
			// rs : 레코드 1개 
			rs = pstmt.executeQuery(); 
			
			//rs의 값이 존재할때 
			while ( rs.next()) 
			{
				product.setId(rs.getInt("ID"));
				product.setName(rs.getString("NAME"));
				product.setPrice(rs.getInt("PRICE"));
				product.setContent(rs.getString("CONTENT"));
				product.setRegdate(rs.getDate("REGDATE"));
				
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
				
		return  product; 
	}
	
	// 상품 수정 메소드 : updateProduct(dto)
	public void updateProduct(ProductDTO dto) 
	{
		System.out.println("updateProduct 메소드 호출됨");
		
		try 
		{
			conn = JDBCUtil.getConnection(); 
			//BOARD_UPDATE = "update board set title= ?, write= ? , content = ? where seq = ?"
			pstmt = conn.prepareStatement(PRODUCT_UPDATE); 
			
			// ? 변수에 값을 할당 
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getPrice());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4,dto.getId());
			
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
	
	// 상품 삭제 메소드 : deleteProduct(dto) 
	public void deleteProduct(ProductDTO dto) 
	{
		
		try 
		{
			conn = JDBCUtil.getConnection(); 
			// BOARD_DELETE = "delete board where seq = ?"
			pstmt = conn.prepareStatement(PRODUCT_DELETE); 
			
			// ? 변수값 할당. 
			pstmt.setInt(1, dto.getId());
			
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
	
}