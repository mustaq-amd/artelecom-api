package com.ar.service;

import com.ar.dto.UserModel;
import com.ar.entity.ARUser;

public interface UserService {

	public ARUser createUser(UserModel user);

	public ARUser readUser();

	public ARUser updateUser(UserModel user);

	public void deleteUser();

	public ARUser getLoggedInUser();

}
