package org.tech4.vackrugerns.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tech4.vackrugerns.ws.dao.IUserDAO;
import org.tech4.vackrugerns.ws.model.User;
import org.tech4.vackrugerns.ws.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDAO iUserDAO;
	
	@Override
	public User create(User t) {
		// TODO Auto-generated method stub 
		iUserDAO.save(t);
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
		return null;
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
