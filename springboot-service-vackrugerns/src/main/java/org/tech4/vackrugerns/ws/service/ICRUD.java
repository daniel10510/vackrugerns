package org.tech4.vackrugerns.ws.service;

import java.util.List;

public interface ICRUD<T> {

	T create(T t);

	T update(T t);

	void delete(int id);

	T listById(int id);

	List<T> list();
}
