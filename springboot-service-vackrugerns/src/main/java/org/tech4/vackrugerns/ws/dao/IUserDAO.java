package org.tech4.vackrugerns.ws.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tech4.vackrugerns.ws.dto.UserVaccineDTO;
import org.tech4.vackrugerns.ws.model.User;

public interface IUserDAO extends JpaRepository<User, Integer> {
	User findByUserName(String username);
	//User registrarTransaccional(UserVaccineDTO userVaccineDTO);
}
