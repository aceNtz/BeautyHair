package beautyhair.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table
public class Partner {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	@Size(min = 2, max = 100, message = "Minimum 2, maximum 100 characters!")
	private String name;
	
	@Column
	private String link;
	
	@Column
	private String image;
	
	@Column
	private boolean important;
	
	
	
	
	public Partner() {
		// TODO Auto-generated constructor stub
	}




	public Partner(String name, String link, String image, boolean important) {
		super();
		this.name = name;
		this.link = link;
		this.image = image;
		this.important = important;
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




	public String getLink() {
		return link;
	}




	public void setLink(String link) {
		this.link = link;
	}




	public String getImage() {
		return image;
	}




	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
	
	public boolean getImportant() {
		return important;
	}




	public void setImportant(Boolean important) {
		this.important = important;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
