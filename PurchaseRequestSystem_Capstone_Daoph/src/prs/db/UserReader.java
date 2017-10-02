package prs.db;

import java.util.ArrayList;

import prs.business.User;

public interface UserReader {
	
	public ArrayList<User> getAllUsers();
	
	public String loginValidator(String username, String password);
	
	public User getUserObject(String username);

}
