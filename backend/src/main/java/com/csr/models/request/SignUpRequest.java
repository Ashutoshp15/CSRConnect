package com.hotelbooking.models.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

	  @NotBlank(message = "Username is mandatory. 8-15 characters")
	  @Size(min = 8, max = 15, message = "Username must be between 8-15 characters")
	  private String username;

	  @NotBlank(message = "Password is mandatory. ")
	  @Size(min = 8, max = 15, message = "Password must be between 8-15 characters")
	  private String password;

	  @NotBlank(message = "First name is mandatory.")
	  private String firstName;

	  @NotBlank(message = "Lastname is mandatory.")
	  private String lastName;

	  @NotBlank(message = "Email is mandatory.")
	  @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE, message = "someone@example.com")
	  private String email;

	  private String role;
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
		return "SignUpRequest [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email  + ", role=" + role + ", orgName=" + orgName + "]";
	}


	  
	  
}
