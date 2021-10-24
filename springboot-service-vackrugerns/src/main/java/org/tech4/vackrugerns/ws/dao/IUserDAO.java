package org.tech4.vackrugerns.ws.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tech4.vackrugerns.ws.model.User;

public interface IUserDAO extends JpaRepository<User, Integer> {

}
