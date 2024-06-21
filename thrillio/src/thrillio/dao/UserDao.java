package thrillio.dao;

import java.util.List;

import thrillio.DataStore;
import thrillio.entities.User;

public class UserDao {
	public List<User> getUsers() {
		return DataStore.getUsers();
	}

}
