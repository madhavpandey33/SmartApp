package com.mpandey.smart.app.service;

import java.util.List;

import com.mpandey.smart.app.objects.User;

public interface UserService
{
	public User findUserByEmail(String email);

	public void saveUser(User user);
	
	public List<User> getUsers();
	
	public void authenticateUser(User user);
}
