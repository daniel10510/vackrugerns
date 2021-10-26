package org.tech4.vackrugerns.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tech4.vackrugerns.ws.dao.IUserDAO;
import org.tech4.vackrugerns.ws.dao.IUserVaccineDAO;
import org.tech4.vackrugerns.ws.dto.UserDTO;
import org.tech4.vackrugerns.ws.dto.UserVaccineDTO;
import org.tech4.vackrugerns.ws.model.UserSystem;
import org.tech4.vackrugerns.ws.service.IUserService;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private IUserDAO iUserDAO;
	
	@Autowired
	private IUserVaccineDAO uvDao;
	
	@Override
	public UserSystem create(UserSystem t) {
		// TODO Auto-generated method stub 
		return iUserDAO.save(t);
	}

	@Override
	public UserSystem update(UserSystem t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
	}

	@Override
	public UserSystem listById(int id) {
		// TODO Auto-generated method stub
		return iUserDAO.getOne(id);
	}

	@Override
	public List<UserSystem> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserSystem listByUsername(String username) {
		// TODO Auto-generated method stub
		return iUserDAO.findOneByUsername(username);
	}
	
	@Transactional
	@Override
	public UserDTO registrarTransaccional(UserVaccineDTO userVaccineDTO) {
		iUserDAO.save(userVaccineDTO.getUser());
		uvDao.registrar(userVaccineDTO.getUser().getIdUser(), userVaccineDTO.getVaccine().getId(), userVaccineDTO.getDateVaccine(), userVaccineDTO.getNumDosis());
		
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
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info(username);
		
		UserSystem user = iUserDAO.findOneByUsername(username); //from usuario where username := username
		
		if (user == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", username));
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		user.getRols().forEach( role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});
		
		UserDetails userDetails = new User(user.getUsername(), user.getPassword(), authorities);
		
		return userDetails;
		
	}

}
