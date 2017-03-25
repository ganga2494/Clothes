package rebel.web.dao;

import java.util.List;

import rebel.web.model.UserDetails;

public interface UserDetailsDao {

	
	public  void addUser(UserDetails ud);
	
	public  UserDetails updateUser(String uid,UserDetails ud);
	
	public  void deleteUser(String uid);
	
	public  UserDetails getUserById(String uid);
	
	public  List<UserDetails> getUsers();
	
	public  UserDetails logincheck(UserDetails ud);
	
	public  UserDetails registerUser(UserDetails ud);
	
	public  UserDetails updateUser1(UserDetails ud);
	

	

}
