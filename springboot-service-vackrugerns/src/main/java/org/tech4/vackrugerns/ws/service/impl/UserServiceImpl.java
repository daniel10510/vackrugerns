package org.tech4.vackrugerns.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tech4.vackrugerns.ws.dao.IUserDAO;
import org.tech4.vackrugerns.ws.dao.IUserVaccineDAO;
import org.tech4.vackrugerns.ws.dto.UserDTO;
import org.tech4.vackrugerns.ws.dto.UserVaccineDTO;
import org.tech4.vackrugerns.ws.model.User;
import org.tech4.vackrugerns.ws.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDAO iUserDAO;
	
	@Autowired
	private IUserVaccineDAO uvDao;
	
	@Override
	public User create(User t) {
		// TODO Auto-generated method stub 
		return iUserDAO.save(t);
	}

	@Override
	public User update(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
	}

	@Override
	public User listById(int id) {
		// TODO Auto-generated method stub
		return iUserDAO.getById(id);
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User listByUsername(String username) {
		// TODO Auto-generated method stub
		return iUserDAO.findByUserName(username);
	}
	
	@Transactional
	@Override
	public UserDTO registrarTransaccional(UserVaccineDTO userVaccineDTO) {
		iUserDAO.save(userVaccineDTO.getUser());
		uvDao.registrar(userVaccineDTO.getUser().getId(), userVaccineDTO.getVaccine().getId(), userVaccineDTO.getDateVaccine(), userVaccineDTO.getNumDosis());
		
		UserDTO userDTO = new UserDTO();
		userDTO.setAddress(userVaccineDTO.getUser().getAddress());
		userDTO.setDateOfBirth(userVaccineDTO.getUser().getDateOfBirth());
		userDTO.setDocNumber(userVaccineDTO.getUser().getDocNumber());
		userDTO.setEmail(userVaccineDTO.getUser().getEmail());
		userDTO.setLastName(userVaccineDTO.getUser().getLastName());
		userDTO.setName(userVaccineDTO.getUser().getName());
		userDTO.setPhone(userVaccineDTO.getUser().getName());
		userDTO.setStateVaccine(userVaccineDTO.getUser().isStateVaccine());

		return userDTO;
	}

}
