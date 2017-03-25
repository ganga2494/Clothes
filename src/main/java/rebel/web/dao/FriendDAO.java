package rebel.web.dao;

import java.util.List;

import rebel.web.model.Friend;

public interface FriendDAO {
	
	public void addFriend(Friend friend);
	public void updateFriend(Friend friend);
	public void deleteFriend(long id);
	public Friend getFriend(String userId, String friendId);
	public List<Friend> listMyFriends(String userId);
	public List<Friend> listNewFriendRequests(String userId);
	public void setOnline(String userId);
	public void setOffline(String userId);

}
