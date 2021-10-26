package org.tech4.vackrugerns.ws.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tech4.vackrugerns.ws.dto.UserVaccineDTO;
import org.tech4.vackrugerns.ws.model.UserSystem;

public interface IUserDAO extends JpaRepository<UserSystem, Integer> {
	UserSystem findOneByUsername(String username);
	//User registrarTransaccional(UserVaccineDTO userVaccineDTO);
}
