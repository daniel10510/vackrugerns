package org.tech4.vackrugerns.ws.service;

import org.tech4.vackrugerns.ws.dto.UserDTO;
import org.tech4.vackrugerns.ws.dto.UserVaccineDTO;
import org.tech4.vackrugerns.ws.model.UserSystem;

public interface IUserService extends ICRUD<UserSystem> {
	UserSystem listByUsername(String username);
	UserDTO registrarTransaccional(UserVaccineDTO userVaccineDTO);
}
