package beautyhair.main.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table
public class Message {

	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	@Size(min = 3, max = 45, message = "Minimum 3, maximum 45 characters!")
	private String name;
	
	@Column
	@Email
	private String email;
	
	@Column
	@Size(min = 10, max = 1000, message = "Minimum 10, maximum 1000 characters!")
	private String message;

	@Column
	private String date;
	
	@Column
	private boolean seen;
	
	
	

	public Message() {
		
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}
	
	



	public String getMessage() {
		return message;
	}





	public void setMessage(String message) {
		this.message = message;
	}





	public String getDate() {
		return date;
	}





	public void setDate(String date) {
		this.date = date;
	}





	public boolean getSeen() {
		return seen;
	}





	public void setSeen(boolean seen) {
		this.seen = seen;
	}




	
	
	
	
	
	
	
	
	
	
	
}

