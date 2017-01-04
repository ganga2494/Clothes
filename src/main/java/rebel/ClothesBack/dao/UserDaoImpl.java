package rebel.ClothesBack.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rebel.ClothesBack.model.UserDetail;


@Repository("userdaoimpl")
public class UserDaoImpl implements UserDao
{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	/*public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }*/
	 
	@Transactional
	public void saveorupdate(UserDetail user) 
	{
		System.out.println("I am in user Dao Class"+sessionFactory);
		
		Session sess = sessionFactory.getCurrentSession();
		System.out.println("session="+sess);
		//predefined function
		sess.save(user);
		
		System.out.println("user data successfully done");
		
	}

	
	@SuppressWarnings("unchecked")
	public List<UserDetail> viewcustomerd() {
	
		System.out.println("view custome details");
		Session sess = sessionFactory.getCurrentSession();
		System.out.println("session="+sess);
		List<UserDetail> list = sess.createCriteria(UserDetail.class).list(); 	
		return list;
	}
	
}
  