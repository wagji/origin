package test;

import java.util.ArrayList;
import java.util.List;

import product.ProductDAO;
import product.ProductDTO;

public class Product_Test 
{

	public static void main(String[] args) 
	{
		//Product 정보 입력 1
		//1. DTO 객체를 생성후 값 입력 
		ProductDTO dto = new ProductDTO(); 
				
		// dto 에 setter를 사용해서 값을 입력 
		dto.setName("사과");
		dto.setPrice(10000);
		dto.setContent("충주산");

		//2. DAO 객체에 insertProduct(dto) 
		ProductDAO dao = new ProductDAO(); 				
		dao.insertProduct(dto);

		//Product 정보 입력 2
		//1. DTO 객체를 생성후 값 입력 
		ProductDTO dto1 = new ProductDTO(); 
								
		// dto 에 setter를 사용해서 값을 입력 
		dto1.setName("배");
		dto1.setPrice(20000);
		dto1.setContent("나주산");

		//2. DAO 객체에 insertProduct(dto) 
		ProductDAO dao1 = new ProductDAO(); 
		dao1.insertProduct(dto1);
				



		//Product 정보 수정
		//1. ProductDTO 에 name, price, content 변경, id 지정 
		ProductDTO dto2 = new ProductDTO(); 
		dto2.setName("낑깡");
		dto2.setPrice(30000);
		dto2.setContent("제주산");
		dto2.setId(1);
				
		//2. ProductDAO의 updateProduct(dto) 호출 
		ProductDAO dao2 = new ProductDAO(); 
		dao2.updateProduct(dto2);


				
		//상품 정보 1개만 확인
		//1. dto 에 조회할 id 값만 할당후 dao.getProduct(dto) 
		ProductDTO dto3 = new ProductDTO(); 
		dto3.setId(1);
				
		//2. dao 메소드 호출 getProduct(dto) 
		ProductDAO dao3 = new ProductDAO(); 
				
		//리턴으로 돌려 받는 변수 선언 
		ProductDTO product = new ProductDTO(); 
		product = dao3.getProduct(dto3); 
		System.out.println(product);		



		//정보 모두 확인 - ProductDAO의 getProductList(dto) 메소드 테스트 
		// 1.ProductsDTO 객체 생성
		ProductDTO dto4 = new ProductDTO(); 
				
		// 2. ProductDAO 객체 생성 후 메소드 호출 
		ProductDAO dao4 = new ProductDAO();
						
		//ArrayList 선언 : <ProductDTO> 객체가 각 방에 들어 있음. 
		List<ProductDTO> ProductList = new ArrayList<>();
						
		//ProductList DB의 각 레코드를 DTO에 담아서 저장 
		ProductList = dao4.getProductList(dto4); 
						
		//ArrayList : ProductList 의 각방의 ProductDTO 객체를 순환하면서 객체를 출력 
		// FOR 문을 사용해서 출력 
		System.out.println("===========FOR 문으로 출력 ===========");
		for (int i = 0 ; i < ProductList.size(); i++)
		{
			System.out.println(ProductList.get(i));
		}
						
		System.out.println("===========Enhanced For 문으로 출력 =====================");
		for (ProductDTO p : ProductList) 
		{   // boardList : ArrayList 의 각방의 저장된것을 p 변수로 끄집어내서 출력
			System.out.println(p);
		}
		

		

		//Product 지우기1
		//1.ProductDTO 에 id 의 값을 할당 
		ProductDTO dto5 = new ProductDTO(); 
		dto5.setName("낑깡");
						
		//2.ProductDAO 의 deleteProduct(dto)  
		ProductDAO dao5 = new ProductDAO(); 
		dao5.deleteProduct(dto5);
		
		
		//Product 지우기2
		//1.ProductDTO 에 name을 할당 
		ProductDTO dto6 = new ProductDTO(); 
		dto6.setName("사과");
								
		//2.ProductDAO 의 deleteProduct(dto)  
		ProductDAO dao6 = new ProductDAO(); 
		dao6.deleteProduct(dto6);
				

		//Product지우기3
		//1.ProductDTO 에 name을 할당 
		ProductDTO dto7 = new ProductDTO(); 
		dto7.setName("배");
						
		//2.ProductDAO 의 deleteProduct(dto)  
		ProductDAO dao7 = new ProductDAO(); 
		dao7.deleteProduct(dto7);

	}

}
