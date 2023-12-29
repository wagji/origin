package product;

import java.sql.Date;

import lombok.Data;

@Data
public class ProductDTO {
	
	private int id ; 
	private String name;
	private int price;
	private String content;
	private Date regdate;

}
