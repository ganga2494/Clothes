package rebel.ClothesBack.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rebel.ClothesBack.model.AdminProduct;
import rebel.ClothesBack.model.Cart;
import rebel.ClothesBack.model.UserDetail;

@Repository
public class CartDaoImpl implements CartDao
{
	@Autowired
	private SessionFactory sessionFactory;

	 public void setSessionFactory(SessionFactory sessionFactory) {
	     this.sessionFactory = sessionFactory;
	 }
	 public void insertCart(Cart c1)
		{
			//creating session object    
			Session session=sessionFactory.openSession();    
			  
			//creating transaction object    
			Transaction t=session.beginTransaction();    
			        
			session.save(c1);//persisting the object    
			    
			t.commit();//transaction is commited    
			session.close();  
			
		}

	 @Transactional
		public List<Cart> get(String id) {
			//creating session object    
			Session session=sessionFactory.openSession();    
					    
			//creating transaction object    
			Transaction t=session.beginTransaction();    
			String hql = "from"+" Cart"+" where cartuser=" + "'"+id+"'";
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<Cart> listCategory = (List<Cart>) query.list();
			
			if (listCategory != null && !listCategory.isEmpty()) {
				
					return listCategory;
			}
			t.commit();//transaction is commited    
			session.close();  
			
			return null;
		}


	 public List<AdminProduct> getparticulerProd(int id) {
			//creating session object    
					Session session=sessionFactory.openSession();    
					    
					//creating transaction object    
					Transaction t=session.beginTransaction();    
			String hql = "from"+" AdminProduct "+" where aproductId=" +id;
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<AdminProduct> listCategory = (List<AdminProduct>) query.list();
			
			if (listCategory != null && !listCategory.isEmpty()) {
				
							return listCategory;
			}
			t.commit();//transaction is commited    
			session.close();  
			
			return null;
		}

		
		@Transactional
		public List<UserDetail> getUser(String id) {
			//creating session object    
					Session session=sessionFactory.openSession();    
					    
					//creating transaction object    
					Transaction t=session.beginTransaction();    
			String hql = "from"+" UserDetails "+" where userName=" +"'"+id+"'";
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<UserDetail> listCategory = (List<UserDetail>) query.list();
			
			if (listCategory != null && !listCategory.isEmpty()) {
				
				return listCategory;
			}
			t.commit();//transaction is commited    
			session.close();  
			
			return null;
		}
		
		
		
	


}
