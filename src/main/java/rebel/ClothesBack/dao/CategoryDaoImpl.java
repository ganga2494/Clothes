package rebel.ClothesBack.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import rebel.ClothesBack.model.Category;

@Repository("categoryDao")
public class CategoryDaoImpl  implements CategoryDao
{

	@Autowired
	private SessionFactory sessionfactory;
	
	public void setSessionFactory(SessionFactory sessionfactory)
	{
		this.sessionfactory= sessionfactory;
	}
	
	public String  list()
	{
		//creating session object    
				Session session=sessionfactory.openSession();    
				    
				//creating transaction object    
				Transaction t=session.beginTransaction();    
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) session.createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		Gson gson=new Gson();
		String data=gson.toJson(listCategory);
		t.commit();//transaction is commited    
		session.close();  
		
		return data;
	}
	
	
	
	
		public void saveOrUpdate(Category category) {
		//creating session object    
				Session session=sessionfactory.openSession();    
				    
				//creating transaction object    
				Transaction t=session.beginTransaction();    
		session.saveOrUpdate(category);
		
		t.commit();//transaction is commited    
		session.close();  
		
	
	}
		
		
		public void delete(String id) {
			//creating session object    
					Session session=sessionfactory.openSession();    
					    
					//creating transaction object    
					Transaction t=session.beginTransaction();    
			Category CategoryToDelete = new Category();
			CategoryToDelete.setId(id);
			session.delete(CategoryToDelete);
			t.commit();//transaction is commited    
			session.close();  
			
		}


		public Category get(String id) {
			//creating session object    
					Session session=sessionfactory.openSession();    
					    
					//creating transaction object    
					Transaction t=session.beginTransaction();    
			String hql = "from"+" Category"+" where id=" + "'"+id+"'";
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<Category> listCategory = (List<Category>) query.list();
			
			if (listCategory != null && !listCategory.isEmpty()) {
				return listCategory.get(0);
			}
			t.commit();//transaction is commited    
			session.close();  
			
			return null;
		}
		
		

	
	
}
