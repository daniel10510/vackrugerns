package org.tech4.vackrugerns.ws.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vaccine")
public class Vaccine implements Serializable{
	
	private static final long serialVersionUID = -6473375700897752714L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVaccine;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	public int getId() {
		return idVaccine;
	}

	public void setIdVaccine(int idVaccine) {
		this.idVaccine = idVaccine;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Vaccine [idVaccine=" + idVaccine + ", name=" + name + "]";
	}

}