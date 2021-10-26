package org.tech4.vackrugerns.ws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(UserVaccinePK.class)
public class UserVaccine {

	@Id
	private Vaccine vaccine;

	@Id
	private UserSystem user;
	
	@Column(name = "date_vaccine", length = 30)
	private String dateVaccine;
	
	@Id
	@Column(name = "num_dosis", length = 5)
	private String numDosis;

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public UserSystem getUser() {
		return user;
	}

	public void setUser(UserSystem user) {
		this.user = user;
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
		return "UserVaccine [vaccine=" + vaccine + ", user=" + user + ", dateVaccine=" + dateVaccine + ", numDosis="
				+ numDosis + "]";
	}  

}
