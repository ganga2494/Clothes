package rebel.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import rebel.web.model.Friend;
import rebel.web.model.UserDetails;

@Repository
@EnableTransactionManagement
@Transactional
public class FriendDAOImpl implements FriendDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserDetailsDao userDAO;
	
	public void addFriend(Friend friend) {
		Session session=sessionFactory.getCurrentSession();
		Friend friend2=new Friend();
		friend2.setUser(friend.getFriend());
		friend2.setFriend(friend.getUser());
		friend2.setOnline(false);
		friend2.setStatus("New");
		session.saveOrUpdate(friend);
		session.saveOrUpdate(friend2);
		
	}

	public void updateFriend(Friend friend) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(friend);
		
	}

	public void deleteFriend(long id) {
		Session session=sessionFactory.getCurrentSession();
		Friend friend=(Friend)session.createQuery("from Friend where id="+id).getSingleResult();
		session.delete(friend);
		
	}

	public Friend getFriend(String userId, String friendId) {
		Session session=sessionFactory.getCurrentSession();
		
		//UserDetails user=userDAO.getUserById(userId);
		//UserDetails friendUser=userDAO.getUserById(friendId);
		Friend friend=(Friend)session.createQuery("from Friend where userId="+userId+" and friendId="+friendId).getSingleResult();
		return friend;
	}

	public List<Friend> listMyFriends(String userId) {
		Session session=sessionFactory.getCurrentSession();
		UserDetails user=userDAO.getUserById(userId);
		List<Friend> friends=session.createQuery("from Friend where userId="+userId+" and status='Accepted'").getResultList();
		return friends;
	}

	@SuppressWarnings("unchecked")
	public List<Friend> listNewFriendRequests(String userId) {
		Session session=sessionFactory.getCurrentSession();
		//UserDetails user=userDAO.getUserById(userId);
		List<Friend> friends=session.createQuery("from Friend where friendId="+userId+" and status='New'").getResultList();
		return friends;
	}

	public void setOnline(String userId) {
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("update Friend set isOnline=true where friendId="+userId).executeUpdate();
		
	}

	public void setOffline(String userId) {
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("update Friend set isOnline=false where friendId="+userId).executeUpdate();
		
	}
	
	

}
