package beautyhair.main.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
@Table
public class BlogPost {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	@Size(min = 6, max = 100, message ="Minimum 6, maximum 100 characters!")
	private String name;

	@Column
	@Size(min = 50, max = 600, message ="Minimum 50, maximum 600 characters!")
	private String shortDescription;

	@Column
	@Size(min = 100, max = 1200, message ="Minimum 100, maximum 1200 characters!")
	private String longDescription;

	@Column
	@Size(min = 1000, max = 14000, message ="Minimum 1000, maximum 14000 characters!")
	private String blogText;

	@Column
	private String date;

	@Column
	@Size(min = 6, max = 100, message ="Minimum 6, maximum 100 characters!")
	private String image;

	@Column
	private int viewCount;

	@JoinColumn(name = "category")
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Category category;

	@JoinColumn(name = "author")
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private User author;

	@Column
	private boolean enabled;

	@Column
	private boolean important;
	
	@Transient
	private String dateOptionOne;
	
	@Transient
	private String dateOptionTwo;
	
	
	
	public BlogPost() {
		// TODO Auto-generated constructor stub
	}




	public BlogPost(String name, String shortDescription, String longDescription, String blogText, String date,
			String image, int viewCount, Category category, User author, boolean enabled, boolean important) {
		super();
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.blogText = blogText;
		this.date = date;
		this.image = image;
		this.viewCount = viewCount;
		this.category = category;
		this.author = author;
		this.enabled = enabled;
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




	public String getShortDescription() {
		return shortDescription;
	}




	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}




	public String getLongDescription() {
		return longDescription;
	}




	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}




	public String getBlogText() {
		return blogText;
	}




	public void setBlogText(String blogText) {
		this.blogText = blogText;
	}




	public String getDate() {
		return date;
	}




	public void setDate(String date) {
		this.date = date;
	}




	public String getImage() {
		return image;
	}




	public void setImage(String image) {
		this.image = image;
	}




	public int getViewCount() {
		return viewCount;
	}




	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}




	public Category getCategory() {
		return category;
	}




	public void setCategory(Category category) {
		this.category = category;
	}




	public User getAuthor() {
		return author;
	}




	public void setAuthor(User author) {
		this.author = author;
	}




	public boolean getEnabled() {
		return enabled;
	}




	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}




	public boolean getImportant() {
		return important;
	}




	public void setImportant(boolean important) {
		this.important = important;
	}




	public String getDateOptionOne() {
		return dateOptionOne;
	}




	public void setDateOptionOne(String dateOptionOne) {
		this.dateOptionOne = dateOptionOne;
	}




	public String getDateOptionTwo() {
		return dateOptionTwo;
	}




	public void setDateOptionTwo(String dateOptionTwo) {
		this.dateOptionTwo = dateOptionTwo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
