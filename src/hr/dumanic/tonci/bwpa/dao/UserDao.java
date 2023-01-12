package hr.dumanic.tonci.bwpa.dao;

import hr.dumanic.tonci.bwpa.DataStore;
import hr.dumanic.tonci.bwpa.entities.User;

public class UserDao {
	
	public User[] getUser() {
		return DataStore.getUsers();
	}
	

}
