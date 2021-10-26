package org.tech4.vackrugerns.ws.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class UserVaccinePK implements Serializable{

	@ManyToOne
	@JoinColumn(name = "idVaccine", nullable = false)
	private Vaccine vaccine;
	
	@ManyToOne
	@JoinColumn(name = "idUser", nullable = false)
	private UserSystem user;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((vaccine == null) ? 0 : vaccine.hashCode());
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
		UserVaccinePK other = (UserVaccinePK) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (vaccine == null) {
			if (other.vaccine != null)
				return false;
		} else if (!vaccine.equals(other.vaccine))
			return false;
		return true;
	}
	
	
}
