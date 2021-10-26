package org.tech4.vackrugerns.ws.security.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.tech4.vackrugerns.ws.dao.IUserDAO;
import org.tech4.vackrugerns.ws.model.UserSystem;


@Component
public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher{

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationSuccessErrorHandler.class);
	
	@Autowired
	private IUserDAO iUserDAO;
	
	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		//UserDetails user = (UserDetails) authentication.getPrincipal();
		//String mensaje = "Success Login: " + user.getUsername();
		String mensaje = "Success Login: " + authentication.getPrincipal();
		System.out.println(mensaje);
		logger.info(mensaje);
	}

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) throws UsernameNotFoundException {
		String error = "user or password not valid";
		UserDetails user = null;
		try {
			UserSystem userSystem = iUserDAO.findOneByUsername(authentication.getName());
			
			throw new UsernameNotFoundException(error);
		} catch (Exception e) {
			logger.error(String.format("publishAuthenticationFailure:Exception - User %s not found", authentication.getName()));
			throw new UsernameNotFoundException(error);
		}
	}
	
}
