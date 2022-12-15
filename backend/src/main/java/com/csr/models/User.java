package com.hotelbooking.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(indexes = {@Index(columnList = "email", unique = true)})
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User implements Serializable {

	  
	  
	  public User() {
		}

	public User(
	      String username,
	      String password,
	      String firstName,
	      String lastName,
	      String email,
	      String role, String orgName) {
	    this.username = username;
	    this.password = password;
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.email = email;
	    this.role = role;
	    this.orgName = orgName;
	  }

	  @Id
	  @Column(length = 15)
	  @NotBlank(message = "username is mandatory")
	  private String username;

	  @Column
	  @NotBlank(message = "password is mandatory")
	  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	  private String password;

	  @Column(name = "first_name")
	  @NotBlank(message = "firstname is mandatory")
	  @Size(min = 1, max = 15)
	  private String firstName;

	  @Column(name = "last_name")
	  @NotBlank(message = "lastname is mandatory")
	  @Size(min = 1, max = 15)
	  private String lastName;

	  @Column(length = 32)
	  @NotBlank(message = "Email is mandatory")
	  @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Email should be of type someone@example.com")
	  private String email;

	  @Column(name = "role")
	  private String role;
	  
	  @Column(length = 128)
	  private String orgName;

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", role=" + role + ", orgName=" + orgName + "]";
	}
	  
	  
}
