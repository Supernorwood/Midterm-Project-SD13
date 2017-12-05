package data;

import java.util.List;

import entities.Address;
import entities.Login;
import entities.User;

public interface UserDAO {

		//create user
		public User createUser(NewUserDTO dto);
		
		//read user
		public List<User> getAllUsers();
		public User getUserById(int id);
		public User userLogin(String userEmail, String userPass);
		
		//update user
		public User updateUser(User user);
		
		//delete user
		public boolean deleteUser(User user);
		
		
		
	
}
