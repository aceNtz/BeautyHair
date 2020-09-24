package beautyhair.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "gallery")
public class Picture {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	@Size(min = 10, max = 200, message = "Minimum 10, maximum 200 characters!")
	private String image;
	
	@Column
	private String date;
	
	@Column
	private boolean visible;
	
	@Column
	private boolean important;
	
	
	
	
	public Picture() {
		// TODO Auto-generated constructor stub
	}




	public Picture(String image, String date, boolean visible, boolean important) {
		super();
		this.image = image;
		this.date = date;
		this.visible = visible;
		this.important = important;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getImage() {
		return image;
	}




	public void setImage(String image) {
		this.image = image;
	}




	public String getDate() {
		return date;
	}




	public void setDate(String date) {
		this.date = date;
	}




	public boolean getVisible() {
		return visible;
	}




	public void setVisible(boolean visible) {
		this.visible = visible;
	}




	public boolean getImportant() {
		return important;
	}




	public void setImportant(boolean important) {
		this.important = important;
	}
	
	
	
	
	
	
	
	
	
	
	
}
