package com.daos;

import java.util.List;

import com.models.Friend;
import com.models.User;

public interface FriendDao {
	List<User> suggestedUsers(String email);

	void addFriend(Friend friend);
	
	List<Friend> pendingRequests(String toIdEmail);

	void acceptRequest(Friend request);

	void deleteRequest(Friend request);
	
	List<Friend> listOfFriends(String email);


}

