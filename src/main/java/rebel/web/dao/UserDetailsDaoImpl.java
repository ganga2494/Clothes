package rebel.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import rebel.web.model.UserDetails;


@Repository("UserDetails")
@EnableTransactionManagement
@Transactional
public class UserDetailsDaoImpl implements UserDetailsDao {
	@Autowired
	SessionFactory sessionFactory;

	
	public void addUser(UserDetails ud) {
		Session ses = sessionFactory.openSession();
		Transaction tr = ses.beginTransaction();
		ud.setUserid(generateUserId());
		ses.save(ud);
		tr.commit();
		ses.close();
		
	}

	
	public UserDetails updateUser(String uid, UserDetails ud) {
		Session ses = sessionFactory.openSession();
		UserDetails presud = (UserDetails)ses.get(UserDetails.class, uid);
		if(presud==null)
			return null;
		
		//ud = (UserDetails)ses.get(UserDetails.class, ud.getUserid());
		presud=ud;
		//ses.update(presud);
		ses.flush();
		//ses.close();
		return ud;
		
	}
	


	public void deleteUser(String uid) {
		Session ses = sessionFactory.openSession();
		Transaction tr = ses.beginTransaction();
		UserDetails ud = (UserDetails)ses.get(UserDetails.class, uid);
		ses.delete(ud);
		//tr.commit();
		//ses.close();
		
	}


	public UserDetails getUserById(String uid) {
		return (UserDetails)sessionFactory.openSession().get(UserDetails.class, uid);
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<UserDetails> getUsers() {
		Session session=sessionFactory.getCurrentSession();
		Query qr = session.createQuery("from UserDetails order by isonline desc");
		List<UserDetails> users=qr.getResultList();
		System.out.println("users is" + users);
		//session.close();
		return users;
	}
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	@Transactional
	private String generateUserId(){		
	String newUid="";
		Session ss = sessionFactory.openSession();
		Transaction t=ss.beginTransaction();
		
		Query qq = ss.createQuery("from UserDetails");
		if(qq.list().isEmpty())
		{
			newUid="USR00001";
		}
		else{	
			Query q = ss.createQuery("select max(userid) from UserDetails");			
			String prevId = q.list().get(0).toString();
			//String prevId = data.get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);
			id=id+1;
			if(id<=9)
				newUid="USR0000"+id;
			else if(id<=99)
				newUid="USR000"+id;
			else if(id<=999)
				newUid="USR00"+id;
			else if(id<=9999)
				newUid="USR0"+id;
			else
				newUid="USR"+id;		
			System.out.print("\nGenerated : "+newUid);
			t.commit();				
		}
		ss.close();	
		return newUid;
	}
	

	@SuppressWarnings({ "deprecation", "rawtypes" })
	@Transactional
	public UserDetails logincheck(UserDetails ud) {
		
		Session ses = sessionFactory.openSession();
		Query qry = ses.createQuery("from UserDetails where userid=? and password=?");
		qry.setString(0, ud.getUserid());
		qry.setString(1, ud.getPassword());
		UserDetails validuser = (UserDetails)qry.uniqueResult();
		//logger.debug("Valid user : " + validuser.getRole());
		ses.close();
		return validuser;
		
	}
	
	@Transactional
	public UserDetails registerUser(UserDetails ud){
		Session ses = sessionFactory.openSession();
		Transaction tr = ses.beginTransaction();
		ud.setUserid(generateUserId());
		ses.save(ud);
		tr.commit();
		ses.close();
		return ud;
	}
	
	@Transactional
	public  UserDetails updateUser1(UserDetails ud){
		Session ses = sessionFactory.openSession();
		Transaction tr = ses.beginTransaction();
		ses.update(ud);
		tr.commit();
		ses.close();	
		return ud;
	}


}
