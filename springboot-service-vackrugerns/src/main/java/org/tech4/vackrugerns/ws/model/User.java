package org.tech4.vackrugerns.ws.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable{

	private static final long serialVersionUID = -846672610153165866L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "doc_number", nullable = false, length = 30)
	private String docNumber;
	
	@Column(name = "names", nullable = false, length = 50)
	private String name;

	@Column(name = "last_name", nullable = false, length = 200)
	private String lastName;
	
	@Column(name = "email", nullable = false, length = 150)
	private String email;
	
	@Column(name="user_name", unique = true, length = 50)
	private String userName;
	
	@Column(length = 100)
	private String password;
	
	@Column(name="date_birth", length = 100)
	private String dateOfBirth;
	
	@Column(name="address", length = 100)
	private String address;
	
	@Column(name="phone", length = 100)
	private String phone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", docNumber=" + docNumber + ", name=" + name + ", lastName=" + lastName + ", email="
				+ email + ", userName=" + userName + ", password=" + password + ", dateOfBirth=" + dateOfBirth
				+ ", address=" + address + ", phone=" + phone + "]";
	}
	
}
