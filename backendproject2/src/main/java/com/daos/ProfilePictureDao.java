package com.daos;

import com.models.ProfilePicture;

public interface ProfilePictureDao {

	void uploadProfilePicture(ProfilePicture profilePicture);

	ProfilePicture getImage(String email);
}



