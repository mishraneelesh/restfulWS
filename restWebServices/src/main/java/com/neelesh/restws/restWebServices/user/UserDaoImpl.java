package com.neelesh.restws.restWebServices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl {

	private static int usercount = 3;
	private static List<UserBean> users = new ArrayList<>();
	
	static {
		users.add(new UserBean(1,"Neelesh", new Date()));
		users.add(new UserBean(2,"Neelesh1", new Date()));
		users.add(new UserBean(3,"Neelesh2", new Date()));
	}
	
	public List<UserBean> findAll(){
		return users;
	}
	
	public UserBean save(UserBean user) {
		if(user.getId() == null) {
			user.setId(++usercount);
		}
		users.add(user);
		System.out.println("Deatils saved: ");
		return user;
	}
	
	public UserBean findone(int id) {
		for(UserBean ub : users) {
			if(ub.getId() == id) {
				return ub;
			}
		}
		return null;
	}
	public UserBean userDeleteById(int id) {
		Iterator<UserBean> iterator = users.iterator();
		while(iterator.hasNext()) {
			UserBean ub = iterator.next();
			if(ub.getId() == id) {
				iterator.remove();
				return ub;
			}
		}
		return null;
	}
}
