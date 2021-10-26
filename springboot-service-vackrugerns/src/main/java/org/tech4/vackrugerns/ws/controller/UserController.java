package org.tech4.vackrugerns.ws.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.tech4.vackrugerns.ws.dto.UserDTO;
import org.tech4.vackrugerns.ws.dto.UserVaccineDTO;
import org.tech4.vackrugerns.ws.model.Mail;
import org.tech4.vackrugerns.ws.model.User;
import org.springframework.http.HttpStatus;
import org.tech4.vackrugerns.ws.service.IUserService;
import org.tech4.vackrugerns.ws.util.Constant;
import org.tech4.vackrugerns.ws.util.EmailService;
import org.tech4.vackrugerns.ws.util.SecurityPassword;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private EmailService emailService;
	
	@Value("${spring.mail.username}")
	private String mailServerHost;
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public UserDTO listById(@PathVariable("id") Integer id) {
		logger.info(String.valueOf(id));	
		User user = new User(); 
		user = iUserService.listById(id);
		
		UserDTO userDTO = new UserDTO();
		userDTO.setDocNumber(user.getDocNumber());
		userDTO.setName(user.getName());
		userDTO.setLastName(user.getLastName());
		userDTO.setEmail(user.getEmail());
		userDTO.setAddress(user.getAddress());
		userDTO.setDateOfBirth(user.getDateOfBirth());
		userDTO.setPhone(user.getPhone());
		userDTO.setStateVaccine(user.isStateVaccine());
		
		return userDTO;
	}

	@PostMapping(produces = "application/json", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public UserDTO create(@RequestBody User user) {
		logger.info(user.toString());		
		
		user.setUserName(user.getDocNumber());
		user.setPassword(SecurityPassword.generateSecureRandomPassword());
		
		User userResp = new User(); 
		userResp = iUserService.create(user);
		
		UserDTO userDTO = new UserDTO();
		userDTO.setDocNumber(userResp.getDocNumber());
		userDTO.setName(userResp.getName());
		userDTO.setLastName(userResp.getLastName());
		userDTO.setEmail(userResp.getEmail());
		
		Map<String, Object> model = new HashMap<>();
		model.put("userName", user.getDocNumber());
		model.put("password", user.getPassword());
		Mail mail = emailService.prepMailWithBody(mailServerHost, user.getEmail(),
				Constant.SUBJECT_EMAIL_BIENVENIDA, model);
		//emailService.sendEmailCodVerif(mail);
		
		return userDTO;
	}
	
	@PutMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
	public UserDTO registrar(@PathVariable Integer id, @RequestBody UserVaccineDTO userVaccineDTO) {
		logger.info(userVaccineDTO.toString());
		User user = new User(); 
		user = iUserService.listById(id);
		user.setDateOfBirth(userVaccineDTO.getUser().getDateOfBirth());
		user.setAddress(userVaccineDTO.getUser().getAddress());
		user.setPhone(userVaccineDTO.getUser().getPhone());
		user.setStateVaccine(userVaccineDTO.getUser().isStateVaccine());
		
		userVaccineDTO.setUser(user);
		
		return iUserService.registrarTransaccional(userVaccineDTO);
	}
	
}