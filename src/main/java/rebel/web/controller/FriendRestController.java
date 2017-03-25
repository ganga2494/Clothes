package rebel.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rebel.web.dao.FriendDAO;
import rebel.web.dao.UserDetailsDao;
import rebel.web.model.Friend;
import rebel.web.model.UserDetails;

@RestController
public class FriendRestController {
	
	@Autowired
	FriendDAO friendDAO;
	
	@Autowired
	UserDetailsDao userDAO;
	
	//@GetMapping(value = "/addFriend/{friendID}")
	@RequestMapping(value="/addFriend/{friendID}", method=RequestMethod.POST)
	public ResponseEntity<Friend> sendFriendRequest(@PathVariable("friendID") String friendID,HttpSession session) {
		
		//String loggedInUserId = (String)session.getAttribute("loggedInUserId");
		UserDetails currentUser =  (UserDetails)session.getAttribute("user");
		Friend friend=new Friend();
		friend.setUser(currentUser);
		friend.setFriend(userDAO.getUserById(friendID));
		friend.setStatus("New");
		friend.setOnline(false);
		
		friendDAO.addFriend(friend);
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);

	}
	
	//@GetMapping(value = "/myFriends")
	@RequestMapping(value="/myFriends", method=RequestMethod.GET)
	public ResponseEntity<List<Friend>> getMyFriends(HttpSession session) {
		
		 String loggedInUserId = (String)session.getAttribute("loggedInUserId");

		 loggedInUserId="'"+loggedInUserId+"'";
		List<Friend> myFriends = friendDAO.listMyFriends(loggedInUserId);

		if (myFriends.isEmpty()) {
			return new ResponseEntity<List<Friend>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Friend>>(myFriends, HttpStatus.OK);
	}
	
	//@GetMapping(value = "/acceptFriend/{friendId}")
	@RequestMapping(value="/acceptFriend/{friendId}", method=RequestMethod.GET)
	public ResponseEntity<Friend> acceptFriendFriendRequest(@PathVariable("friendId") String friendId,HttpSession session) {
		String loggedInUserId = (String)session.getAttribute("loggedInUserId");
		loggedInUserId="'"+loggedInUserId+"'";
		friendId="'"+friendId+"'";
		Friend friend=friendDAO.getFriend(loggedInUserId, friendId);
		Friend friend2=friendDAO.getFriend(friendId,loggedInUserId);
		friend.setStatus("Accepted");
		friend2.setStatus("Accepted");
		friendDAO.updateFriend(friend);
		friendDAO.updateFriend(friend2);

		return new ResponseEntity<Friend>(friend, HttpStatus.OK);

	}
	
	//@GetMapping(value = "/rejectFriend/{friendId}")
	@RequestMapping(value="/rejectFriend/{friendId}", method=RequestMethod.GET)
	public ResponseEntity<Friend> rejectFriendFriendRequest(@PathVariable("friendId") String friendId,HttpSession session) {
		String loggedInUserId = (String)session.getAttribute("loggedInUserId");
		loggedInUserId="'"+loggedInUserId+"'";
		friendId="'"+friendId+"'";
		Friend friend=friendDAO.getFriend(loggedInUserId, friendId);
		Friend friend2=friendDAO.getFriend(friendId,loggedInUserId);
		friend.setStatus("Rejected");
		friend2.setStatus("Rejected");
		friendDAO.updateFriend(friend);
		friendDAO.updateFriend(friend2);

		return new ResponseEntity<Friend>(friend, HttpStatus.OK);

	}
	
	//@GetMapping(value = "/getMyFriendRequests/")
	@RequestMapping(value="/getMyFriendRequests/", method=RequestMethod.GET)
	public ResponseEntity<List<Friend>> getMyFriendRequests(HttpSession session) {
		
		String loggedInUserId = (String)session.getAttribute("loggedInUserId");
		loggedInUserId="'"+loggedInUserId+"'";
		List<Friend> myFriendRequests = friendDAO.listNewFriendRequests(loggedInUserId);
		return new ResponseEntity<List<Friend>>(myFriendRequests, HttpStatus.OK);

	}
	
	
}

	


