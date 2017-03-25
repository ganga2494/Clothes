package rebel.web.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import rebel.web.model.Blog;
import rebel.web.model.Queanforum;

@Repository("forumdao")
@EnableTransactionManagement
@Transactional

public  class QueanforumImpl  implements Queanforumdao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	

	
	public void addQuestion(Queanforum forum) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println("session="+session);
		session.saveOrUpdate(forum);
		System.out.println("data successfully saved");
	}
		

		

	
	public List<Queanforum> viewQuestions() {
		
		
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings ({"unchecked","deprecation"})
		List<Queanforum> list = session.createCriteria(Queanforum.class).list();
		return list;
	}

	
	public void updateQuestion(Queanforum forum) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(forum);
		
	}

	
	public void deleteQuestion(int qid) {
		Session session=sessionFactory.getCurrentSession();
		Queanforum forum=(Queanforum)session.get(Queanforum.class,new Integer(qid));
		session.delete(forum);
		
		
	}

	
	public Queanforum getQuestion(int qid) {
		
		return null;
	}

	
}
