package hr.dumanic.tonci.bwpa.dao;

import java.util.List;

import hr.dumanic.tonci.bwpa.DataStore;
import hr.dumanic.tonci.bwpa.entities.User;

public class UserDao {
	
	public List<User> getUser() {
		return DataStore.getUsers();
	}
	

}
