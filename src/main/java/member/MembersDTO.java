package member;

import java.sql.Date;

import lombok.Data;

@Data
public class MembersDTO {
	
	private String id ; 
	private String password;
	private String phone;
	private String email;
	private Date regdate;
	private String addr;
	private String role; 

}
