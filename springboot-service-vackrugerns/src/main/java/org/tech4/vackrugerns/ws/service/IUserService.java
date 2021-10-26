package org.tech4.vackrugerns.ws.service;

import org.tech4.vackrugerns.ws.dto.UserDTO;
import org.tech4.vackrugerns.ws.dto.UserVaccineDTO;
import org.tech4.vackrugerns.ws.model.User;

public interface IUserService extends ICRUD<User> {
	User listByUsername(String username);
	UserDTO registrarTransaccional(UserVaccineDTO userVaccineDTO);
}
