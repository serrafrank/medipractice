package org.medipractice.authserver.business;

import org.medipractice.authserver.model.User;

import java.util.List;

public interface UserBusiness {
	User getById(Integer id);

	List<User> findAll();

	void update(User update);

	User save(User update);

	void delete(Integer id);
	User getByUsername(String username);
}
