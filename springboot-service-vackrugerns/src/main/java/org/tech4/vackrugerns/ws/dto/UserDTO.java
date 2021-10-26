package org.tech4.vackrugerns.ws.dto;

public class UserDTO {

	private String docNumber;
	private String name;
	private String lastName;
	private String email;
	private String dateOfBirth;
	private String address;
	private String phone;
	private boolean stateVaccine;

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
	public String toString() {
		return "UserDTO [docNumber=" + docNumber + ", name=" + name + ", lastName=" + lastName + ", email=" + email
				+ ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", phone=" + phone + ", stateVaccine="
				+ stateVaccine + "]";
	}

}
