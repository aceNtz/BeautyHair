package beautyhair.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table
public class Company {

	@Transient
	private static Company instance;
	
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	@Size(min = 3, max = 45, message = "Minimum 3, maximum 45 characters!")
	private String name;

	@Column
	private String logo;

	@Column
	@Size(min = 3, max = 45, message = "Minimum 3, maximum 45 characters!")
	private String city;

	@Column
	@Size(min = 3, max = 45, message = "Minimum 3, maximum 45 characters!")
	private String adress;

	@Column
	private String zipCode;

	@Column
	private String workTime;
	
	@Column
	@Email
	private String email;

	@Column
	private String phoneOne;

	@Column
	private String phoneTwo;

	@Column
	private String facebook;

	@Column
	private String twitter;

	@Column
	private String instagram;
	
	@Column
	private String catalogue;
	
	@Column
	@Size(min = 10, max = 200, message = "Minimum 10, maximum 200 characters!")
	private String shortDescription;
	
	@Column 
	@Size(min = 20, max = 1000, message = "Minimum 20, maximum 1000 characters!")
	private String longDescription;
	
	
	
	
	private Company() {
		
	}
	
	
	
	
	
	
	
	
	// Geteri i seteri
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









	public String getLogo() {
		return logo;
	}









	public void setLogo(String logo) {
		this.logo = logo;
	}









	public String getCity() {
		return city;
	}









	public void setCity(String city) {
		this.city = city;
	}









	public String getAdress() {
		return adress;
	}









	public void setAdress(String adress) {
		this.adress = adress;
	}









	public String getZipCode() {
		return zipCode;
	}









	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}









	public String getEmail() {
		return email;
	}









	public void setEmail(String email) {
		this.email = email;
	}









	public String getPhoneOne() {
		return phoneOne;
	}









	public void setPhoneOne(String phoneOne) {
		this.phoneOne = phoneOne;
	}









	public String getPhoneTwo() {
		return phoneTwo;
	}









	public void setPhoneTwo(String phoneTwo) {
		this.phoneTwo = phoneTwo;
	}









	public String getFacebook() {
		return facebook;
	}









	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}









	public String getTwitter() {
		return twitter;
	}









	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}









	public String getCatalogue() {
		return catalogue;
	}









	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}









	public String getInstagram() {
		return instagram;
	}









	public void setInstagram(String instagram) {
		this.instagram = instagram;
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
	








	public String getWorkTime() {
		return workTime;
	}








	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}








	// Singltone
	public static Company getCompanyInfo() {
		if(instance == null) {
			return new Company();
		}
		
		return instance;
	}
	
}
