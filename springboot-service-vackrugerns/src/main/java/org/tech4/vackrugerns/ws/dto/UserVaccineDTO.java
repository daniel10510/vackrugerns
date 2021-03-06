package org.tech4.vackrugerns.ws.dto;

import org.tech4.vackrugerns.ws.model.UserSystem;
import org.tech4.vackrugerns.ws.model.Vaccine;

public class UserVaccineDTO {

	private UserSystem user;
	private Vaccine vaccine;
	private String dateVaccine;
	private String numDosis;

	public UserSystem getUser() {
		return user;
	}

	public void setUser(UserSystem user) {
		this.user = user;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public String getDateVaccine() {
		return dateVaccine;
	}

	public void setDateVaccine(String dateVaccine) {
		this.dateVaccine = dateVaccine;
	}

	public String getNumDosis() {
		return numDosis;
	}

	public void setNumDosis(String numDosis) {
		this.numDosis = numDosis;
	}

	@Override
	public String toString() {
		return "UserVaccineDTO [user=" + user + ", vaccine=" + vaccine + ", dateVaccine=" + dateVaccine + ", numDosis="
				+ numDosis + "]";
	}

}
