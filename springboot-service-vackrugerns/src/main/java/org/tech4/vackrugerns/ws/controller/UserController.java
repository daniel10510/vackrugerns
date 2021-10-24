package org.tech4.vackrugerns.ws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tech4.vackrugerns.ws.model.User;
import org.tech4.vackrugerns.ws.model.UserDTO;
import org.tech4.vackrugerns.ws.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService iUserService;

	@PostMapping(produces = "application/json", consumes = "application/json")
	public UserDTO create(@RequestBody User user) {
		logger.info(user.toString());
		User userResp = new User(); 
		userResp = iUserService.create(user);
		
		UserDTO userDTO = new UserDTO();
		userDTO.setAddress(userResp.getAddress());
		userDTO.setDateOfBirth(userResp.getDateOfBirth());
		userDTO.setDocNumber(userResp.getDocNumber());
		userDTO.setEmail(userResp.getEmail());
		userDTO.setLastName(userResp.getLastName());
		userDTO.setName(userResp.getName());
		userDTO.setPhone(userResp.getPhone());
		userDTO.setUserName(userResp.getUserName());
		return userDTO;
	}
	
	@GetMapping(value = "/", produces = "application/json")
	public String obtener() {
		return "get user";
	}
}