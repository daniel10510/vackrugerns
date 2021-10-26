package org.tech4.vackrugerns.ws.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;

	@NotNull(message = "Document number should not be null")
	@NotEmpty(message = "Document number should not be empty")
	@Digits(message = "Document number, is not number.", fraction = 0, integer = 10)
	@Size(min = 10, message = "Name should have atleast 10 characters")
	@Column(name = "doc_number", nullable = false, length = 30, unique = true)
	private String docNumber;

	@NotNull(message = "Name should not be null")
	@NotEmpty(message = "Name should not be empty")
	@Pattern(regexp = "^[A-Za-z]*$", message = "Name must not contain numbers and special characters")
	@Column(name = "names", nullable = false, length = 50)
	private String name;

	@NotNull(message = "Last name should not be null")
	@NotEmpty(message = "Last name should not be empty")
	@Pattern(regexp = "^[A-Za-z]*$", message = "Last name must not contain numbers and special characters")
	@Column(name = "last_name", nullable = false, length = 200)
	private String lastName;

	@NotNull(message = "Email should not be null")
	@NotEmpty(message = "Email should not be empty")
	@Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@Column(name = "email", nullable = false, length = 150)
	private String email;

	@Column(name = "user_name", unique = true, length = 50)
	private String userName;

	@Column(length = 100)
	private String password;

	@Column(name = "date_birth", length = 100)
	private String dateOfBirth;

	@Column(name = "address", length = 100)
	private String address;

	@Column(name = "phone", length = 100)
	private String phone;

	@Column(name = "state_vaccine", nullable = false)
	private boolean stateVaccine;

	public int getId() {
		return idUser;
	}

	public void setId(int id) {
		this.idUser = id;
	}

	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isStateVaccine() {
		return stateVaccine;
	}

	public void setStateVaccine(boolean stateVaccine) {
		this.stateVaccine = stateVaccine;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUser;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", docNumber=" + docNumber + ", name=" + name + ", lastName=" + lastName + ", email="
				+ email + ", userName=" + userName + ", password=" + password + ", dateOfBirth=" + dateOfBirth
				+ ", address=" + address + ", phone=" + phone + ", stateVaccine=" + stateVaccine + "]";
	}

}
