package rebel.web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import rebel.web.model.Jobreg;

@Repository
@EnableTransactionManagement
@Transactional

public class JobrDaoImpl implements JobrDao {
	
	@Autowired
	 SessionFactory sessionFactory; 


	
	public void addJobr(Jobreg jobr) {
		
		System.out.println("Jobr dao impl" +  jobr);
		
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(jobr);
		
	}
		
		
	}


