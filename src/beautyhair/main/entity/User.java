package beautyhair.main.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")
public class User {


	@Id
	@Column
	@Size(min = 3, max = 45, message = "Minimum 3, maximum 45 characters!")
	private String username;

	@Column
	@Size(min = 6, max = 68, message = "Minimum 6, maximum 68 characters!")
	private String password;

	@Column
	@Size(min = 3, max = 45, message = "Minimum 3, maximum 45 characters!")
	private String name;

	@Column
	@Size(min = 3, max = 45, message = "Minimum 3, maximum 45 characters!")
	private String surname;

	@Column
	@Email
	private String email;

	@Column
	@Size(min = 3, max = 45, message = "Minimum 3, maximum 45 characters!")
	private String phone;
	
	@Column
	private String image;

	@Column
	private String dateJoined;
	
	@Column
	@Size(min = 20, max = 200, message = "Minimum 20, maximum 200 characters!")
	private String about;
	
	@Column
	private boolean enabled;

	@JoinTable(name = "authorities", joinColumns = @JoinColumn(name= "username"), inverseJoinColumns = @JoinColumn(name="authority"))
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	private List<Role> authorities;
	
	
	
	
	
	public User() {
		
	}
	


	public User(String username, String password, String name, String surname, String email, String phone,
			String dateJoined, String image, boolean enabled, List<Role> authorities) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.dateJoined = dateJoined;
		this.enabled = enabled;
		this.image = image;
		this.authorities = authorities;
	}












	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getAbout() {
		return about;
	}
	
	public void setAbout(String about) {
		this.about = about;
	}

	
	public String getImage() {
		return image;
	}
	
	
	public void setImage(String image) {
		this.image = image;
	}

	
	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getDateJoined() {
		return dateJoined;
	}


	public void setDateJoined(String dateJoined) {
		this.dateJoined = dateJoined;
	}


	public List<Role> getAuthorities() {
		return authorities;
	}


	public void setAuthorities(List<Role> authorities) {
		this.authorities = authorities;
	}
	
	
	
	
}
