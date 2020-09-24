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
public class Category {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	@Size(min = 3, max = 45, message = "Minimum 3, maximum 45 characters!")
	private String name;
	
	@Column
	private String date;
	
	@Column
	@Size(min = 8, max = 100, message = "Minimum 8, maximum 100 characters!")
	private String description;
	
	@Column
	private int timesUsed;
	
	@Column
	private boolean important;
	
	
	
	public Category() {
		// TODO Auto-generated constructor stub
	}



	
	public Category(String name, String date, String description, int timesUsed, boolean important) {
		super();
		this.name = name;
		this.date = date;
		this.description = description;
		this.timesUsed = timesUsed;
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




	public String getDate() {
		return date;
	}




	public void setDate(String date) {
		this.date = date;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public int getTimesUsed() {
		return timesUsed;
	}




	public void setTimesUsed(int timesUsed) {
		this.timesUsed = timesUsed;
	}




	public boolean getImportant() {
		return important;
	}




	public void setImportant(boolean important) {
		this.important = important;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

