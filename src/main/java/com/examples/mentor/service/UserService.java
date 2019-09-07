package com.examples.mentor.service;




import java.util.List;

import com.examples.mentor.model.Users;

public interface UserService {

	public void insertUser(Users users);

	public Users findByemail(String email);

	public List<Users> getuserList();

	public void blockById(int userId);

	public void unblockById(int userId);

	
	

}
